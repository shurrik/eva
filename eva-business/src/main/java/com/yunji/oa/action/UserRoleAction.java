
package com.yunji.oa.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.oa.model.OpLog;
import com.yunji.oa.model.Role;
import com.yunji.oa.model.RoleResource;
import com.yunji.oa.model.User;
import com.yunji.oa.model.UserRole;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.service.IRoleService;
import com.yunji.oa.service.IUserRoleService;
import com.yunji.oa.service.IUserService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class UserRoleAction extends AbstractAdminController<IUserRoleService>{

    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private IUserService userService;  
    @Autowired
    private IRoleService roleService;       
    @Autowired
    private IOpLogService opLogService;
    @RequestMapping(value="/userrole/list")
    public String list(UserRole userRole,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(userRole); 	
    	BizData4Page<UserRole> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("userRole", userRole);
    	return "/module/userrole/list";
    }    
    
    @RequestMapping(value="/userrole/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("userRole", new UserRole());
        return "module/userrole/edit";
    }    
    
//    @RequestMapping(value="/userrole/edit")
//    public String edit(String userId,ModelMap model,HttpServletRequest request,HttpServletResponse response){
//    	
//    	User user = userService.fetch(userId);
//    	List<Role> roles = roleService.findAll();
//    	model.addAttribute("user", user);
//    	model.addAttribute("roles", roles);
//        return "module/userrole/edit";
//    }     
//    
    @RequestMapping(value="/userrole/edit")
    public String edit(String userId,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	User user = userService.fetch(userId);
    	List<UserRole> userroles = userRoleService.findList("userId", userId);
    	Map userRoleMap = new HashMap();
    	List<Role> roles = roleService.findAll();
    	model.addAttribute("roles", roles);
    	for(UserRole userrole:userroles)
    	{
    		userRoleMap.put(userrole.getRoleId(),userrole.getRoleId());
    	}
    	
    	model.addAttribute("userRoleMap", userRoleMap);
    	model.addAttribute("user", user);
    	model.addAttribute("roleids", getRoleids(userroles));
        return "module/userrole/edit";
    }  
    
    private String getRoleids(List<UserRole> userroles)
    {
    	StringBuffer sb = new StringBuffer();
    	
    	for(int i=0;i<userroles.size();i++)
    	{
    		sb.append(userroles.get(i).getRoleId());
    		if(i<userroles.size()-1)
    		{
    			sb.append(",");
    		}
    	}
    	//System.out.println(sb);
    	return sb.toString();
    }
    
/*    @RequestMapping(value="/userrole/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	UserRole userRole = userRoleService.fetch(id);
    	model.addAttribute("userRole", userRole);
        return "module/userrole/edit";
    } */   
    
    @RequestMapping(value="/userrole/save")
    @ResponseBody
    public String save(String userId,String roleIds,HttpServletRequest request,UserRole userRole){
    	
    	User user = userService.fetch(userId);
    	String[] roleIdArr = roleIds.split(",");
    	userRoleService.deleteByProperty("userId", user.getId());
    	for(String roleId:roleIdArr)
    	{
    		UserRole ur = new UserRole();
    		ur.setId(IdGenerator.createNewId());
    		ur.setUserId(user.getId());
    		ur.setRealName(user.getRealName());
    		ur.setRoleId(roleId);
    		userRoleService.add(ur);
    	}    	
		opLogService.createNew("用户角色", "用户姓名："+user.getRealName(), getCurrentUser());
    	return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    }    
    
    @RequestMapping(value="/userrole/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	userRoleService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(UserRole userRole)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("userId", userRole.getUserId());		
		conditions.put("realName", userRole.getRealName());		
		conditions.put("roleId", userRole.getRoleId());		
		conditions.put("roleName", userRole.getRoleName());		
    	return conditions;
    }

    @Override
    protected IUserRoleService getMainService() {
        return userRoleService;
    }

    @Override
    protected String getMainObjName() {
        return "userrole";
    }

    @Override
    protected String getViewTitle() {
        return "userrole";
    }
}
