package com.example.demo;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

//自动登录拦截器 负责拦截首页也就是自动登录页 只拦截请求为/与/index
public class interceptor_autointercepter implements HandlerInterceptor{
	
	@Autowired	
	private dao_userdao du;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	    Cookie[] cok=request.getCookies();
	    if(cok!=null)
	    {
	    	String id=null;
		    for(Cookie c:cok)
		    {
		    	if(c.getName().equals("id"))
		    	{
		    		id=c.getValue();
		    		break;
		    	}
		    }
		    if(id!=null)
		    {

			     entity_user s=du.getfindbyuser(id);
			     if(s!=null)
			     {
			    	 //代表已登陆
				     request.getSession().setAttribute("login",s);
		 		     id=null;
 				     return true;
			     }
			      
			     
		    }
		    //代表未登录
 		    return true;
	    }
	    else
	    {
	    	//代表未登陆
	    	return true;
	    }
	    
	    	
	}
}
