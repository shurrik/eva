
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IUserDAO;
import com.yunji.oa.model.User;
public interface IUserService extends IBaseService<IUserDAO,User>,IPageService<IUserDAO,User>{

	
	public User createNew(User user);
	public void incMsgUnread(User user);//增加用户未读消息数
	public void decMsgUnread(User user);//减少用户未读消息数
}