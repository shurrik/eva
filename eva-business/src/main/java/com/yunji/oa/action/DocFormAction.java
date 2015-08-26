
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
import com.yunji.oa.model.DocForm;
import com.yunji.oa.service.IDocFormService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class DocFormAction extends AbstractAdminController<IDocFormService>{

    @Autowired
    private IDocFormService docFormService;
    
    @RequestMapping(value="/docform/list")
    public String list(DocForm docForm,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(docForm); 	
    	BizData4Page<DocForm> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("docForm", docForm);
    	return "/module/docform/list";
    }  
    
    @RequestMapping(value="/docform/listsend")
    public String listSend(DocForm docForm,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(docForm); 	
    	BizData4Page<DocForm> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("docForm", docForm);
    	return "/module/docform/list_send";
    }    
    
    @RequestMapping(value="/docform/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("docForm", new DocForm());
        return "module/docform/edit";
    }    
    
    @RequestMapping(value="/docform/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	DocForm docForm = docFormService.fetch(id);
    	model.addAttribute("docForm", docForm);
        return "module/docform/edit";
    }    
    
    @RequestMapping(value="/docform/save")
    @ResponseBody
    public String save(HttpServletRequest request,DocForm docForm){
		boolean isAddNew = StringUtils.isBlank(docForm.getId())?true:false;
		if(isAddNew)
		{
			docForm.setId(IdGenerator.createNewId());
			docFormService.add(docForm);
		}
		else
		{
			docFormService.update(docForm);
		}
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    }    
    
    @RequestMapping(value="/docform/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	docFormService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(DocForm docForm)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("title", docForm.getTitle());		
		conditions.put("sendDepId", docForm.getSendDepId());		
		conditions.put("sendDep", docForm.getSendDep());		
		conditions.put("no", docForm.getNo());		
		conditions.put("content", docForm.getContent());		
		conditions.put("remark", docForm.getRemark());		
		conditions.put("chargeManId", docForm.getChargeManId());		
		conditions.put("chargeMan", docForm.getChargeMan());		
		conditions.put("contractorId", docForm.getContractorId());		
		conditions.put("contractor", docForm.getContractor());		
		conditions.put("year", docForm.getYear());		
		conditions.put("month", docForm.getMonth());		
		conditions.put("quarter", docForm.getQuarter());		
		conditions.put("progress", docForm.getProgress());		
		conditions.put("status", docForm.getStatus());		
		conditions.put("createDate", docForm.getCreateDate());		
		conditions.put("updateDate", docForm.getUpdateDate());		
		conditions.put("publishDate", docForm.getPublishDate());		
    	return conditions;
    }

    @Override
    protected IDocFormService getMainService() {
        return docFormService;
    }

    @Override
    protected String getMainObjName() {
        return "docform";
    }

    @Override
    protected String getViewTitle() {
        return "docform";
    }
}
