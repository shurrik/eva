package com.yunji.oa.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunji.oa.model.RecForm;
import com.yunji.oa.model.SendForm;
import com.yunji.oa.service.IRecFormService;
import com.yunji.oa.service.ISendFormService;
import com.yunji.oa.util.Constants;

@Controller
public class PrintAction extends BaseAction{

    @Autowired
    private IRecFormService recFormService;
    @Autowired
    private ISendFormService sendFormService;
	
    @RequestMapping(value="/print/recform")
    public String printRecform(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	RecForm recForm = recFormService.fetch(id);
    	model.addAttribute("recForm", recForm);
    	if(null!=recForm.getRecType()&&recForm.getRecType().equals(Constants.TYPE_RECFORM_HANDLE))
    	{
    		return "/module/print/recform/handle";
    	}
    	else
    	{
    		return "/module/print/recform/read";
    	}
    }    
    
/*    @RequestMapping(value="/print/recform/handle")
    public String recformHandle(ModelMap model,HttpServletRequest request,HttpServletResponse response){

        return "/print/recform/handle";
    }	*/
    @RequestMapping(value="/print/sendform")
    public String printSendform(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	SendForm sendForm = sendFormService.fetch(id);
    	model.addAttribute("sendForm", sendForm);
    	if(null!=sendForm.getType()&&sendForm.getType().equals(Constants.TYPE_SENDFORM_SINGLE))
    	{
    		return "/module/print/sendform/single";
    	}
    	else
    	{
    		return "/module/print/sendform/collect";
    	}
    }   
    
/*    @RequestMapping(value="/print/recform/read")
    public String recformRead(String id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	RecForm recForm = recFormService.fetch(id);
    	model.addAttribute("recForm", recForm);
    	return "/print/recform/read";
    }*/  	
}
