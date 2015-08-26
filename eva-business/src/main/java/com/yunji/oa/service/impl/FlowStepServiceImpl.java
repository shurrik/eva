
package com.yunji.oa.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IFlowStepDAO;
import com.yunji.oa.model.FlowStep;
import com.yunji.oa.service.IFlowStepService;

@SuppressWarnings("unchecked")
@Service("FlowStepServiceImpl")

public class FlowStepServiceImpl extends AbstractPageService<IFlowStepDAO,FlowStep> implements IFlowStepService {

	@Autowired
	private IFlowStepDAO flowStepDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IFlowStepDAO getDao() {
		return flowStepDAO;
	}
	@Override
	public List<FlowStep> findListByBeforeStatus(String flowId,String beforeStatus) {
		// TODO Auto-generated method stub
		Map condition = new HashMap();
		condition.put("flowId", flowId);
		condition.put("beforeStatus", beforeStatus);
		List<FlowStep> steps = this.queryList(condition, "stepOrder", "asc");
		return steps;
	}
	@Override
	public List<FlowStep> findStepsByBeforeStatus(String flowId, String userId,
			String beforeStatus) {
		return flowStepDAO.findStepsByBeforeStatus(flowId, userId, beforeStatus);
	}
	
}
