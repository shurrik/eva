
package com.yunji.oa.service;
import java.util.Map;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IBackLogDAO;
import com.yunji.oa.model.BackLog;
import com.yunji.oa.model.Flow;
public interface IBackLogService extends IBaseService<IBackLogDAO,BackLog>,IPageService<IBackLogDAO,BackLog>{

	public void createLog(String docId,Flow flow,String subject,String remark);
	
	public void updateLog(String docId,Flow flow,String subject,String remark);
	
	public BizData4Page queryFlowPage(Map<String, Object> conditions, int curPage, int offset, int rows);
}