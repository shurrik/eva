
package com.yunji.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IFactaleaderDAO;
import com.yunji.oa.model.Factaleader;
import com.yunji.oa.service.IFactaleaderService;

@SuppressWarnings("unchecked")
@Service("FactaleaderServiceImpl")

public class FactaleaderServiceImpl extends AbstractPageService<IFactaleaderDAO,Factaleader> implements IFactaleaderService {

	@Autowired
	private IFactaleaderDAO factaleaderDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IFactaleaderDAO getDao() {
		return factaleaderDAO;
	}
	@Override
	public int checkByname(Factaleader factaleader) {
		// TODO Auto-generated method stub
		return factaleaderDAO.checkByname(factaleader);
	}
}
