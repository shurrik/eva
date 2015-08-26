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
import com.yunji.oa.model.Role;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.service.IRoleService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class RoleAction extends AbstractAdminController<IRoleService> {

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IOpLogService opLogService;

	@RequestMapping(value = "/role/list")
	public String list(Role role, ModelMap model, PageParam pageParam,
			HttpServletRequest request, HttpServletResponse response) {

		// 获取参数
		Map<String, Object> conditions = getQueryMap(role);
		BizData4Page<Role> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("role", role);
		return "/module/role/list";
	}

	@RequestMapping(value = "/role/add")
	public String add(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("role", new Role());
		return "module/role/edit";
	}

	@RequestMapping(value = "/role/edit")
	public String edit(String id, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		Role role = roleService.fetch(id);
		model.addAttribute("role", role);
		return "module/role/edit";
	}

	@RequestMapping(value = "/role/save")
	@ResponseBody
	public String save(HttpServletRequest request, Role role) {
		boolean isAddNew = StringUtils.isBlank(role.getId()) ? true : false;
		String title = "";
		if (isAddNew) {
			role.setId(IdGenerator.createNewId());
			roleService.add(role);
			title = "添加";
		} else {
			roleService.update(role);
			title = "修改角色";
		}
		opLogService.createNew(title + "角色", "角色名称：" + role.getName(),
				getCurrentUser());
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/role/delete")
	@ResponseBody
	public String delete(String ids, HttpServletRequest request) {
		roleService.deleteByIds(ids);
		opLogService.createNew("删除角色", "角色ID：" + ids, getCurrentUser());
		return JsonResult.DELETE_SUCCESS.toString();
	}

	protected Map getQueryMap(Role role) {
		Map<String, Object> conditions = new HashMap();

		conditions.put("name", role.getName());
		conditions.put("summary", role.getSummary());
		return conditions;
	}

	@Override
	protected IRoleService getMainService() {
		return roleService;
	}

	@Override
	protected String getMainObjName() {
		return "role";
	}

	@Override
	protected String getViewTitle() {
		return "role";
	}
}
