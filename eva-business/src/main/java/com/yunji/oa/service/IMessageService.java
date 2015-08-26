
package com.yunji.oa.service;
import java.util.List;
import java.util.Map;

import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IMessageDAO;
import com.yunji.oa.model.Message;
import com.yunji.oa.model.User;
import com.yunji.oa.util.Constants;
public interface IMessageService extends IBaseService<IMessageDAO,Message>,IPageService<IMessageDAO,Message>{

	public void createMsg(User from,User to,String title,String content);
	public void createSysMsg(User to,String title,String content);
	public void createSysMsg(User to,String title,String content,String url);
	public void readMsg(String id);
	
	public List<Message> findNewMsgs(String toId);

//	public Message findusermassage(String doname);
	
	public List<Message> findMessagesByToName(String toName);
	
	public List<Message> findUnreadMsgs(String toId);

}