package com.yunji.oa.action;

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
import com.yunji.oa.model.Flow;
import com.yunji.oa.model.OpLog;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IFlowService;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class FlowAction extends AbstractAdminController<IFlowService> {

	@Autowired
	private IFlowService flowService;
	@Autowired
	private IOpLogService opLogService;

	@RequestMapping(value = "/flow/list")
	public String list(Flow flow, ModelMap model, PageParam pageParam,
			HttpServletRequest request, HttpServletResponse response) {

		// 获取参数
		Map<String, Object> conditions = getQueryMap(flow);
		BizData4Page<Flow> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("flow", flow);
		return "/module/flow/list";
	}

	@RequestMapping(value = "/flow/add")
	public String add(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("flow", new Flow());
		return "module/flow/edit";
	}

	@RequestMapping(value = "/flow/edit")
	public String edit(String id, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		Flow flow = flowService.fetch(id);
		model.addAttribute("flow", flow);
		return "module/flow/edit";
	}

	@RequestMapping(value = "/flow/save")
	@ResponseBody
	public String save(HttpServletRequest request, Flow flow) {
		boolean isAddNew = StringUtils.isBlank(flow.getId()) ? true : false;
		String title = "";
		if (isAddNew) {
			flow.setId(IdGenerator.createNewId());
			flowService.add(flow);
			title = "添加";
		} else {
			flowService.update(flow);
			title = "修改";
		}
		opLogService.createNew(title + "流程", "流程名称：" + flow.getName(),
				getCurrentUser());
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/flow/delete")
	@ResponseBody
	public String delete(String ids, HttpServletRequest request) {

		flowService.deleteByIds(ids);
		opLogService.createNew("删除流程", "流程ID：" + ids, getCurrentUser());
		return JsonResult.DELETE_SUCCESS.toString();
	}

	protected Map getQueryMap(Flow flow) {
		Map<String, Object> conditions = new HashMap();

		conditions.put("name", flow.getName());
		conditions.put("tableName", flow.getTableName());
		conditions.put("startStatus", flow.getStartStatus());
		conditions.put("modifyFlag", flow.getModifyFlag());
		conditions.put("createDate", flow.getCreateDate());
		conditions.put("updateDate", flow.getUpdateDate());
		return conditions;
	}

	@Override
	protected IFlowService getMainService() {
		return flowService;
	}

	@Override
	protected String getMainObjName() {
		return "flow";
	}

	@Override
	protected String getViewTitle() {
		return "flow";
	}
}
