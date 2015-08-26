
package com.yunji.oa.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.common.exception.YunBizException;
import com.yunji.oa.model.Factaleader;
import com.yunji.oa.service.IFactaleaderService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class FactaleaderAction extends AbstractAdminController<IFactaleaderService>{

    @Autowired
    private IFactaleaderService factaleaderService;
    @RequestMapping(value="/factaleader/list")
    public String list(Factaleader factaleader,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(factaleader); 	
    	BizData4Page<Factaleader> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("factaleader", factaleader);
    	return "/module/factaleader/list";
    }    

    @RequestMapping(value="/factaleader/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("factaleader", new Factaleader());
        return "module/factaleader/edit";
    }    
    
    @RequestMapping(value="/factaleader/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	Factaleader factaleader = factaleaderService.fetch(id);
    	model.addAttribute("factaleader", factaleader);
        return "module/factaleader/edit";
    }    
    
    @RequestMapping(value="/factaleader/save")
    @ResponseBody
    public String save(ModelMap model,HttpServletRequest request,Factaleader factaleader){
    	
    	int result=factaleaderService.checkByname(factaleader);
    	if(result>0){//存在
    		return JsonResult.operateFailure(Constants.MAIN_TAB, "该元素已存在").toString();
    		}else{
    		boolean isAddNew = StringUtils.isBlank(factaleader.getId())?true:false;
    		if(isAddNew)
    		{
    			factaleader.setId(IdGenerator.createNewId());
    			factaleaderService.add(factaleader);
    		}
    		else
    		{
    			factaleaderService.update(factaleader);
    		}
    		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    	}
		
    }    
    
    @RequestMapping(value="/factaleader/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	factaleaderService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(Factaleader factaleader)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("leadername", factaleader.getLeadername());		
		conditions.put("createDate", factaleader.getCreateDate());		
		conditions.put("updateDate", factaleader.getUpdateDate());		
    	return conditions;
    }

    @Override
    protected IFactaleaderService getMainService() {
        return factaleaderService;
    }

    @Override
    protected String getMainObjName() {
        return "factaleader";
    }

    @Override
    protected String getViewTitle() {
        return "factaleader";
    }
}
