
package com.yunji.oa.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.oa.model.BackLog;
import com.yunji.oa.model.Flow;
import com.yunji.oa.model.SendForm;
import com.yunji.oa.model.User;
import com.yunji.oa.service.BackLogCallbackStrategy;
import com.yunji.oa.service.IBackLogService;
import com.yunji.oa.service.IFlowAdviceService;
import com.yunji.oa.service.IFlowService;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.service.ISendFormService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class BackLogAction extends AbstractAdminController<IBackLogService>{

    @Autowired
    private IBackLogService backLogService;
    @Autowired
    private IFlowService flowService;
    @Autowired
    private IFlowAdviceService flowAdviceService;
    @Autowired
    private BackLogCallbackStrategy backLogCallbackStrategy;
	@Autowired
	private IOpLogService opLogService;
    @Autowired
    private ISendFormService sendFormService;
    @RequestMapping(value="/backlog/list")
    public String list(BackLog backLog,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(backLog); 	
    	BizData4Page<BackLog> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("backLog", backLog);
    	return "/module/backlog/list";
    }    
    
    
    @RequestMapping(value="/backlog/listflow")
    public String listFlow(BackLog backLog,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

    	User user = getCurrentUser(request);
        //获取参数
    	Map<String, Object> conditions = getQueryMap(backLog); 	
    	conditions.put("userId", user.getId());
    	BizData4Page<BackLog> pageCtx = doFlowPage(model, conditions, pageParam);
    	model.addAttribute("backLog", backLog);
//    	return "/module/backlog/list";
    	return "/module/backlog/list_flow";
    }
    
    @RequestMapping(value="/backlog/listflowsend")
    public String listFlowSend(BackLog backLog,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

    	User user = getCurrentUser(request);
        //获取参数
    	Map<String, Object> conditions = getQueryMap(backLog);
    	conditions.put("flowName", Constants.FLOW_NAME_SEND);
    	conditions.put("userId", user.getId());
    	BizData4Page<BackLog> pageCtx = doFlowPage(model, conditions, pageParam);
    	model.addAttribute("backLog", backLog);
//    	return "/module/backlog/list";
    	return "/module/backlog/list_flow_send";
    }    
    
    protected BizData4Page doFlowPage(ModelMap model,Map<String, Object> conditions,PageParam pageParam){

        if(pageParam.getPageCurrent() == null) {
            pageParam.setPageCurrent(1);
        }
        Integer page = pageParam.getPageCurrent();
        
        if(pageParam.getPageSize() == null) {
        	pageParam.setPageSize(Constants.PAGE_SIZE);
        }
        Integer rows = pageParam.getPageSize();

        String sidx = pageParam.getOrderField();
        String sord = pageParam.getOrderDirection();
        if(StringUtils.isNotBlank(sidx)&&StringUtils.isNotBlank(sord))
        {
        	conditions.put("sort", sidx + " " + sord);
        }
        
        BizData4Page pageCtx = backLogService.queryFlowPage(conditions, page, (page-1)*rows, rows);
    	model.addAttribute("pageCtx", pageCtx);
    	model.addAttribute("pageParam", pageParam);
        return pageCtx;
    }    
    
    @RequestMapping(value="/backlog/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("backLog", new BackLog());
        return "module/backlog/edit";
    }    
    
    @RequestMapping(value="/backlog/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	BackLog backLog = backLogService.fetch(id);
    	model.addAttribute("backLog", backLog);
        return "module/backlog/edit";
    }    
    
    @RequestMapping(value="/backlog/save")
    @ResponseBody
    public String save(HttpServletRequest request,BackLog backLog){
		boolean isAddNew = StringUtils.isBlank(backLog.getId())?true:false;
		if(isAddNew)
		{
			backLog.setId(IdGenerator.createNewId());
			backLogService.add(backLog);
		}
		else
		{
			backLogService.update(backLog);
		}
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    }    
    
    @RequestMapping(value="/backlog/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	backLogService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(BackLog backLog)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("docId", backLog.getDocId());		
		conditions.put("subject", backLog.getSubject());		
		conditions.put("remark", backLog.getRemark());		
		conditions.put("flowId", backLog.getFlowId());		
		conditions.put("flowName", backLog.getFlowName());		
		conditions.put("status", backLog.getStatus());		
		conditions.put("createDate", backLog.getCreateDate());		
		conditions.put("updateDate", backLog.getUpdateDate());		
    	return conditions;
    }
    
    @RequestMapping(value="/backlog/check")
    @ResponseBody
    public String check(ModelMap model,HttpServletRequest request,String backLogId,String backLogStatus,String advice){
    	BackLog backLog = backLogService.fetch(backLogId);
    	backLog.setStatus(backLogStatus);
    	backLog.setUpdateDate(new Date());
    	backLogService.update(backLog);
    	Flow flow = flowService.fetch(backLog.getFlowId());
    	flowService.updateTableStatus(flow, backLog.getDocId(), backLogStatus);
    	User user = getCurrentUser(request);
    	SendForm sendForm = sendFormService.fetch(backLog.getDocId());
    	flowAdviceService.addAdvice(backLog.getDocId(), user, backLogStatus,advice.trim());    	
    	opLogService.createNew(backLogStatus+"发文", "发文名称："+sendForm.getTitle(), getCurrentUser(request));
    	backLogCallbackStrategy.getCallBack(flow.getName()).callback(backLog, flow);
    	return JsonResult.operateSuccessClose(Constants.MAIN_TAB).toString();
    }
    @RequestMapping(value="/backlog/reject")
    @ResponseBody
    public String reject(ModelMap model,HttpServletRequest request,String backLogId,String advice){
    	BackLog backLog = backLogService.fetch(backLogId);
    	Flow flow = flowService.fetch(backLog.getFlowId());
    	String modifyStatus = flow.getModifyStatus();
    	SendForm sendForm = sendFormService.fetch(backLog.getDocId());
    	backLog.setStatus(modifyStatus);
    	backLog.setUpdateDate(new Date());
    	backLogService.update(backLog);
    	
    	flowService.updateTableStatus(flow, backLog.getDocId(), modifyStatus);
    	User user = getCurrentUser(request);
    	flowAdviceService.addAdvice(backLog.getDocId(), user, modifyStatus,advice!=null?advice.trim():"");    	
    	opLogService.createNew("回退发文", "发文名称："+sendForm.getTitle(), getCurrentUser(request));
    	//backLogCallbackStrategy.getCallBack(flow.getName()).callback(backLog, flow);
    	return JsonResult.operateSuccessClose(Constants.MAIN_TAB).toString();
    }    

    @Override
    protected IBackLogService getMainService() {
        return backLogService;
    }

    @Override
    protected String getMainObjName() {
        return "backlog";
    }

    @Override
    protected String getViewTitle() {
        return "backlog";
    }
}
