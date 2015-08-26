package com.yunji.oa.action;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.yunji.oa.model.Dept;
import com.yunji.oa.model.Flow;
import com.yunji.oa.model.FlowStep;
import com.yunji.oa.model.OpLog;
import com.yunji.oa.model.RecForm;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IBackLogService;
import com.yunji.oa.service.IDeptService;
import com.yunji.oa.service.IFlowService;
import com.yunji.oa.service.IFlowStepService;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.service.IRecFormService;
import com.yunji.oa.service.IUserService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.DateUtils;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class RecFormAction extends AbstractAdminController<IRecFormService> {

	@Autowired
	private IRecFormService recFormService;
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
	
	@RequestMapping(value = "/recform/listrecord")
	public String listRecord(RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {
		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
		recForm.setStatus(flow.getEndStatus());
		// 获取参数
		Map<String, Object> conditions = getQueryMap(recForm);

		BizData4Page<RecForm> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("recForm", recForm);
		model.addAttribute("returnStatus", Constants.STATUS_REC_HANDLE);
		return "/module/recform/list_record";
	}

	@RequestMapping(value = "/recform/list")
	public String list(RecForm recForm, ModelMap model, PageParam pageParam,
			HttpServletRequest request, HttpServletResponse response) {

		// 获取参数
		Map<String, Object> conditions = getQueryMap(recForm);
		BizData4Page<RecForm> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("recForm", recForm);
		return "/module/recform/list";
	}

	@RequestMapping(value = "/recform/listdraft")
	public String listDraft(RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {

		// 获取参数
		recForm.setStatus(Constants.STATUS_REC_DRAFT);
		model.addAttribute("remindTime", DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		Map<String, Object> conditions = getQueryMap(recForm);
		// conditions.put("status", Constants.STATUS_REC_DRAFT);
		BizData4Page<RecForm> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("recForm", recForm);
		model.addAttribute("returnStatus", Constants.STATUS_REC_DRAFT);
		return "/module/recform/list_draft";
	}
	
	@RequestMapping(value = "/recform/listhandle")
	public String listHandle(RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {
		// 获取参数
		recForm.setStatus(Constants.STATUS_REC_REGISTER);
		Map<String, Object> conditions = getQueryMap(recForm);
		// conditions.put("status", Constants.STATUS_REC_REGISTER);
		BizData4Page<RecForm> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("remindTime", DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		model.addAttribute("recForm", recForm);
		model.addAttribute("returnStatus", Constants.STATUS_REC_DRAFT);
		return "/module/recform/list_handle";
	}

	@RequestMapping(value = "/recform/listverify")
	public String listVerify(RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {

		// 获取参数
		recForm.setStatus(Constants.STATUS_REC_HANDLE);
		Map<String, Object> conditions = getQueryMap(recForm);
		// conditions.put("status", Constants.STATUS_REC_REGISTER);
		BizData4Page<RecForm> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("remindTime", DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		model.addAttribute("recForm", recForm);
		model.addAttribute("returnStatus", Constants.STATUS_REC_REGISTER);
		return "/module/recform/list_verify";
	}

	/*
	 * @RequestMapping(value = "/recform/listpresshandle") public String
	 * listpresshandle(RecForm recForm, ModelMap model, PageParam pageParam,
	 * HttpServletRequest request, HttpServletResponse response) { // 获取参数
	 * recForm.setStatus(Constants.STATUS_PRESS_HANDLE); Map<String, Object>
	 * conditions = getQueryMap(recForm); // conditions.put("status",
	 * Constants.STATUS_REC_REGISTER); BizData4Page<RecForm> pageCtx =
	 * doPage(model, conditions, pageParam); model.addAttribute("recForm",
	 * recForm); model.addAttribute("returnStatus", Constants.STATUS_REC_DRAFT);
	 * return "/module/recform/list_presshandle"; }
	 */

	@RequestMapping(value = "/recform/listpress")
	public String listPress(RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {

		// 获取参数
		recForm.setPressHandle(true);
		Map<String, Object> conditions = getQueryMap(recForm);
		// conditions.put("status", Constants.STATUS_REC_REGISTER);
		BizData4Page<RecForm> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("recForm", recForm);
		// model.addAttribute("returnStatus", Constants.STATUS_REC_REGISTER);
		model.addAttribute("remindTime", DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		return "/module/recform/list_press";
	}

	@RequestMapping(value = "/recform/listunfinished")
	public String listUnfinished(RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {

		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
		// 获取参数
		Map<String, Object> condition = new HashMap();
		condition.put("status", flow.getEndStatus());
		List<RecForm> list = recFormService.queryUnfinished(condition);
		model.addAttribute("list", list);
		model.addAttribute("remindTime", DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		return "/module/recform/list_unfinished";
	}

	@RequestMapping(value = "/recform/adddraft")
	public String addDraft(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("recForm", new RecForm());
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
		return "module/recform/edit_draft";
	}

	@RequestMapping(value = "/recform/editdraft")
	public String editDraft(String id, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {

		RecForm recForm = recFormService.fetch(id);
		model.addAttribute("recForm", recForm);
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
		return "module/recform/edit_draft";
	}

	@RequestMapping(value = "/recform/handle")
	public String handle(String id, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		RecForm recForm = recFormService.fetch(id);
		model.addAttribute("recForm", recForm);
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
		return "module/recform/edit_handle";
	}

	@RequestMapping(value = "/recform/verify")
	public String verify(String id, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		RecForm recForm = recFormService.fetch(id);
		model.addAttribute("recForm", recForm);
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
		return "module/recform/edit_verify";
	}

	@RequestMapping(value = "/recform/saveverify")
	@ResponseBody
	public String saveVerify(HttpServletRequest request, RecForm recForm) {
/*		recForm.setChargeMan(userService.fetch(recForm.getChargeManId())
				.getRealName());
		recForm.setContractor(userService.fetch(recForm.getContractorId())
				.getRealName()); 审核*/
		recForm.setUpdateDate(new Date());
		recFormService.update(recForm);
		opLogService.createNew(recForm.getStatus()+"收文", "收文名称："+recForm.getTitle(), getCurrentUser());
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
//		return JsonResult.saveSuccessClose("recformverify").toString();
	}

	@RequestMapping(value = "/recform/savehandle")
	@ResponseBody
	public String saveHandle(HttpServletRequest request, RecForm recForm) {
/*		recForm.setChargeMan(userService.fetch(recForm.getChargeManId())
				.getRealName());
		recForm.setContractor(userService.fetch(recForm.getContractorId())
				.getRealName());办文*/
		recForm.setUpdateDate(new Date());
		recFormService.update(recForm);		
		opLogService.createNew(recForm.getStatus()+"收文", "收文名称："+recForm.getTitle(), getCurrentUser());
//		return JsonResult.saveSuccessClose("recformhandle").toString();
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/recform/savedraft")
	@ResponseBody
	public String saveDraft(HttpServletRequest request,String timeLimit, RecForm recForm)
			throws ParseException {
		Integer deadlineHour=null;
		String title="";
		boolean isAddNew = StringUtils.isBlank(recForm.getId()) ? true : false;
		recForm.setStatus(Constants.STATUS_REC_DRAFT);
		if (isAddNew) {
			if(request.getParameter("deadlineHour")!="")
			{
				 deadlineHour = Integer.parseInt(request
					.getParameter("deadlineHour"));
				 recForm.setDeadline(DateUtils.incCurDateForHour(deadlineHour));
			}
			 title="添加";
			User user = getCurrentUser();
			recForm.setCreatorId(user.getId());
			recForm.setYear(DateUtils.getYear());
			recForm.setMonth(DateUtils.getMonth());
			recForm.setQuarter(DateUtils.getQuarter());
			recForm.setId(IdGenerator.createNewId());
			recFormService.add(recForm);
		} else {
			if(timeLimit==null&&request.getParameter("deadlineHour")!="")
			{
				 deadlineHour = Integer.parseInt(request
					.getParameter("deadlineHour"));
				 recForm.setDeadline(DateUtils.incCurDateForHour(deadlineHour));
			}			
			 title="修改";	
			recFormService.update(recForm);
		}
		opLogService.createNew(title+"收文", "收文名称："+recForm.getTitle(), getCurrentUser());
//		return JsonResult.saveSuccessClose("recdraft").toString();
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/recform/save")
	@ResponseBody
	public String save(HttpServletRequest request, RecForm recForm) {
		boolean isAddNew = StringUtils.isBlank(recForm.getId()) ? true : false;

		Dept dept = deptService.fetch(recForm.getDepId());
		recForm.setDepName(dept.getName());
		recForm.setStatus(Constants.STATUS_REC_DRAFT);
		recForm.setYear(DateUtils.getYear());
		recForm.setMonth(DateUtils.getMonth());
		recForm.setQuarter(DateUtils.getQuarter());
		String title="";
		if (isAddNew) {
			recForm.setId(IdGenerator.createNewId());
			recFormService.add(recForm);
			 title="添加";

		} else {
			recFormService.update(recForm);
			 title="修改";	

		}		
		opLogService.createNew(title+"收文", "收文名称："+recForm.getTitle(), getCurrentUser());
//		return JsonResult.saveSuccessClose(getMainObjName()).toString();
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/recform/pressHandle")
	@ResponseBody
	public String pressHandle(HttpServletRequest request, RecForm recForm) {
		// recForm.getDepName();
		RecForm form = recFormService.fetch(recForm.getId());
		Boolean flag = form.getPressHandle();
		if (flag == false) {
			form.setPressHandle(true);
			// form.setStatus(Constants.STATUS_PRESS_HANDLE);
			form.setUpdateDate(new Date());
			recFormService.update(form);
		}
		
		opLogService.createNew(recForm.getStatus()+"收文", "收文名称："+form.getTitle(), getCurrentUser());
		return JsonResult.operateSuccess(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/recform/updatestatus")
	@ResponseBody
	public String updateStatus(HttpServletRequest request, RecForm recForm) {
		RecForm form = recFormService.fetch(recForm.getId());
		form.setStatus(recForm.getStatus());
		form.setUpdateDate(new Date());
		
		
		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
		if (flow!=null&&recForm.getStatus().equals(flow.getStartStatus())) {
			if(form.getLogFlag())
			{
				backLogService.updateLog(form.getId(), flow, form.getTitle(),
						form.getSubmitAdvice());
			}
			else
			{
				backLogService.createLog(form.getId(), flow, form.getTitle(),
						form.getSubmitAdvice());
				form.setLogFlag(true);
			}			
		}
		recFormService.update(form);
		
		opLogService.createNew(form.getStatus()+"收文", "收文名称："+form.getTitle(), getCurrentUser());
		
		return JsonResult.operateSuccess(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/recform/returnstatus")
	@ResponseBody
	public String returnStatus(String ids, String status,
			HttpServletRequest request) {
		List<RecForm> list = recFormService.findByIds(ids);
		RecForm form1 = recFormService.fetch(ids);
		for (RecForm form : list) {
			if (form.getStatus().equals(Constants.STATUS_PRESS_HANDLE)) {
				form.setPressHandle(false);
			}
		
			form.setStatus(status);
			form.setUpdateDate(new Date());
			recFormService.update(form);
		}
		opLogService.createNew("回退至"+status, "收文名称："+form1.getTitle(), getCurrentUser());
//		return JsonResult.operateSuccess("recformhandle").toString();
		return JsonResult.operateSuccess(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/recform/delete")
	@ResponseBody
	public String delete(String ids, HttpServletRequest request) {
		RecForm form = recFormService.fetch(ids);
		recFormService.deleteByIds(ids);	
		opLogService.createNew("删除收文", "收文名称："+form.getTitle(), getCurrentUser());
		return JsonResult.DELETE_SUCCESS.toString();
	}

	@RequestMapping(value = "/recform/check")
	public String check(BackLog backLog, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {

		backLog = backLogService.fetch(backLog.getId());
		RecForm recForm = recFormService.fetch(backLog.getDocId());
		User user = getCurrentUser();
		List<FlowStep> steps = flowStepService.findStepsByBeforeStatus(
				backLog.getFlowId(), user.getId(), backLog.getStatus());
		model.addAttribute("recForm", recForm);
		model.addAttribute("backLog", backLog);
		model.addAttribute("steps", steps);
		return "module/recform/check";
	}

	@RequestMapping(value = "/recform/findexcel")
	public void findexcel(HttpServletResponse response) {

		String sheetName = "第一页";
		String filename =DateUtils.getTimestamp();
		
		 String[] title = { "收文日期", "收文号", "收文单位", "来文号", "份数", "文件标题",
		 "承办部门","承办人", "归还日期", "归档份数", "归档号", "销毁份数", "备注" };
		
		List<String> list = Arrays.asList(title);
		List<RecForm> lis = recFormService.findList("status", Constants.STATUS_REC_VERIFY);
//		System.out.println(lis.indexOf(1));
		List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();	
		Map<String, Object>data=null;
		for (int j =0; j < lis.size(); j++) {			
			for (int i = 0; i <= j; i++) {
			data = new LinkedHashMap<String, Object>();
//			System.out.println("j="+j+"i="+i);
				Format format=new SimpleDateFormat ("yyyy-MM-dd");		
				String s=format.format(lis.get(i).getUpdateDate());
				data.put("收文日期",s );
				data.put("收文号",  lis.get(i).getNo());
				data.put("收文单位", lis.get(i).getDepName());
				data.put("来文号", lis.get(i).getNo());
				data.put("份数", lis.get(i).getRecCount());
				data.put("文件标题", lis.get(i).getTitle());
				data.put("承办部门", "");
				data.put("承办人", lis.get(i).getContractor());
				data.put("归还日期", "");
				data.put("归档分数","");
				data.put("归档号","");
				data.put("销毁份数", "");
				data.put("备注", "");
			}
			datas.add(data);
		}
		opLogService.createNew("Excel下载", "文件名称："+filename, getCurrentUser());
		jxlExcel.exportexcle(response, filename, datas, sheetName, list);
	}

	protected Map getQueryMap(RecForm recForm) {
		Map<String, Object> conditions = new HashMap();

		conditions.put("depId", recForm.getDepId());
		conditions.put("depName", recForm.getDepName());
		conditions.put("no", recForm.getNo());
		conditions.put("title", recForm.getTitle());
		conditions.put("content", recForm.getContent());
		conditions.put("remark", recForm.getRemark());
		conditions.put("chargeManId", recForm.getChargeManId());
		conditions.put("chargeMan", recForm.getChargeMan());
		conditions.put("contractorId", recForm.getContractorId());
		conditions.put("contractor", recForm.getContractor());
		conditions.put("year", recForm.getYear());
		conditions.put("month", recForm.getMonth());
		conditions.put("quarter", recForm.getQuarter());
		conditions.put("progress", recForm.getProgress());
		conditions.put("status", recForm.getStatus());
		conditions.put("createDate", recForm.getCreateDate());
		conditions.put("updateDate", recForm.getUpdateDate());
		conditions.put("pressHandle", recForm.getPressHandle());
		return conditions;
	}

	@Override
	protected IRecFormService getMainService() {
		return recFormService;
	}

	@Override
	protected String getMainObjName() {
		return "recform";
	}

	@Override
	protected String getViewTitle() {
		return "recform";
	}
}
