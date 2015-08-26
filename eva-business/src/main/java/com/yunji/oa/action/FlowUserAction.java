
package com.yunji.oa.action;

import java.util.HashMap;
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
import com.yunji.oa.model.FlowStep;
import com.yunji.oa.model.FlowUser;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IFlowStepService;
import com.yunji.oa.service.IFlowUserService;
import com.yunji.oa.service.IUserService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class FlowUserAction extends AbstractAdminController<IFlowUserService>{

    @Autowired
    private IFlowUserService flowUserService;
    @Autowired
    private IUserService userService; 
    @Autowired
    private IFlowStepService flowStepService; 
    
    @RequestMapping(value="/flowuser/list")
    public String list(FlowUser flowUser,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(flowUser); 	
    	BizData4Page<FlowUser> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("flowUser", flowUser);
    	return "/module/flowuser/list";
    }    
    
    @RequestMapping(value="/flowuser/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("flowUser", new FlowUser());
    	model.addAttribute("steps", flowStepService.findAll());
    	model.addAttribute("users", userService.findAll());    	
        return "module/flowuser/edit";
    }    
    
    @RequestMapping(value="/flowuser/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	FlowUser flowUser = flowUserService.fetch(id);
    	model.addAttribute("steps", flowStepService.findAll());
    	model.addAttribute("users", userService.findAll());    	
    	model.addAttribute("flowUser", flowUser);
        return "module/flowuser/edit";
    }    
    
    @RequestMapping(value="/flowuser/save")
    @ResponseBody
    public String save(HttpServletRequest request,FlowUser flowUser){
		boolean isAddNew = StringUtils.isBlank(flowUser.getId())?true:false;
		
		FlowStep step = flowStepService.fetch(flowUser.getStepId());
		User user = userService.fetch(flowUser.getUserId());
		flowUser.setFlowId(step.getFlowId());
		flowUser.setFlowName(step.getFlowName());
		flowUser.setStepId(step.getId());
		flowUser.setStepName(step.getName());
		flowUser.setUserId(user.getId());
		flowUser.setRealName(user.getRealName());
		if(isAddNew)
		{
			flowUser.setId(IdGenerator.createNewId());
			flowUserService.add(flowUser);
		}
		else
		{
			flowUserService.update(flowUser);
		}
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    }    
    
    @RequestMapping(value="/flowuser/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	flowUserService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(FlowUser flowUser)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("flowId", flowUser.getFlowId());		
		conditions.put("flowName", flowUser.getFlowName());		
		conditions.put("stepId", flowUser.getStepId());		
		conditions.put("stepName", flowUser.getStepName());		
		conditions.put("userId", flowUser.getUserId());		
		conditions.put("realName", flowUser.getRealName());		
		conditions.put("createDate", flowUser.getCreateDate());		
		conditions.put("updateDate", flowUser.getUpdateDate());		
    	return conditions;
    }

    @Override
    protected IFlowUserService getMainService() {
        return flowUserService;
    }

    @Override
    protected String getMainObjName() {
        return "flowuser";
    }

    @Override
    protected String getViewTitle() {
        return "flowuser";
    }
}
