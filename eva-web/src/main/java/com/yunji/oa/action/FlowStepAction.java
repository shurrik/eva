
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
import com.yunji.oa.model.FlowStep;
import com.yunji.oa.service.IFlowService;
import com.yunji.oa.service.IFlowStepService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class FlowStepAction extends AbstractAdminController<IFlowStepService>{

    @Autowired
    private IFlowStepService flowStepService;

    @Autowired
    private IFlowService flowService;    
    
    @RequestMapping(value="/flowstep/list")
    public String list(FlowStep flowStep,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

    	pageParam.setOrderField("stepOrder");
    	pageParam.setOrderDirection("asc");
        //获取参数
    	Map<String, Object> conditions = getQueryMap(flowStep); 	
    	BizData4Page<FlowStep> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("flowStep", flowStep);
    	model.addAttribute("flows", flowService.findAll());
    	return "/module/flowstep/list";
    }    
    
    @RequestMapping(value="/flowstep/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("flowStep", new FlowStep());
    	model.addAttribute("flows", flowService.findAll());
        return "module/flowstep/edit";
    }    
    
    @RequestMapping(value="/flowstep/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	FlowStep flowStep = flowStepService.fetch(id);
    	model.addAttribute("flowStep", flowStep);
    	model.addAttribute("flows", flowService.findAll());
        return "module/flowstep/edit";
    }    
    
    @RequestMapping(value="/flowstep/save")
    @ResponseBody
    public String save(HttpServletRequest request,FlowStep flowStep){
		boolean isAddNew = StringUtils.isBlank(flowStep.getId())?true:false;
		String flowId = flowStep.getFlowId();
		Flow flow = flowService.fetch(flowId);
		flowStep.setFlowName(flow.getName());
		if(isAddNew)
		{
			flowStep.setId(IdGenerator.createNewId());
			flowStepService.add(flowStep);
		}
		else
		{
			flowStepService.update(flowStep);
		}
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    }    
    
    @RequestMapping(value="/flowstep/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	flowStepService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(FlowStep flowStep)
    {
    	Map<String, Object> conditions = new HashMap();
    	
    	conditions.put("flowId", flowStep.getFlowId());
		conditions.put("flowName", flowStep.getFlowName());		
		conditions.put("name", flowStep.getName());		
    	return conditions;
    }

    @Override
    protected IFlowStepService getMainService() {
        return flowStepService;
    }

    @Override
    protected String getMainObjName() {
        return "flowstep";
    }

    @Override
    protected String getViewTitle() {
        return "flowstep";
    }
}
