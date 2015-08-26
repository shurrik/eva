package com.yunji.oa.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunji.oa.dao.IChangePwdDAO;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IChangePwdService;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.service.IUserService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.JsonResult;

@Controller
public class ChangepwdAction extends AbstractAdminController<IChangePwdService>{
	@Autowired
    private IUserService userService;
	  @Autowired
	    private IOpLogService opLogService;
    @Autowired
    private IChangePwdDAO changePwdDAO;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IChangePwdDAO getChangePwdDAO() {
		return changePwdDAO;
	}

	public void setChangePwdDAO(IChangePwdDAO changePwdDAO) {
		this.changePwdDAO = changePwdDAO;
	}

	@Override
	protected IChangePwdService getMainService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getMainObjName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getViewTitle() {
		// TODO Auto-generated method stub
		return null;
	}


	  @RequestMapping(value="/changepwd")
	    public String edit(HttpServletRequest request,HttpServletResponse response){
	    	
	        return "changepwd";
	    }   
	  @RequestMapping(value="/user/changepwd")
	  @ResponseBody
	  public String doedit(HttpServletRequest request,HttpServletResponse response,String j_pwschange_secpassword){
		  User user =getCurrentUser(request);
//		  String newMD5pwd=MD5Util.MD5(j_pwschange_secpassword);
		  Md5PasswordEncoder md5 = new Md5PasswordEncoder(); 
		  user.setPassword(md5.encodePassword(j_pwschange_secpassword, user.getUserName()));
//		  user.setPassword(newMD5pwd);
		  boolean isAddNew = StringUtils.isBlank(user.getId())?true:false;
			if(isAddNew)
			{
				userService.createNew(user);
			}
			else
			{
				userService.update(user);
			}		
			opLogService.createNew("修改密码", "", getCurrentUser(request));
		  return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	  }   

}
