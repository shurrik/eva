
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
import com.yunji.oa.model.Processunit;
import com.yunji.oa.service.IprocessunitService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class processunitAction extends AbstractAdminController<IprocessunitService>{

    @Autowired
    private IprocessunitService processunitService;
    
    @RequestMapping(value="/processunit/list")
    public String list(Processunit processunit,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(processunit); 	
    	BizData4Page<Processunit> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("processunit", processunit);
    	return "/module/processunit/list";
    }    
    
    @RequestMapping(value="/processunit/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("processunit", new Processunit());
        return "module/processunit/edit";
    }    
    
    @RequestMapping(value="/processunit/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	Processunit processunit = processunitService.fetch(id);
    	model.addAttribute("processunit", processunit);
        return "module/processunit/edit";
    }    
    
    @RequestMapping(value="/processunit/save")
    @ResponseBody
    public String save(HttpServletRequest request,Processunit processunit){
		boolean isAddNew = StringUtils.isBlank(processunit.getId())?true:false;
		if(isAddNew)
		{
			processunit.setId(IdGenerator.createNewId());
			processunitService.add(processunit);
		}
		else
		{
			processunitService.update(processunit);
		}
    	return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    }    
    
    @RequestMapping(value="/processunit/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	processunitService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(Processunit processunit)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("unitname", processunit.getUnitname());		
		conditions.put("createDate", processunit.getCreateDate());		
		conditions.put("updateDate", processunit.getUpdateDate());		
    	return conditions;
    }

    @Override
    protected IprocessunitService getMainService() {
        return processunitService;
    }

    @Override
    protected String getMainObjName() {
        return "processunit";
    }

    @Override
    protected String getViewTitle() {
        return "processunit";
    }
}
