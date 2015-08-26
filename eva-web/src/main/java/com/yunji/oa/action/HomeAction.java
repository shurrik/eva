package com.yunji.oa.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.jasig.cas.client.util.AssertionHolder;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunji.oa.model.User;
import com.yunji.oa.service.InitService;

@Controller
public class HomeAction extends BaseAction{

	@Autowired
	private InitService initservice;
/*    @Autowired
    private IBackLogService backLogService;	
	
    @RequestMapping(value="/")
    public String renderMainView(BackLog backLog,ModelMap model,PageParam pageParam,HttpServletRequest request,HttpServletResponse response){

    	User user = getCurrentUser(request);
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
    
    @RequestMapping(value="/index")
    public String renderMainView(ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	User user = getCurrentUser(request);
    	model.addAttribute("username", user.getRealName());
    	model.addAttribute("uid", user.getId());
        return "flow";
    }    
    
    @RequestMapping(value="/installok")
    @ResponseBody
    public String installOk(ModelMap model,HttpServletRequest request,HttpServletResponse response){
        return "succ";
    }    
    
/*    @RequestMapping(value="/")
    public String renderMainView(HttpServletRequest request,HttpServletResponse response){

        return "index";
    }*/
    
    @RequestMapping(value="/home")
    public String home(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	User user = getCurrentUser(request);
    	model.addAttribute("username", user.getRealName());
    	return "home";
    }    


/*    @RequestMapping(value="/cas")
    public String cas(ModelMap model,HttpServletRequest request,HttpServletResponse response){

    	String username = AssertionHolder.getAssertion().getPrincipal().getName();
    	model.addAttribute("username", username);
    	return "cas";
    }    */
}
