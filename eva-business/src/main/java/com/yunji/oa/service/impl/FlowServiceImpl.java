
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IFlowDAO;
import com.yunji.oa.model.Flow;
import com.yunji.oa.service.IFlowService;

@SuppressWarnings("unchecked")
@Service("FlowServiceImpl")

public class FlowServiceImpl extends AbstractPageService<IFlowDAO,Flow> implements IFlowService {

	@Autowired
	private IFlowDAO flowDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IFlowDAO getDao() {
		return flowDAO;
	}
	@Override
	public void updateTableStatus(Flow flow, String id, String status) {
		// TODO Auto-generated method stub
		flowDAO.updateTableStatus(flow.getTableName(), status, id);
	}
}
