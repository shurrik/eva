package com.yunji.oa.action;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.oa.model.BackLog;
import com.yunji.oa.model.Dept;
import com.yunji.oa.model.Factaleader;
import com.yunji.oa.model.Flow;
import com.yunji.oa.model.FlowStep;
import com.yunji.oa.model.Processunit;
import com.yunji.oa.model.RecForm;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IBackLogService;
import com.yunji.oa.service.IDeptService;
import com.yunji.oa.service.IFlowService;
import com.yunji.oa.service.IFlowStepService;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.service.IRecFormService;
import com.yunji.oa.service.IUserService;
import com.yunji.oa.service.InitService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.DateUtils;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class RecFormAction extends AbstractAdminController<IRecFormService> {

	private final static String YESTERDAY = "yesterday";// 昨天
	private final static String BEFORE = "before";// 前天
	private final static String week = "week";// 近7天
	private final static String pre = "pre";// 前一天
	private final static String post = "post";// 后一天

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
	@Autowired
	private InitService initService;

	/**
	 * 归档列表
	 * 
	 * @param queryDate
	 * @param dateType
	 * @param recForm
	 * @param model
	 * @param pageParam
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/recform/listrecord")
	public String listRecord(Date startDate, Date endDate, Date queryDate,
			String dateType, RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {
		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
		recForm.setStatus(flow.getEndStatus());
		// 获取参数
		Map<String, Object> conditions = getQueryMap(recForm);
		// conditions = this.addDateScope(conditions, queryDate,
		// dateType,startDate,endDate);
		if (!blankPara(request)) {
			conditions = this.addDateScope(conditions, queryDate, dateType,
					startDate, endDate);
		}
		BizData4Page<RecForm> pageCtx = doPageByCreateDate(model, conditions,
				pageParam);
		model.addAttribute("datePara", conditions.get("datePara"));
		if (StringUtils.isBlank(dateType)
				|| (StringUtils.isNotBlank(dateType) && dateType.equals(week))) {
			model.addAttribute("startDate", conditions.get("startDate"));
			model.addAttribute("endDate", conditions.get("endDate"));
		}
		model.addAttribute("recForm", recForm);
		model.addAttribute("returnStatus", Constants.STATUS_REC_REGISTER);
		model.addAttribute("dateType", dateType);
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

	/**
	 * 登记列表
	 * 
	 * @param queryDate
	 * @param dateType
	 * @param recForm
	 * @param model
	 * @param pageParam
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/recform/listdraft")
	public String listDraft(Date startDate, Date endDate, Date queryDate,
			String dateType, RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response, String docnumber, String docyear,
			String docdep) {
		// 获取参数
		Map<String, Object> conditions=getQueryMap(recForm);
		model.addAttribute("remindTime",
				DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
	
		if (dateType == null) {
			dateType = "week";
		}
		if(StringUtils.isNotBlank(recForm.getDepName())||StringUtils.isNotBlank(recForm.getNo())||
				StringUtils.isNotBlank(recForm.getTitle())||StringUtils.isNotBlank(recForm.getContent())||recForm.getYear()!=null||recForm.getMonth()!=null||recForm.getQuarter()!=null)
		{		
		conditions = this.addDateScope(conditions, queryDate, dateType,
				startDate, endDate);
		conditions.put("startDate", null);
		conditions.put("endDate", null);
		conditions.put("queryDate", null);
		}
		else{
			conditions = this.addDateScope(conditions, queryDate, dateType,
					startDate, endDate);
		}
		BizData4Page<RecForm> pageCtx = doPageByCreateDate(model, conditions,
				pageParam);
		model.addAttribute("datePara", conditions.get("datePara"));
		if (StringUtils.isBlank(dateType)
				|| (StringUtils.isNotBlank(dateType) && dateType.equals(week))) {
			model.addAttribute("startDate", conditions.get("startDate"));
			model.addAttribute("endDate", conditions.get("endDate"));
		}

		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
		model.addAttribute("endStatus", flow.getEndStatus());
		model.addAttribute("recForm", recForm);
		model.addAttribute("returnStatus", Constants.STATUS_REC_DRAFT);
		model.addAttribute("dateType", dateType);
		return "/module/recform/list_draft";
	}

	private Boolean blankPara(HttpServletRequest request) {
		Boolean res = true;
		if (StringUtils.isNotBlank(request.getParameter("queryDate"))) {
			res = false;
		}
		if (StringUtils.isNotBlank(request.getParameter("dateType"))) {
			res = false;
		}
		if (StringUtils.isNotBlank(request.getParameter("startDate"))) {
			res = false;
		}
		if (StringUtils.isNotBlank(request.getParameter("endDate"))) {
			res = false;
		}
		return res;
	}

	private Map<String, Object> addDateScope(Map<String, Object> conditions,
			Date queryDate, String dateType, Date startDate, Date endDate) {

		if (StringUtils.isBlank(dateType)
				&& (startDate != null || endDate != null)) {
			if (startDate != null && endDate != null) {
				conditions.put("startDate", startDate);
				conditions.put("endDate",
						DateUtils.getStartAndEndDateForSpecialDate(endDate)[1]);
			} else if (startDate != null) {
				conditions.put("startDate", startDate);

			} else {
				conditions.put("endDate",
						DateUtils.getStartAndEndDateForSpecialDate(endDate)[1]);
			}

			return conditions;
		}
		Date[] dates = new Date[2];
		Date datePara = null;

		if (null != dateType) {
			switch (dateType) {
			case YESTERDAY: // 昨天
				datePara = DateUtils.getSpecifiedDayBefore(
						DateUtils.getNowDate(), 1);
				dates = DateUtils.getStartAndEndDateForSpecialDate(datePara);
				break;
			case BEFORE: // 前天
				datePara = DateUtils.getSpecifiedDayBefore(
						DateUtils.getNowDate(), 2);
				dates = DateUtils.getStartAndEndDateForSpecialDate(datePara);
				break;
			case week: // 本周

				Date[] todays = DateUtils.getStartAndEndDateForToday();
				dates[0] = DateUtils.getSpecifiedDayBefore(todays[0], 6);
				dates[1] = todays[1];
				break;
			case pre: // 上一天
				if (queryDate == null) {
					queryDate = DateUtils.getSpecifiedDayBefore(
							DateUtils.getNowDate(), 0);
				}
				datePara = DateUtils.getSpecifiedDayBefore(queryDate, 1);
				dates = DateUtils.getStartAndEndDateForSpecialDate(datePara);
				break;
			case post: // 后一天
				if (queryDate == null) {
					queryDate = DateUtils.getSpecifiedDayBefore(
							DateUtils.getNowDate(), 0);
				}
				datePara = DateUtils.getSpecifiedDayAfter(queryDate, 1);
				dates = DateUtils.getStartAndEndDateForSpecialDate(datePara);
				break;

			default:
				if (queryDate != null) // 有日期就是日期日
				{
					datePara = queryDate;
					dates = DateUtils
							.getStartAndEndDateForSpecialDate(queryDate);
				} else // 没日期就是今天
				{
					datePara = DateUtils.getNowDate();
					dates = DateUtils
							.getStartAndEndDateForSpecialDate(datePara);
				}
				break;
			}
		} else {
			if (queryDate != null) // 有日期就是日期日
			{
				datePara = queryDate;
				dates = DateUtils.getStartAndEndDateForSpecialDate(queryDate);
			} else // 没日期就是今天
			{
				datePara = DateUtils.getNowDate();
				dates = DateUtils.getStartAndEndDateForSpecialDate(datePara);
			}
		}

		conditions.put("startDate", dates[0]);
		conditions.put("endDate", dates[1]);
		conditions.put("datePara", datePara);
		return conditions;
	}

	/**
	 * 办文列表
	 * 
	 * @param queryDate
	 * @param dateType
	 * @param recForm
	 * @param model
	 * @param pageParam
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/recform/listhandle")
	public String listHandle(Date startDate, Date endDate, Date queryDate,
			String dateType, RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {
		// 获取参数
		Map<String, Object> conditions = getQueryMap(recForm);
		if(StringUtils.isNotBlank(recForm.getDepName())||StringUtils.isNotBlank(recForm.getNo())||
				StringUtils.isNotBlank(recForm.getTitle())||StringUtils.isNotBlank(recForm.getContent())||recForm.getYear()!=null||recForm.getMonth()!=null||recForm.getQuarter()!=null)
		{		
		conditions = this.addDateScope(conditions, queryDate, dateType,
				startDate, endDate);
		conditions.put("startDate", null);
		conditions.put("endDate", null);
		conditions.put("queryDate", null);
		}
		else{
			conditions = this.addDateScope(conditions, queryDate, dateType,
					startDate, endDate);
		}
		BizData4Page<RecForm> pageCtx = doPageByCreateDate(model, conditions,
				pageParam);
		model.addAttribute("datePara", conditions.get("datePara"));
		if (StringUtils.isBlank(dateType)
				|| (StringUtils.isNotBlank(dateType) && dateType.equals(week))) {
			model.addAttribute("startDate", conditions.get("startDate"));
			model.addAttribute("endDate", conditions.get("endDate"));
		}
		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
		model.addAttribute("endStatus", flow.getEndStatus());
		model.addAttribute("remindTime",
				DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		model.addAttribute("recForm", recForm);
		model.addAttribute("returnStatus", Constants.STATUS_REC_DRAFT);
		model.addAttribute("dateType", dateType);
		return "/module/recform/list_handle";
	}

	/**
	 * 审核列表
	 * 
	 * @param recForm
	 * @param model
	 * @param pageParam
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/recform/listverify")
	public String listVerify(RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {

		// 获取参数
		recForm.setStatus(Constants.STATUS_REC_HANDLE);
		Map<String, Object> conditions = getQueryMap(recForm);
		BizData4Page<RecForm> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("remindTime",
				DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		model.addAttribute("recForm", recForm);
		model.addAttribute("returnStatus", Constants.STATUS_REC_REGISTER);
		return "/module/recform/list_verify";
	}

	/**
	 * 督办列表
	 * 
	 * @param queryDate
	 * @param dateType
	 * @param recForm
	 * @param model
	 * @param pageParam
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/recform/listpress")
	public String listPress(Date startDate, Date endDate, Date queryDate,
			String dateType, RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {
		recForm.setPressHandle(true);
		Map<String, Object> conditions = getQueryMap(recForm);
		conditions = this.addDateScope(conditions, queryDate, dateType,
				startDate, endDate);
		BizData4Page<RecForm> pageCtx = doPageByCreateDate(model, conditions,
				pageParam);
		model.addAttribute("datePara", conditions.get("datePara"));
		if (StringUtils.isBlank(dateType)
				|| (StringUtils.isNotBlank(dateType) && dateType.equals(week))) {
			model.addAttribute("startDate", conditions.get("startDate"));
			model.addAttribute("endDate", conditions.get("endDate"));
		}
		model.addAttribute("recForm", recForm);
		model.addAttribute("remindTime",
				DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		model.addAttribute("dateType", dateType);
		return "/module/recform/list_press";

	}

	/**
	 * 未归档列表
	 * 
	 * @param recForm
	 * @param model
	 * @param pageParam
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/recform/listunfinished")
	public String listUnfinished(RecForm recForm, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {

		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
		// 获取参数
		Map<String, Object> condition = new HashMap();
		condition.put("status", flow.getEndStatus());
		List<RecForm> list = recFormService.queryUnfinished(condition);
		model.addAttribute("endStatus", flow.getEndStatus());
		model.addAttribute("list", list);
		model.addAttribute("remindTime",
				DateUtils.incHour(new Date(), Constants.REMIND_HOURS));
		return "/module/recform/list_unfinished";
	}

	/**
	 * 新增登记
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/recform/adddraft")
	public String addDraft(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		User user = getCurrentUser(request);
		model.addAttribute("recForm", new RecForm());
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("curUser", user);
		return "module/recform/edit_draft";
	}

	/**
	 * 编辑登记
	 * 
	 * @param id
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/recform/editdraft")
	public String editDraft(String id, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		User user = getCurrentUser(request);
		model.addAttribute("curUser", user);
		RecForm recForm = recFormService.fetch(id);
		model.addAttribute("recForm", recForm);
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
		return "module/recform/edit_draft";
	}

	/**
	 * 办文
	 * 
	 * @param id
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/recform/handle")
	public String handle(String id, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		User user = getCurrentUser(request);
		model.addAttribute("curUser", user);
		RecForm recForm = recFormService.fetch(id);
		model.addAttribute("recForm", recForm);
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
		return "module/recform/edit_handle";
	}

	/**
	 * 审核
	 * 
	 * @param id
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/recform/verify")
	public String verify(String id, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		RecForm recForm = recFormService.fetch(id);
		model.addAttribute("recForm", recForm);
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("users", userService.findAll());
		return "module/recform/edit_verify";
	}

	/**
	 * 保存审核
	 * 
	 * @param request
	 * @param recForm
	 * @return
	 */
	@RequestMapping(value = "/recform/saveverify")
	@ResponseBody
	public String saveVerify(HttpServletRequest request, RecForm recForm) {
		recForm.setUpdateDate(new Date());
		recFormService.update(recForm);
		opLogService.createNew(recForm.getStatus() + "收文",
				"收文名称：" + recForm.getTitle(), getCurrentUser(request));
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	/**
	 * 保存办文
	 * 
	 * @param request
	 * @param recForm
	 * @return
	 */
	@RequestMapping(value = "/recform/savehandle")
	@ResponseBody
	public String saveHandle(HttpServletRequest request, RecForm recForm) {
		recForm.setUpdateDate(new Date());
		recFormService.update(recForm);
		recForm.setDoStatus(Constants.STATUS_HANDLED);
		recForm.setRemark(recForm.getRemark().trim());
		opLogService.createNew(recForm.getStatus() + "收文",
				"收文名称：" + recForm.getTitle(), getCurrentUser(request));
		// 这里再次对提交的数据进行关键字提取插入（相当于update）
		findkeyinfo(recForm.getSubmitAdvice(), recForm.getDraftAdvice(),
				recForm);
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	/**
	 * 查找呈文领导和办文单位关键字
	 * 
	 * @param submitadvice
	 * @param draftadvice
	 * @param recForm
	 */
	public void findkeyinfo(String submitadvice, String draftadvice,
			RecForm recForm) {
		try {
			List<Factaleader> leaderlist = initService.leaderlist();
			StringBuffer leaders = new StringBuffer();
			String leaders_ = " ";
			if (leaderlist.size() > 0) {
				int m = 0;
				for (int i = 0; i < leaderlist.size(); i++) {
					String str = leaderlist.get(i).getLeadername();
					if (submitadvice.indexOf(str) != -1) {
						leaders.append(str).append(",");
						m++;
					}
				}
				if (m > 0) {
					leaders_ = leaders.toString().substring(0,
							leaders.toString().length() - 1);
				}
			}
			if ("".equals(leaders_) || leaders_ == null) {

			} else {
				recForm.setReportLeader(leaders_);// 关键
			}

			List<Processunit> unitlist = initService.unitlist();
			StringBuffer units = new StringBuffer();
			String units_ = " ";
			if (unitlist.size() > 0) {
				int n = 0;
				for (int i = 0; i < unitlist.size(); i++) {
					String str = unitlist.get(i).getUnitname();
					if (draftadvice.indexOf(str) != -1) {
						units.append(str).append(",");
						n++;
					}
				}
				if (n > 0) {
					units_ = units.toString().substring(0,
							units.toString().length() - 1);
				}
			}
			if ("".equals(units_) || units_ == null) {

			} else {
				recForm.setDoDepartment(units_);
			}
			recFormService.update(recForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 保存登记
	 * 
	 * @param request
	 * @param timeLimit
	 * @param recForm
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/recform/savedraft")
	@ResponseBody
	public String saveDraft(HttpServletRequest request, String timeLimit,
			RecForm recForm, String docdep, String docyear, String docnumber)
			throws ParseException {
		Integer deadlineHour = null;
		String title = "";
		boolean isAddNew = StringUtils.isBlank(recForm.getId()) ? true : false;
		recForm.setStatus(Constants.STATUS_REC_DRAFT);
		if (isAddNew) {
			if (request.getParameter("deadlineHour") != "") {
				deadlineHour = Integer.parseInt(request
						.getParameter("deadlineHour"));
				recForm.setDeadline(DateUtils.incCurDateForHour(deadlineHour));
			}
			String docno = docdep + docyear + docnumber;
			String[] text = docno.split(",");

			String dep = text[1].toString();
			String year = text[2].toString();
			String number = text[3].toString();

			title = "添加";
			User user = getCurrentUser(request);
			recForm.setDocNo(dep + year + number);
			recForm.setCreatorId(user.getId());
			recForm.setYear(DateUtils.getYear());
			recForm.setMonth(DateUtils.getMonth());
			recForm.setQuarter(DateUtils.getQuarter());
			recForm.setId(IdGenerator.createNewId());
			recFormService.add(recForm);
		} else {
			if (request.getParameter("deadlineHour") != "") {
				deadlineHour = Integer.parseInt(request
						.getParameter("deadlineHour"));
				recForm.setDeadline(DateUtils.incCurDateForHour(deadlineHour));
			} else {
				// recForm.setDeadline(null);
				recFormService.cancelDeadline(recForm.getId());
			}
			recForm.setUpdateDate(new Date());
			title = "修改";
			recFormService.update(recForm);
		}
		opLogService.createNew(title + "收文", "收文名称：" + recForm.getTitle(),
				getCurrentUser(request));
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
		String title = "";
		if (isAddNew) {
			recForm.setId(IdGenerator.createNewId());
			recFormService.add(recForm);
			title = "添加";

		} else {
			recFormService.update(recForm);
			title = "修改";

		}
		opLogService.createNew(title + "收文", "收文名称：" + recForm.getTitle(),
				getCurrentUser(request));
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	/**
	 * 督办
	 * 
	 * @param request
	 * @param recForm
	 * @return
	 */
	@RequestMapping(value = "/recform/pressHandle")
	@ResponseBody
	public String pressHandle(HttpServletRequest request, RecForm recForm) {
		RecForm form = recFormService.fetch(recForm.getId());
		Boolean flag = form.getPressHandle();
		if (flag == false) {
			form.setPressHandle(true);
			form.setUpdateDate(new Date());
			recFormService.update(form);
		}

		opLogService.createNew(recForm.getStatus() + "收文",
				"收文名称：" + form.getTitle(), getCurrentUser(request));
		return JsonResult.operateSuccess(Constants.MAIN_TAB).toString();
	}

	/**
	 * 批量审核
	 * 
	 * @param request
	 * @param recForm
	 * @return
	 */
	@RequestMapping(value = "/recform/updatebatchverify", method = RequestMethod.POST)
	@ResponseBody
	public String savebatchverify(HttpServletRequest request, RecForm recForm) {
		String ids = request.getParameter("delitems");
		String[] text = ids.split(",");
		for (String str : text) {
			RecForm form = recFormService.fetch(str);
			recForm.setStatus(Constants.STATUS_REC_VERIFY);
			form.setStatus(recForm.getStatus());
			form.setUpdateDate(new Date());
			form.setDoStatus(Constants.STATUS_RECORD);
			form.setDoTime(new Date());
			Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
			if (flow != null
					&& recForm.getStatus().equals(flow.getStartStatus())) {
				if (form.getLogFlag()) {
					backLogService.updateLog(form.getId(), flow,
							form.getTitle(), form.getSubmitAdvice());
				} else {
					backLogService.createLog(form.getId(), flow,
							form.getTitle(), form.getSubmitAdvice());
					form.setLogFlag(true);
				}
			}
			recFormService.update(form);
			opLogService.createNew(form.getStatus() + "收文",
					"收文名称：" + form.getTitle(), getCurrentUser(request));
		}
		return JsonResult.operateSuccess(Constants.MAIN_TAB).toString();
	}

	/**
	 * 改变状态
	 * 
	 * @param request
	 * @param recForm
	 * @return
	 */
	@RequestMapping(value = "/recform/updatestatus")
	@ResponseBody
	public String updateStatus(HttpServletRequest request, RecForm recForm) {
		RecForm form = recFormService.fetch(recForm.getId());
		form.setStatus(recForm.getStatus());
		form.setUpdateDate(new Date());
		if (recForm.getStatus().equals("登记") == true) {
			form.setDoTime(new Date());
		} else if (recForm.getStatus().equals("审核") == true) {
			form.setDoStatus(Constants.STATUS_RECORD);
			form.setDoTime(new Date());
		}
		Flow flow = flowService.findOne("name", Constants.FLOW_NAME_REC);
		if (flow != null && recForm.getStatus().equals(flow.getStartStatus())) {
			if (form.getLogFlag()) {
				backLogService.updateLog(form.getId(), flow, form.getTitle(),
						form.getSubmitAdvice());
			} else {
				backLogService.createLog(form.getId(), flow, form.getTitle(),
						form.getSubmitAdvice());
				form.setLogFlag(true);
			}
		}
		recFormService.update(form);

		opLogService.createNew(form.getStatus() + "收文",
				"收文名称：" + form.getTitle(), getCurrentUser(request));

		return JsonResult.operateSuccess(Constants.MAIN_TAB).toString();
	}

	/**
	 * 回退
	 * 
	 * @param ids
	 * @param status
	 * @param request
	 * @return
	 */
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
			if (status.equals("登记") == true) {
				form.setDoStatus("");
				form.setDoTime(new Date());
			}
			if (status.equals("草稿") == true) {
				form.setDoStatus(Constants.STATUS_UN_SUBMIT);
				form.setDoTime(new Date());
			}
			recFormService.update(form);
		}
		opLogService.createNew("回退至" + status, "收文名称：" + form1.getTitle(),
				getCurrentUser(request));
		return JsonResult.operateSuccess(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/recform/delete")
	@ResponseBody
	public String delete(String ids, HttpServletRequest request) {
		RecForm form = recFormService.fetch(ids);

		recFormService.deleteByIds(ids);
		opLogService.createNew("删除收文", "收文名称：" + form.getTitle(),
				getCurrentUser(request));
		return JsonResult.DELETE_SUCCESS.toString();
	}

	@RequestMapping(value = "/recform/check")
	public String check(BackLog backLog, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {

		backLog = backLogService.fetch(backLog.getId());
		RecForm recForm = recFormService.fetch(backLog.getDocId());
		User user = getCurrentUser(request);
		List<FlowStep> steps = flowStepService.findStepsByBeforeStatus(
				backLog.getFlowId(), user.getId(), backLog.getStatus());
		model.addAttribute("recForm", recForm);
		model.addAttribute("backLog", backLog);
		model.addAttribute("steps", steps);
		return "module/recform/check";
	}

	@RequestMapping(value = "/recform/findexcel")
	public void findexcel(RecForm recForm, ModelMap model, PageParam pageParam,
			HttpServletRequest request, HttpServletResponse response) {

		String sheetName = "第一页";
		String filename = DateUtils.getTimestamp();

		String[] title1 = { "收文日期", "收文号", "收文单位", "来文号", "份数", "文件标题", "承办部门",
				"承办人", "归还日期", "归档份数", "归档号", "销毁份数", "备注" };

		List<String> list = Arrays.asList(title1);
		Map<String, Object> condition = getQueryMap(recForm);
		condition.put("status", Constants.STATUS_REC_VERIFY);
		List<RecForm> lis = recFormService.queryExport(condition);
		List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
		Map<String, Object> data = null;
		for (int j = 0; j < lis.size(); j++) {
			for (int i = 0; i <= j; i++) {
				data = new LinkedHashMap<String, Object>();
				// System.out.println("j="+j+"i="+i);
				Format format = new SimpleDateFormat("yyyy-MM-dd");
				String s = format.format(lis.get(i).getUpdateDate());
				data.put("收文日期", s);
				data.put("收文号", lis.get(i).getNo());
				data.put("收文单位", lis.get(i).getDepName());
				data.put("来文号", lis.get(i).getDocNo());
				data.put("份数", lis.get(i).getRecCount());
				data.put("文件标题", lis.get(i).getTitle());
				data.put("承办部门", "");
				data.put("承办人", lis.get(i).getContractor());
				data.put("归还日期", "");
				data.put("归档分数", "");
				data.put("归档号", "");
				data.put("销毁份数", "");
				data.put("备注", "");
			}
			datas.add(data);
		}
		String[] sizeArr = { "10", "20", "20", "20", "5", "100", "10", "20",
				"10", "10", "10", "10", "10" };
		opLogService.createNew("Excel下载", "文件名称：" + filename, getCurrentUser(request));
		jxlExcel.exportexcle(response, filename, datas, sheetName, list,
				sizeArr);
	}

	protected Map getQueryMap(RecForm recForm) {
		Map<String, Object> conditions = new HashMap();

		conditions.put("depId", recForm.getDepId());
		conditions.put("depName", recForm.getDepName());
		conditions.put("no", recForm.getNo());
		conditions.put("docNo", recForm.getDocNo());
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

	/**
	 * 根据收文日期分页
	 * 
	 * @param model
	 * @param conditions
	 * @param pageParam
	 * @return
	 */
	protected BizData4Page doPageByCreateDate(ModelMap model,
			Map<String, Object> conditions, PageParam pageParam) {

		if (pageParam.getPageCurrent() == null) {
			pageParam.setPageCurrent(1);
		}
		Integer page = pageParam.getPageCurrent();

		if (pageParam.getPageSize() == null) {
			pageParam.setPageSize(Constants.PAGE_SIZE);
		}
		Integer rows = pageParam.getPageSize();

		String sidx = pageParam.getOrderField();
		String sord = pageParam.getOrderDirection();
		if (StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(sord)) {
			conditions.put("sort", sidx + " " + sord);
		} else {
			conditions.put("sort", "update_date desc,no desc");
		}

		/*
		 * BizData4Page pageCtx = getMainService().queryPage(conditions, page,
		 * (page-1)*rows, rows);
		 */
		BizData4Page pageCtx = recFormService.queryByCreateDate(conditions,
				page, (page - 1) * rows, rows);
		model.addAttribute("pageCtx", pageCtx);
		model.addAttribute("pageParam", pageParam);
		return pageCtx;
	}

	@RequestMapping(value = "/recform/ajaxdeadline")
	public String ajaxDeadline(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		return "module/recform/ajax_deadline";
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
