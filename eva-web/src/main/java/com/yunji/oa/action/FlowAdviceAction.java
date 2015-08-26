
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
import com.yunji.oa.model.FlowAdvice;
import com.yunji.oa.service.IFlowAdviceService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class FlowAdviceAction extends AbstractAdminController<IFlowAdviceService>{

    @Autowired
    private IFlowAdviceService flowAdviceService;
    
    @RequestMapping(value="/flowadvice/list")
    public String list(FlowAdvice flowAdvice,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(flowAdvice); 	
    	BizData4Page<FlowAdvice> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("flowAdvice", flowAdvice);
    	return "/module/flowadvice/list";
    }    
    
    @RequestMapping(value="/flowadvice/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("flowAdvice", new FlowAdvice());
        return "module/flowadvice/edit";
    }    
    
    @RequestMapping(value="/flowadvice/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	FlowAdvice flowAdvice = flowAdviceService.fetch(id);
    	model.addAttribute("flowAdvice", flowAdvice);
        return "module/flowadvice/edit";
    }    
    
    @RequestMapping(value="/flowadvice/save")
    @ResponseBody
    public String save(HttpServletRequest request,FlowAdvice flowAdvice){
		boolean isAddNew = StringUtils.isBlank(flowAdvice.getId())?true:false;
		if(isAddNew)
		{
			flowAdvice.setId(IdGenerator.createNewId());
			flowAdviceService.add(flowAdvice);
		}
		else
		{
			flowAdviceService.update(flowAdvice);
		}
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    }    
    
    @RequestMapping(value="/flowadvice/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	flowAdviceService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(FlowAdvice flowAdvice)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("docId", flowAdvice.getDocId());		
		conditions.put("advice", flowAdvice.getAdvice());		
		conditions.put("userId", flowAdvice.getUserId());		
		conditions.put("realName", flowAdvice.getRealName());		
		conditions.put("status", flowAdvice.getStatus());		
		conditions.put("createDate", flowAdvice.getCreateDate());		
		conditions.put("updateDate", flowAdvice.getUpdateDate());		
    	return conditions;
    }

    @Override
    protected IFlowAdviceService getMainService() {
        return flowAdviceService;
    }

    @Override
    protected String getMainObjName() {
        return "flowadvice";
    }

    @Override
    protected String getViewTitle() {
        return "flowadvice";
    }
}
