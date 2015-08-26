
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IAcessoriesDAO;
import com.yunji.oa.model.Acessories;
import com.yunji.oa.service.IAcessoriesService;

@SuppressWarnings("unchecked")
@Service("AcessoriesServiceImpl")

public class AcessoriesServiceImpl extends AbstractPageService<IAcessoriesDAO,Acessories> implements IAcessoriesService {

	@Autowired
	private IAcessoriesDAO acessoriesDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IAcessoriesDAO getDao() {
		return acessoriesDAO;
	}
}
