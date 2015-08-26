package com.yunji.oa.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IDeptService;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.service.IUserService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class UserAction extends AbstractAdminController<IUserService> {

	@Autowired
	private IUserService userService;
	@Autowired
	private IDeptService deptService;
	@Autowired
	private IOpLogService opLogService;

	@RequestMapping(value = "/user/list")
	public String list(User user, ModelMap model, PageParam pageParam,
			HttpServletRequest request, HttpServletResponse response) {

		// 获取参数
		Map<String, Object> conditions = getQueryMap(user);
		BizData4Page<User> pageCtx = doPage(model, conditions, pageParam);

		model.addAttribute("user", user);
		return "/module/user/list";
	}

	@RequestMapping(value = "/user/add")
	public String add(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("user", new User());
		model.addAttribute("depts", deptService.findAll());

		return "module/user/edit";
	}

	@RequestMapping(value = "/user/edit")
	public String edit(String id, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		User user = userService.fetch(id);
		model.addAttribute("user", user);
		model.addAttribute("depts", deptService.findAll());
		return "module/user/edit";
	}

	@RequestMapping(value = "userpwd/edit")
	public String resetpwd(String userId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		User user = userService.fetch(userId);
		model.addAttribute("user", user);
		model.addAttribute("depts", deptService.findAll());

		return "module/user/editpwd";
	}

	@RequestMapping(value = "/user/save")
	@ResponseBody
	public String save(HttpServletRequest request, User user) {
		boolean isAddNew = StringUtils.isBlank(user.getId()) ? true : false;
		String title = "";
		if (isAddNew) {
			userService.createNew(user);
			title = "注册";
		} else {
			userService.update(user);
			title = "修改";
		}
		opLogService.createNew(title + "用户", "用户姓名：" + user.getRealName(),
				getCurrentUser(request));
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/userpwd/save")
	@ResponseBody
	public String savepwd(HttpServletRequest request, User user, String password) {
		boolean isAddNew = StringUtils.isBlank(user.getId()) ? true : false;
		if (isAddNew) {
			userService.createNew(user);
		} else {
			try {
				Md5PasswordEncoder md5 = new Md5PasswordEncoder();
				user.setPassword(md5.encodePassword(password, password));
				userService.update(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		User user1 = userService.fetch(user.getId());
		opLogService.createNew("修改密码", "用户姓名：" + user1.getRealName(),
				getCurrentUser(request));
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/user/delete")
	@ResponseBody
	public String delete(String ids, HttpServletRequest request) {
		userService.deleteByIds(ids);
		opLogService.createNew("删除用户", "用户ID：" + ids, getCurrentUser(request));
		return JsonResult.DELETE_SUCCESS.toString();
	}

	protected Map getQueryMap(User user) {
		Map<String, Object> conditions = new HashMap();

		conditions.put("userName", user.getUserName());
		conditions.put("realName", user.getRealName());
		conditions.put("password", user.getPassword());
		conditions.put("mobile", user.getMobile());
		conditions.put("email", user.getEmail());
		conditions.put("depId", user.getDepId());
		return conditions;
	}

	@Override
	protected IUserService getMainService() {
		return userService;
	}

	@Override
	protected String getMainObjName() {
		return "user";
	}

	@Override
	protected String getViewTitle() {
		return "user";
	}
}
