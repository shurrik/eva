
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IRoleDAO;
import com.yunji.oa.model.Role;
import com.yunji.oa.service.IRoleService;

@SuppressWarnings("unchecked")
@Service("RoleServiceImpl")

public class RoleServiceImpl extends AbstractPageService<IRoleDAO,Role> implements IRoleService {

	@Autowired
	private IRoleDAO roleDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IRoleDAO getDao() {
		return roleDAO;
	}
}
