package com.eden.eva.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eden.eva.model.User;


@Controller
public class HomeAction extends BaseAction{

    @RequestMapping(value="/installok")
    @ResponseBody
    public String installOk(ModelMap model,HttpServletRequest request,HttpServletResponse response){
        return "succ";
    }    

    @RequestMapping(value="/")
    public String home(ModelMap model,HttpServletRequest request,HttpServletResponse response){
        return "redirect:/index.html";
    }
}
