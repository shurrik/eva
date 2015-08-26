
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IUserMsgCountDAO;
import com.yunji.oa.model.User;
import com.yunji.oa.model.UserMsgCount;
public interface IUserMsgCountService extends IBaseService<IUserMsgCountDAO,UserMsgCount>,IPageService<IUserMsgCountDAO,UserMsgCount>{

	public void createNew(User user);
	
	public void increaseUserUnreadForIncCount(String userId,Integer incCount);
	
	public void descreaseUserUnreadForDesCount(String userId,Integer desCount);
	
	public void incUserUnread(String userId);
	
	public void desUserUnread(String userId);
}