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
import com.yunji.oa.model.OpLog;
import com.yunji.oa.model.Resource;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.service.IResourceService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class ResourceAction extends AbstractAdminController<IResourceService> {

	@Autowired
	private IResourceService resourceService;
	@Autowired
	private IOpLogService opLogService;

	@RequestMapping(value = "/resource/list")
	public String list(Resource resource, ModelMap model, PageParam pageParam,
			HttpServletRequest request, HttpServletResponse response) {

		// 获取参数
		Map<String, Object> conditions = getQueryMap(resource);
		BizData4Page<Resource> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("resource", resource);
		return "/module/resource/list";
	}

	@RequestMapping(value = "/resource/add")
	public String add(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("resource", new Resource());
		model.addAttribute("topResources",
				resourceService.findList("pid", Constants.RESOURCE_ROOT));
		return "module/resource/edit";
	}

	@RequestMapping(value = "/resource/edit")
	public String edit(String id, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		Resource resource = resourceService.fetch(id);
		model.addAttribute("resource", resource);
		model.addAttribute("topResources",
				resourceService.findList("pid", Constants.RESOURCE_ROOT));
		return "module/resource/edit";
	}

	@RequestMapping(value = "/resource/save")
	@ResponseBody
	public String save(HttpServletRequest request, Resource resource) {
		boolean isAddNew = StringUtils.isBlank(resource.getId()) ? true : false;
		String title = "";
		if (isAddNew) {
			resource.setId(IdGenerator.createNewId());
			resourceService.add(resource);
			title = "添加";
		} else {
			resourceService.update(resource);
			title = "修改";
		}

		opLogService.createNew(title + "资源", "资源名称：" + resource.getName(),
				getCurrentUser());
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/resource/delete")
	@ResponseBody
	public String delete(String ids, HttpServletRequest request) {

		resourceService.deleteByIds(ids);
		opLogService.createNew("删除资源", "资源ID：" + ids, getCurrentUser());
		return JsonResult.DELETE_SUCCESS.toString();
	}

	protected Map getQueryMap(Resource resource) {
		Map<String, Object> conditions = new HashMap();

		conditions.put("name", resource.getName());
		conditions.put("url", resource.getUrl());
		conditions.put("pid", resource.getPid());
		conditions.put("summary", resource.getSummary());
		conditions.put("resOrder", resource.getResOrder());
		conditions.put("createDate", resource.getCreateDate());
		conditions.put("updateDate", resource.getUpdateDate());
		return conditions;
	}

	@Override
	protected IResourceService getMainService() {
		return resourceService;
	}

	@Override
	protected String getMainObjName() {
		return "resource";
	}

	@Override
	protected String getViewTitle() {
		return "resource";
	}
}
