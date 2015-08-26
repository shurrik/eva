
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IprocessunitDAO;
import com.yunji.oa.model.Processunit;
import com.yunji.oa.service.IprocessunitService;

@SuppressWarnings("unchecked")
@Service("processunitServiceImpl")

public class processunitServiceImpl extends AbstractPageService<IprocessunitDAO,Processunit> implements IprocessunitService {

	@Autowired
	private IprocessunitDAO processunitDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IprocessunitDAO getDao() {
		return processunitDAO;
	}
}
