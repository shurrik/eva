package com.yunji.oa.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunji.common.service.IPageService;

@Controller
public class BusinessAction {

    @RequestMapping(value="/business/handlefile")
    public String renderMainView(HttpServletRequest request,HttpServletResponse response){

        return "/module/business/handlefile";
    }	
/*    @RequestMapping(value="/")
    public String renderMainView(HttpServletRequest request,HttpServletResponse response){

        return "index";
    }*/
    
    @RequestMapping(value="/business/readfile")
    public String home(HttpServletRequest request,HttpServletResponse response){

        return "/module/business/readfile";
    }    

}
