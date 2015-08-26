
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IOpLogDAO;
import com.yunji.oa.model.OpLog;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.util.IdGenerator;

@SuppressWarnings("unchecked")
@Service("OpLogServiceImpl")

public class OpLogServiceImpl extends AbstractPageService<IOpLogDAO,OpLog> implements IOpLogService {

	@Autowired
	private IOpLogDAO opLogDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IOpLogDAO getDao() {
		return opLogDAO;
	}
	@Override
	public void createNew(String title, String content, User user) {
		// TODO Auto-generated method stub
		OpLog oplog=new OpLog();
		oplog.setTitle(title);
		oplog.setContent(content);
		oplog.setId(IdGenerator.createNewId());
		oplog.setRealName(user.getRealName());
		oplog.setUserName(user.getUserName());
		try {
			this.insert(oplog);
		} catch (Exception e) {
			System.out.println(e.toString());
		}		
		
	}
}
