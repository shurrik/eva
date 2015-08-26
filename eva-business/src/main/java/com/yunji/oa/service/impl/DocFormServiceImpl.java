
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IDocFormDAO;
import com.yunji.oa.model.DocForm;
import com.yunji.oa.service.IDocFormService;

@SuppressWarnings("unchecked")
@Service("DocFormServiceImpl")

public class DocFormServiceImpl extends AbstractPageService<IDocFormDAO,DocForm> implements IDocFormService {

	@Autowired
	private IDocFormDAO docFormDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IDocFormDAO getDao() {
		return docFormDAO;
	}
}
