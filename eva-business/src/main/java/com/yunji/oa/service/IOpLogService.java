
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IOpLogDAO;
import com.yunji.oa.model.OpLog;
import com.yunji.oa.model.User;
public interface IOpLogService extends IBaseService<IOpLogDAO,OpLog>,IPageService<IOpLogDAO,OpLog>{


	public	void createNew(String title,String content,User user);
}