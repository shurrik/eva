package com.yunji.oa.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunji.oa.model.User;


@Controller
public class HomeAction extends BaseAction{

/*    @Autowired
    private IBackLogService backLogService;	
	
    @RequestMapping(value="/")
    public String renderMainView(BackLog backLog,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

    	User user = getCurrentUser();
        //获取参数
    	Map<String, Object> conditions = getQueryMap(backLog); 	
    	conditions.put("userId", user.getId());
    	BizData4Page<BackLog> pageCtx = doFlowPage(model, conditions, pageParam);
    	model.addAttribute("backLog", backLog);
    	return "/module/backlog/list";
    }*/	
	
	
	
/*    @RequestMapping(value="/")
    public String renderMainView(HttpServletRequest request,HttpServletResponse response){

        return "handlefile";
    }*/
    
    @RequestMapping(value="/")
    public String renderMainView(ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	User user = getCurrentUser();
    	model.addAttribute("username", user.getRealName());
        return "flow";
    }    
    
/*    @RequestMapping(value="/")
    public String renderMainView(HttpServletRequest request,HttpServletResponse response){

        return "index";
    }*/
    
    @RequestMapping(value="/home")
    public String home(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	User user = getCurrentUser();
    	model.addAttribute("username", user.getRealName());
    	return "home";
    }    
}
