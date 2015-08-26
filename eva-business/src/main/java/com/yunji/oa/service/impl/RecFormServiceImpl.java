
package com.yunji.oa.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IRecFormDAO;
import com.yunji.oa.model.BackLog;
import com.yunji.oa.model.Flow;
import com.yunji.oa.model.RecForm;
import com.yunji.oa.service.IBackLogCallback;
import com.yunji.oa.service.IFlowService;
import com.yunji.oa.service.IRecFormService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.DateUtils;

@SuppressWarnings("unchecked")
@Service("RecFormServiceImpl")

public class RecFormServiceImpl extends AbstractPageService<IRecFormDAO,RecForm> implements IRecFormService {

	@Autowired
	private IRecFormDAO recFormDAO;
	@Autowired
	private IFlowService flowService;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IRecFormDAO getDao() {
		return recFormDAO;
	}
	@Override
	public void callback(BackLog backLog,Flow flow) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<RecForm> queryUnfinished(Map condition) {
		
		return recFormDAO.queryUnfinished(condition);
	}
	@Override
	public List<RecForm> queryRemind() {
		// TODO Auto-generated method stub
		
		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
		Map<String, Object> condition = new HashMap();
		condition.put("status", flow.getEndStatus());
		condition.put("remindTime", DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		return recFormDAO.queryRemind(condition);
	}
}
