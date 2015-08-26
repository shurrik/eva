
package com.yunji.oa.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IBackLogDAO;
import com.yunji.oa.model.BackLog;
import com.yunji.oa.model.Flow;
import com.yunji.oa.service.IBackLogService;
import com.yunji.oa.util.IdGenerator;

@SuppressWarnings("unchecked")
@Service("BackLogServiceImpl")

public class BackLogServiceImpl extends AbstractPageService<IBackLogDAO,BackLog> implements IBackLogService {

	@Autowired
	private IBackLogDAO backLogDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IBackLogDAO getDao() {
		return backLogDAO;
	}
	@Override
	public void createLog(String docId, Flow flow, String subject, String remark) {
		
		BackLog log = new BackLog();
		log.setId(IdGenerator.createNewId());
		log.setDocId(docId);
		log.setFlowId(flow.getId());
		log.setFlowName(flow.getName());
		log.setSubject(subject);
		log.setRemark(remark);
		log.setStatus(flow.getStartStatus());
		log.setNameSpace(flow.getNameSpace());
		backLogDAO.insert(log);
	}
	@Override
	public void updateLog(String docId, Flow flow, String subject, String remark) {
		// TODO Auto-generated method stub
		BackLog log = this.findOne("docId", docId);
		log.setSubject(subject);
		log.setRemark(remark);
		log.setStatus(flow.getStartStatus());
		this.update(log);
	}	
	
	@Override
	public BizData4Page queryFlowPage(Map<String, Object> conditions,
			int curPage, int offset, int rows) {
        List<BackLog> mainData = backLogDAO.queryFlowPage(conditions, offset, rows);
//        int records =  getDao().count(conditions);
        int records =  getDao().countFlow(conditions);
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
