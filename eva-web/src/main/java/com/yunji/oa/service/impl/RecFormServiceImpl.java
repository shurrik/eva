
package com.yunji.oa.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.yunji.common.domain.view.BizData4Page;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.install.util.StringUtil;
import com.yunji.oa.dao.IRecFormDAO;
import com.yunji.oa.model.BackLog;
import com.yunji.oa.model.Flow;
import com.yunji.oa.model.RecForm;
import com.yunji.oa.service.IFlowService;
import com.yunji.oa.service.IRecFormService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.DateUtils;
import com.yunji.oa.util.HtmlRegexpUtil;

@SuppressWarnings("unchecked")
@Service("RecFormServiceImpl")

public class RecFormServiceImpl extends AbstractPageService<IRecFormDAO,RecForm> implements IRecFormService {

	@Autowired
	private IRecFormDAO recFormDAO;
	@Autowired
	private IFlowService flowService;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IRecFormDAO getDao() {
		return recFormDAO;
	}
	@Override
	public void callback(BackLog backLog,Flow flow) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<RecForm> queryUnfinished(Map condition) {
		
		return recFormDAO.queryUnfinished(condition);
	}
	@Override
	public List<RecForm> queryRemind() {		
		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
		Map<String, Object> condition = new HashMap();
		condition.put("pressHandle",true);
		condition.put("status", flow.getEndStatus());
		condition.put("remindTime", DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		return recFormDAO.queryRemind(condition);
	}
	@Override
	public List<RecForm> queryExport(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return recFormDAO.queryExport(condition);
	}
/*	@Override
	public List<RecForm> queryByCreateDate(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return recFormDAO.queryByCreateDate(condition);
	}*/
	
    @Override
    public BizData4Page queryByCreateDate(Map<String, Object> conditions, int curPage, int offset, int rows) {
/*        if(getEnableDataPerm()) { //需要进行数据权限处理
            String whereSql = dataPermService.makeDataPermSql(resUri);
            if (whereSql != null) {
                conditions.put("whereSql", whereSql);
            }
        }*/

        List<RecForm> mainData = getDao().queryByCreateDate(conditions, offset, rows);
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
    
    @Override
    public void add(RecForm recForm) {
    	
        getDao().insert(this.processRecForm(recForm));
    }
    
    @Override
    public void update(RecForm recForm) {
    	
        getDao().update(this.processRecForm(recForm));
    }    
    
    private RecForm processRecForm(RecForm recForm)
    {
    	if(!StringUtil.isEmpty(recForm.getContent())){
    		recForm.setContent(processHtml(recForm.getContent()));
    	}
    	if(!StringUtil.isEmpty(recForm.getRemark())){
    		recForm.setRemark(processHtml(recForm.getRemark()));
    	}
    	return recForm;
    }
    
    /** 只保留粗体，其余html标签全部去除
     * @param content
     * @return
     */
    private String processHtml(String content)
    {
    	if(content==null)
    	{
    		content = "";
    	}
    	content = content.trim();
    	content = content.replaceAll("<strong>", "щ");
    	content = content.replaceAll("</strong>", "Ψ");
    	content = HtmlRegexpUtil.filterHtml(content);
    	content = HtmlRegexpUtil.filternbsp(content);
    	content = content.replaceAll("щ", "<strong>");
    	content = content.replaceAll("Ψ", "</strong>");
    	content = content.replaceAll("</strong><strong>", "");
    	return content;
    }
	@Override
	public void cancelDeadline(String id) {
		// TODO Auto-generated method stub
		getDao().cancelDeadline(id);
	}
	@Override
	public List<RecForm> findnoSearch(String no) {
		return getDao().findnoSearch(no);
	}

}
