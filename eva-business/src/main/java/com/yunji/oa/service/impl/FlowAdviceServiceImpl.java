
package com.yunji.oa.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.common.utils.CharacterCaseUtils;
import com.yunji.oa.dao.IFlowAdviceDAO;
import com.yunji.oa.model.FlowAdvice;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IFlowAdviceService;
import com.yunji.oa.util.IdGenerator;

@SuppressWarnings("unchecked")
@Service("FlowAdviceServiceImpl")

public class FlowAdviceServiceImpl extends AbstractPageService<IFlowAdviceDAO,FlowAdvice> implements IFlowAdviceService {

	@Autowired
	private IFlowAdviceDAO flowAdviceDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IFlowAdviceDAO getDao() {
		return flowAdviceDAO;
	}
	@Override
	public void addAdvice(String docId,User user,String status,String advice) {
		FlowAdvice flowAdvice = new FlowAdvice();
		flowAdvice.setAdvice(advice);
		flowAdvice.setId(IdGenerator.createNewId());
		flowAdvice.setDocId(docId);
		flowAdvice.setUserId(user.getId());
		flowAdvice.setRealName(user.getRealName());
		flowAdvice.setStatus(status);
		
		flowAdviceDAO.insert(flowAdvice);
	}
	@Override
	public List<FlowAdvice> findLimit(String property, Object value,
			String orderBy, String sortBy, Integer limit) {
		property = CharacterCaseUtils.toUnderlineCase(property);
		return flowAdviceDAO.findLimit(property, value, orderBy, sortBy, limit);
	}
}
