
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IDocRecDeptDAO;
import com.yunji.oa.model.DocRecDept;
import com.yunji.oa.service.IDocRecDeptService;

@SuppressWarnings("unchecked")
@Service("DocRecDeptServiceImpl")

public class DocRecDeptServiceImpl extends AbstractPageService<IDocRecDeptDAO,DocRecDept> implements IDocRecDeptService {

	@Autowired
	private IDocRecDeptDAO docRecDeptDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IDocRecDeptDAO getDao() {
		return docRecDeptDAO;
	}
}
