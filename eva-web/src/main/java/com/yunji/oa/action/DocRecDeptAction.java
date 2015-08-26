
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
import com.yunji.oa.model.DocRecDept;
import com.yunji.oa.service.IDocRecDeptService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class DocRecDeptAction extends AbstractAdminController<IDocRecDeptService>{

    @Autowired
    private IDocRecDeptService docRecDeptService;
    
    @RequestMapping(value="/docrecdept/list")
    public String list(DocRecDept docRecDept,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(docRecDept); 	
    	BizData4Page<DocRecDept> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("docRecDept", docRecDept);
    	return "/module/docrecdept/list";
    }    
    
    @RequestMapping(value="/docrecdept/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("docRecDept", new DocRecDept());
        return "module/docrecdept/edit";
    }    
    
    @RequestMapping(value="/docrecdept/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	DocRecDept docRecDept = docRecDeptService.fetch(id);
    	model.addAttribute("docRecDept", docRecDept);
        return "module/docrecdept/edit";
    }    
    
    @RequestMapping(value="/docrecdept/save")
    @ResponseBody
    public String save(HttpServletRequest request,DocRecDept docRecDept){
		boolean isAddNew = StringUtils.isBlank(docRecDept.getId())?true:false;
		if(isAddNew)
		{
			docRecDept.setId(IdGenerator.createNewId());
			docRecDeptService.add(docRecDept);
		}
		else
		{
			docRecDeptService.update(docRecDept);
		}
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    }    
    
    @RequestMapping(value="/docrecdept/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	docRecDeptService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(DocRecDept docRecDept)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("depId", docRecDept.getDepId());		
		conditions.put("depName", docRecDept.getDepName());		
		conditions.put("formId", docRecDept.getFormId());		
		conditions.put("readFlag", docRecDept.getReadFlag());		
		conditions.put("createDate", docRecDept.getCreateDate());		
		conditions.put("updateDate", docRecDept.getUpdateDate());		
    	return conditions;
    }

    @Override
    protected IDocRecDeptService getMainService() {
        return docRecDeptService;
    }

    @Override
    protected String getMainObjName() {
        return "docrecdept";
    }

    @Override
    protected String getViewTitle() {
        return "docrecdept";
    }
}
