
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IDeptDAO;
import com.yunji.oa.model.Dept;
import com.yunji.oa.service.IDeptService;

@SuppressWarnings("unchecked")
@Service("DeptServiceImpl")

public class DeptServiceImpl extends AbstractPageService<IDeptDAO,Dept> implements IDeptService {

	@Autowired
	private IDeptDAO deptDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IDeptDAO getDao() {
		return deptDAO;
	}
}
