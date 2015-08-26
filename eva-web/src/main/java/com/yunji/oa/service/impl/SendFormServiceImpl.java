
package com.yunji.oa.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.domain.view.BizData4Page;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.ISendFormDAO;
import com.yunji.oa.model.BackLog;
import com.yunji.oa.model.Flow;
import com.yunji.oa.model.SendForm;
import com.yunji.oa.service.ISendFormService;

@SuppressWarnings("unchecked")
@Service("SendFormServiceImpl")

public class SendFormServiceImpl extends AbstractPageService<ISendFormDAO,SendForm> implements ISendFormService {

	@Autowired
	private ISendFormDAO sendFormDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ISendFormDAO getDao() {
		return sendFormDAO;
	}
	
	@Override
	public void callback(BackLog backLog,Flow flow) {
		// TODO Auto-generated method stub
		
	}	

    @Override
    public BizData4Page queryRecordPage(Map<String, Object> conditions, int curPage, int offset, int rows) {

        List<SendForm> mainData = getDao().queryRecordPage(conditions, offset, rows);
        int records =  getDao().count(conditions);
        BizData4Page bizData4Page = new BizData4Page();
        bizData4Page.setRows(mainData);
        bizData4Page.setPage(curPage);
        bizData4Page.setRecords(records);

        int total = records / rows;
        int mod = records % rows;
        if(mod > 0){
            total = total + 1;
        }
        bizData4Page.setTotal(total);

        return bizData4Page;
    }	
}
