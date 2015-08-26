package com.yunji.oa.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunji.oa.model.Dept;
import com.yunji.oa.model.RecForm;
import com.yunji.oa.service.IRecFormService;
import com.yunji.oa.util.PageParam;

@Controller
public class SelectCodeAction {

	@Autowired
	private IRecFormService recFormService;

	@RequestMapping(value = "Search", method = RequestMethod.GET)
	public void tree(Dept dept, ModelMap model, PageParam pageParam,
			RecForm recForm, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String no = request.getParameter("Search");// 获得请求中cate的值
		String param = java.net.URLDecoder.decode(no, "UTF-8");
		String paramValue = param.trim().length() > 0 ? param.trim()
				: "unknown";
		List<RecForm> recForms = recFormService.findnoSearch(paramValue);
		java.io.PrintWriter out = response.getWriter();
		StringBuffer buf = new StringBuffer();
		response.setHeader("Cache-Control", "no-cache");// 禁止缓存
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml;charset=UTF-8");
		StringBuffer sb = new StringBuffer();
		sb.append("<respondse>");
		for (int i = 0; i < recForms.size(); i++) {
			sb.append("<name>");
			int newno=Integer.parseInt(recForms.get(i).getNo())+1;
			String str =paramValue+newno;
			sb.append(str + "</name>");
		}
		sb.append("</respondse>");
		out.write(sb.toString());

	}
}
