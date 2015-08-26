
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IRecFormDAO;
import com.yunji.oa.dao.ISendFormDAO;
import com.yunji.oa.model.BackLog;
import com.yunji.oa.model.Flow;
import com.yunji.oa.model.RecForm;
import com.yunji.oa.model.SendForm;
import com.yunji.oa.service.IRecFormService;
import com.yunji.oa.service.ISendFormService;

@SuppressWarnings("unchecked")
@Service("SendFormServiceImpl")

public class SendFormServiceImpl extends AbstractPageService<ISendFormDAO,SendForm> implements ISendFormService {

	@Autowired
	private ISendFormDAO sendFormDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ISendFormDAO getDao() {
		return sendFormDAO;
	}
	
	@Override
	public void callback(BackLog backLog,Flow flow) {
		// TODO Auto-generated method stub
		
	}	
}
