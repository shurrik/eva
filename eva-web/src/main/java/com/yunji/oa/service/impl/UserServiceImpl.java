
package com.yunji.oa.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IUserDAO;
import com.yunji.oa.model.RecForm;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IUserMsgCountService;
import com.yunji.oa.service.IUserService;
import com.yunji.oa.util.IdGenerator;

@SuppressWarnings("unchecked")
@Service("UserServiceImpl")

public class UserServiceImpl extends AbstractPageService<IUserDAO,User> implements IUserService {
	
	@Autowired
	private IUserDAO userDAO;
	@Autowired
	private IUserMsgCountService userMsgCountService;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IUserDAO getDao() {
		return userDAO;
	}
	@Override
	public void incMsgUnread(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void decMsgUnread(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User createNew(User user) {
		// TODO Auto-generated method stub
		Md5PasswordEncoder md5 = new Md5PasswordEncoder(); 
		user.setId(IdGenerator.createNewId());
		user.setPassword(md5.encodePassword(user.getPassword(), user.getUserName()));
		userDAO.insert(user);
		userMsgCountService.createNew(user);
		return user;
	}
	@Override
	public List<User> findRoleUser() {
		 List<User> user = userDAO.findRoleUser();
		return user;
	}
	
   
	

}
