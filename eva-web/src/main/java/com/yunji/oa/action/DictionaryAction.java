
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
import com.yunji.oa.model.Dictionary;
import com.yunji.oa.service.IDictionaryService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class DictionaryAction extends AbstractAdminController<IDictionaryService>{

    @Autowired
    private IDictionaryService dictionaryService;
    
    @RequestMapping(value="/dictionary/list")
    public String list(Dictionary dictionary,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(dictionary); 	
    	BizData4Page<Dictionary> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("dictionary", dictionary);
    	return "/module/dictionary/list";
    }    
    
    @RequestMapping(value="/dictionary/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("dictionary", new Dictionary());
        return "module/dictionary/edit";
    }    
    
    @RequestMapping(value="/dictionary/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	Dictionary dictionary = dictionaryService.fetch(id);
    	model.addAttribute("dictionary", dictionary);
        return "module/dictionary/edit";
    }    
    
    @RequestMapping(value="/dictionary/save")
    @ResponseBody
    public String save(HttpServletRequest request,Dictionary dictionary){
		boolean isAddNew = StringUtils.isBlank(dictionary.getId())?true:false;
		if(isAddNew)
		{
			dictionary.setId(IdGenerator.createNewId());
			dictionaryService.add(dictionary);
		}
		else
		{
			dictionaryService.update(dictionary);
		}
    	return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
    }    
    
    @RequestMapping(value="/dictionary/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	dictionaryService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(Dictionary dictionary)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("propertkey", dictionary.getPropertkey());		
		conditions.put("propertvalue", dictionary.getPropertvalue());		
		conditions.put("createDate", dictionary.getCreateDate());		
		conditions.put("updateDate", dictionary.getUpdateDate());		
    	return conditions;
    }

    @Override
    protected IDictionaryService getMainService() {
        return dictionaryService;
    }

    @Override
    protected String getMainObjName() {
        return "dictionary";
    }

    @Override
    protected String getViewTitle() {
        return "dictionary";
    }
}
