package com.yunji.oa.directive;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.oa.model.Resource;
import com.yunji.oa.service.IResourceService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;


@Service
public class ResourceListDirective extends BaseDirective{

	@Autowired
	private IResourceService resourceService;
	
	@Override
	@SuppressWarnings("unchecked")
	protected Map<String, TemplateModel> putRes(Environment env, Map params,
			TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException {
		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
		String pid = DirectiveUtils.getString("pid", params) != null ? DirectiveUtils.getString("pid", params) : null;
/*		String courseId = DirectiveUtils.getString("courseId", params) != null ? DirectiveUtils.getString("courseId", params) : null;
		Integer limit = DirectiveUtils.getInt("limit", params) != null ? DirectiveUtils.getInt("limit", params) : 3;
		List<Course> courses = recommendCourseMng.getMayLikeCourse(courseId, limit);
		if(courses == null) {
			courses = Collections.emptyList()String courseId = DirectiveUtils.getString("courseId", params) != null ? DirectiveUtils.getString("courseId", params) : null;;
		}
		paramWrap.put("courses", DEFAULT_WRAPPER.wrap(courses));*/
		List<Resource> resources = resourceService.findList("pid", pid);
		paramWrap.put("resources", DEFAULT_WRAPPER.wrap(resources));
		return paramWrap;
	}		
}
