
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IFlowUserDAO;
import com.yunji.oa.model.FlowUser;
import com.yunji.oa.service.IFlowUserService;

@SuppressWarnings("unchecked")
@Service("FlowUserServiceImpl")

public class FlowUserServiceImpl extends AbstractPageService<IFlowUserDAO,FlowUser> implements IFlowUserService {

	@Autowired
	private IFlowUserDAO flowUserDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IFlowUserDAO getDao() {
		return flowUserDAO;
	}
}
