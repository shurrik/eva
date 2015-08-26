
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IDictionaryDAO;
import com.yunji.oa.model.Dictionary;
import com.yunji.oa.service.IDictionaryService;

@SuppressWarnings("unchecked")
@Service("DictionaryServiceImpl")

public class DictionaryServiceImpl extends AbstractPageService<IDictionaryDAO,Dictionary> implements IDictionaryService {

	@Autowired
	private IDictionaryDAO dictionaryDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IDictionaryDAO getDao() {
		return dictionaryDAO;
	}
}
