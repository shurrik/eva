
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IRoleResourceDAO;
import com.yunji.oa.model.RoleResource;
import com.yunji.oa.service.IRoleResourceService;

@SuppressWarnings("unchecked")
@Service("RoleResourceServiceImpl")

public class RoleResourceServiceImpl extends AbstractPageService<IRoleResourceDAO,RoleResource> implements IRoleResourceService {

	@Autowired
	private IRoleResourceDAO roleResourceDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IRoleResourceDAO getDao() {
		return roleResourceDAO;
	}
}
