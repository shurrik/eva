
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
import com.yunji.oa.model.Attachment;
import com.yunji.oa.service.IAttachmentService;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;

@Controller
public class AttachmentAction extends AbstractAdminController<IAttachmentService>{

    @Autowired
    private IAttachmentService attachmentService;
    
    @RequestMapping(value="/attachment/list")
    public String list(Attachment attachment,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

        //获取参数
    	Map<String, Object> conditions = getQueryMap(attachment); 	
    	BizData4Page<Attachment> pageCtx = doPage(model, conditions, pageParam);
    	model.addAttribute("attachment", attachment);
    	return "/module/attachment/list";
    }    
    
    @RequestMapping(value="/attachment/add")
    public String add(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	model.addAttribute("attachment", new Attachment());
        return "module/attachment/edit";
    }    
    
    @RequestMapping(value="/attachment/edit")
    public String edit(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	
    	Attachment attachment = attachmentService.fetch(id);
    	model.addAttribute("attachment", attachment);
        return "module/attachment/edit";
    }    
    
    @RequestMapping(value="/attachment/save")
    @ResponseBody
    public String save(HttpServletRequest request,Attachment attachment){
		boolean isAddNew = StringUtils.isBlank(attachment.getId())?true:false;
		if(isAddNew)
		{
			attachment.setId(IdGenerator.createNewId());
			attachmentService.add(attachment);
		}
		else
		{
			attachmentService.update(attachment);
		}
    	return JsonResult.saveSuccessClose(getMainObjName()).toString();
    }    
    
    @RequestMapping(value="/attachment/delete")
    @ResponseBody
    public String delete(String ids,HttpServletRequest request){
    	
    	attachmentService.deleteByIds(ids);
    	return JsonResult.DELETE_SUCCESS.toString();
    }       
	
    protected Map getQueryMap(Attachment attachment)
    {
    	Map<String, Object> conditions = new HashMap();
    	
		conditions.put("attachType", attachment.getAttachType());		
		conditions.put("docId", attachment.getDocId());		
		conditions.put("attachUrl", attachment.getAttachUrl());		
		conditions.put("createDate", attachment.getCreateDate());		
		conditions.put("updateDate", attachment.getUpdateDate());		
    	return conditions;
    }

    @Override
    protected IAttachmentService getMainService() {
        return attachmentService;
    }

    @Override
    protected String getMainObjName() {
        return "attachment";
    }

    @Override
    protected String getViewTitle() {
        return "attachment";
    }
}
