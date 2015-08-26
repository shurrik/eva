
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IUserRoleDAO;
import com.yunji.oa.model.UserRole;
import com.yunji.oa.service.IUserRoleService;

@SuppressWarnings("unchecked")
@Service("UserRoleServiceImpl")

public class UserRoleServiceImpl extends AbstractPageService<IUserRoleDAO,UserRole> implements IUserRoleService {

	@Autowired
	private IUserRoleDAO userRoleDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IUserRoleDAO getDao() {
		return userRoleDAO;
	}
}
