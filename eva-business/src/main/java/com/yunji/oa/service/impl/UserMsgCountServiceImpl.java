
package com.yunji.oa.service.impl;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IUserMsgCountDAO;
import com.yunji.oa.model.User;
import com.yunji.oa.model.UserMsgCount;
import com.yunji.oa.service.IUserMsgCountService;
import com.yunji.oa.util.IdGenerator;

@SuppressWarnings("unchecked")
@Service("UserMsgCountServiceImpl")

public class UserMsgCountServiceImpl extends AbstractPageService<IUserMsgCountDAO,UserMsgCount> implements IUserMsgCountService {

	@Autowired
	private IUserMsgCountDAO userMsgCountDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IUserMsgCountDAO getDao() {
		return userMsgCountDAO;
	}
	@Override
	public void createNew(User user) {
		UserMsgCount umc = new UserMsgCount();
		umc.setId(IdGenerator.createNewId());
		umc.setUnread(0);
		umc.setUserId(user.getId());
		userMsgCountDAO.insert(umc);
	}
	@Override
	public void increaseUserUnreadForIncCount(String userId, Integer incCount) {
		// TODO Auto-generated method stub
		UserMsgCount umc = this.findOne("userId", userId);
		umc.setUnread(umc.getUnread()+incCount);
		umc.setUpdateDate(new Date());
		userMsgCountDAO.update(umc);
		
	}
	@Override
	public void descreaseUserUnreadForDesCount(String userId, Integer desCount) {
		// TODO Auto-generated method stub
		UserMsgCount umc = this.findOne("userId", userId);
		if(umc.getUnread()>desCount)
		{
			umc.setUnread(umc.getUnread()-desCount);
			umc.setUpdateDate(new Date());
			userMsgCountDAO.update(umc);
		}
	}
	@Override
	public void incUserUnread(String userId) {
		increaseUserUnreadForIncCount(userId,1);
		
	}
	@Override
	public void desUserUnread(String userId) {
		// TODO Auto-generated method stub
		descreaseUserUnreadForDesCount(userId, 1);
	}
}
