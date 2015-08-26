package com.yunji.oa.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.oa.model.BackLog;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IBackLogService;
import com.yunji.oa.util.PageParam;


@Controller
public class LoginAction{

/*    @RequestMapping(value="/")
    public String renderMainView(HttpServletRequest request,HttpServletResponse response){

        return "flow";
    }    
    

    
    @RequestMapping(value="/login")
    public String home(HttpServletRequest request,HttpServletResponse response){

        return "login";
    }    */
	
    @RequestMapping(value="/login")
    public String home(HttpServletRequest request,HttpServletResponse response){

        return "login";
    }	
}
