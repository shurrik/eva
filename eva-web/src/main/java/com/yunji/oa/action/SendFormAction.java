
package com.yunji.oa.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.yunji.oa.model.FlowStep;
import com.yunji.oa.model.RecForm;
import com.yunji.oa.model.SendForm;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IBackLogService;
import com.yunji.oa.service.IDeptService;
import com.yunji.oa.service.IFlowAdviceService;
import com.yunji.oa.service.IFlowService;
import com.yunji.oa.service.IFlowStepService;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.service.ISendFormService;
import com.yunji.oa.service.IUserService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.DateUtils;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class SendFormAction extends AbstractAdminController<ISendFormService>{

    @Autowired
    private ISendFormService sendFormService;
	@Autowired
	private IDeptService deptService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IBackLogService backLogService;
	@Autowired
	private IFlowService flowService;
	@Autowired
	private IFlowStepService flowStepService;
	@Autowired
	private IOpLogService opLogService;
    @Autowired
    private IFlowAdviceService flowAdviceService;
    
    @RequestMapping(value="/sendform/listsendform")
    public String listsendform(SendForm sendForm,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	sendForm.setStatus(Constants.STATUS_SEND_DRAFT);
    	Map<String, Object> conditions = getQueryMap(sendForm); 	
    	BizData4Page<SendForm> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("sendForm", sendForm);
    	model.addAttribute("returnStatus", Constants.STATUS_REC_DRAFT);
    	return "/module/sendform/list_sendform";
    }  
    
    @RequestMapping(value="/sendform/listrecordform")
    public String listrecordform(SendForm sendForm,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	sendForm.setStatus(Constants.STATUS_SEND_COLLECT);
    	Map<String, Object> conditions = getQueryMap(sendForm); 	
    	BizData4Page<SendForm> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("sendForm", sendForm);
    	model.addAttribute("returnStatus", Constants.STATUS_REC_DRAFT);
    	return "/module/sendform/list_sendform";
    }
    
	@RequestMapping(value = "/sendform/check")
	public String check(BackLog backLog, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		backLog = backLogService.fetch(backLog.getId());
		Flow flow = flowService.fetch(backLog.getFlowId());
		SendForm sendForm = sendFormService.fetch(backLog.getDocId());
		User user = getCurrentUser(request);
		List<FlowStep> steps = flowStepService.findStepsByBeforeStatus(
				backLog.getFlowId(), user.getId(), backLog.getStatus());
		model.addAttribute("sendForm", sendForm);
		model.addAttribute("backLog", backLog);
		model.addAttribute("flow", flow);
		model.addAttribute("steps", steps);
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("advices", flowAdviceService.findLimit("docId", backLog.getDocId(), "createDate", "desc", 10));
		return "module/sendform/sendcheck";
	}
    @RequestMapping(value="/sendform/addsendfrom")
    public String addsendfrom(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("sendForm", new SendForm());
    	model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
        return "module/sendform/edit_sendform";
    }    
    
    @RequestMapping(value="/sendform/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	SendForm sendForm = sendFormService.fetch(id);
    	model.addAttribute("sendForm", sendForm);
    	model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("advices", flowAdviceService.findLimit("docId", id, "createDate", "desc", 10));
        return "module/sendform/edit_sendform";
    }   
    
    @RequestMapping(value="/sendform/save")
    @ResponseBody
    public String save(HttpServletRequest request,SendForm sendForm){
		boolean isAddNew = StringUtils.isBlank(sendForm.getId())?true:false;
		String title="";
		if(isAddNew)
		{
			sendForm.setStatus(Constants.STATUS_REC_DRAFT);
			sendForm.setId(IdGenerator.createNewId());
			User user = getCurrentUser(request);
			sendForm.setCreatorId(user.getId());
			sendForm.setMobile(user.getMobile());
			sendForm.setYear(DateUtils.getYear());
			sendForm.setMonth(DateUtils.getMonth());
			sendForm.setQuarter(DateUtils.getQuarter());		
			sendFormService.add(sendForm);
			title="添加";
		}
		else
		{
			sendFormService.update(sendForm);
			title="修改";
		}
		opLogService.createNew(title+"发文", "发文名称："+sendForm.getTitle(), getCurrentUser(request));
    	return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    }
    
    @RequestMapping(value="/sendform/sendformidsave")
    @ResponseBody
    public String sendformidsave(HttpServletRequest request,SendForm sendForm,String no){
		boolean isAddNew = StringUtils.isBlank(sendForm.getNo())?true:false;
		String title="";
		if(isAddNew)
		{
			sendForm.setNo(no);
			//sendForm.setStatus(Constants.STATUS_REC_DRAFT);
			//sendForm.setId(IdGenerator.createNewId());
			sendFormService.add(sendForm);
			title="添加";
		}
		else
		{
			sendFormService.update(sendForm);
			title="修改";
		}
		opLogService.createNew(title+"发文ID", "发文ID："+no, getCurrentUser(request));
    	return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    } 
    
	@RequestMapping(value = "/sendform/updatestatus")
	@ResponseBody
	public String updateStatus(HttpServletRequest request, SendForm sendForm) {
		SendForm form = sendFormService.fetch(sendForm.getId());
		form.setStatus(sendForm.getStatus());
		form.setUpdateDate(new Date());
		sendFormService.update(form);
		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_SEND);
		if (flow!=null&&sendForm.getStatus().equals(flow.getStartStatus())) {
			if(form.getLogFlag())
			{
				backLogService.updateLog(form.getId(), flow, form.getTitle(),
						form.getComment());
			}
			else
			{
				backLogService.createLog(form.getId(), flow, form.getTitle(),
						form.getComment());
				form.setLogFlag(true);
			}
		}
		
		opLogService.createNew(form.getStatus()+"发文", "发文标题："+form.getTitle(), getCurrentUser(request));		
		return JsonResult.operateSuccess(Constants.MAIN_TAB).toString();
	}    
	@RequestMapping(value = "/sendform/listrecord")
	public String listDraft(SendForm sendform, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {
		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_SEND);
		// 获取参数
		sendform.setStatus(flow.getEndStatus());
		Map<String, Object> conditions = getQueryMap(sendform);
		// conditions.put("status", Constants.STATUS_REC_DRAFT);
		BizData4Page<RecForm> pageCtx = doRecordPage(model, conditions, pageParam);
		model.addAttribute("sendform", sendform);
		return "/module/sendform/send_record";
	}
	
    protected BizData4Page doRecordPage(ModelMap model,Map<String, Object> conditions,PageParam pageParam){

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
        else
        {
        	conditions.put("sort", "createDate desc");
        }
        
        BizData4Page pageCtx = getMainService().queryRecordPage(conditions, page, (page-1)*rows, rows);
    	model.addAttribute("pageCtx", pageCtx);
    	model.addAttribute("pageParam", pageParam);
        return pageCtx;
    }	

	@RequestMapping(value = "/sendform/editsendid")
	public String editsendid(SendForm sendForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {

    	sendForm = sendFormService.fetch(sendForm.getId());
    	model.addAttribute("sendForm", sendForm);
		model.addAttribute("advices", flowAdviceService.findLimit("docId", sendForm.getId(), "createDate", "desc", 10));
		return "/module/sendform/edit_sendid";
	}
    @RequestMapping(value="/sendform/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	SendForm form = sendFormService.fetch(ids);
    	sendFormService.deleteByIds(ids);
    	opLogService.createNew("删除发文", "发文标题："+form.getTitle(), getCurrentUser(request));		
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(SendForm sendForm)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("title", sendForm.getTitle());		
		conditions.put("no", sendForm.getNo());		
		conditions.put("draftDepId", sendForm.getDraftDepId());		
		conditions.put("draftDep", sendForm.getDraftDep());		
		conditions.put("draftorId", sendForm.getDraftorId());		
		conditions.put("draftorName", sendForm.getDraftorName());		
		conditions.put("mainDepId", sendForm.getMainDepId());		
		conditions.put("mainDep", sendForm.getMainDep());		
		conditions.put("subDepId", sendForm.getSubDepId());		
		conditions.put("subDep", sendForm.getSubDep());		
		conditions.put("printCount", sendForm.getPrintCount());		
		conditions.put("secretClass", sendForm.getSecretClass());		
		conditions.put("urgentClass", sendForm.getUrgentClass());		
		conditions.put("year", sendForm.getYear());		
		conditions.put("month", sendForm.getMonth());		
		conditions.put("quarter", sendForm.getQuarter());		
		conditions.put("status", sendForm.getStatus());		
		conditions.put("createDate", sendForm.getCreateDate());		
		conditions.put("updateDate", sendForm.getUpdateDate());		
		conditions.put("comment", sendForm.getComment());		
		conditions.put("type", sendForm.getType());		
    	return conditions;
    }

    @Override
    protected ISendFormService getMainService() {
        return sendFormService;
    }

    @Override
    protected String getMainObjName() {
        return "sendform";
    }

    @Override
    protected String getViewTitle() {
        return "sendform";
    }
}

