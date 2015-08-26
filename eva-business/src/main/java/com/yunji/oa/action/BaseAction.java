package com.yunji.oa.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.support.WebApplicationObjectSupport;

import com.yunji.oa.model.User;
import com.yunji.oa.service.IUserService;

public class BaseAction extends WebApplicationObjectSupport{
    @Autowired
    private IUserService userService;
    
    public User getCurrentUser()
    {
    	
		Object userDetails = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String userName="";
		if( userDetails instanceof String){
			userName = (String)userDetails;
		}else if(userDetails instanceof UserDetails){
			userName = ((UserDetails)userDetails).getUsername();
		}
		User user = userService.findOne("userName", userName);
    	/*User user = userService.findOne("realName", "张明明");*/
    	return user;
    }
}
