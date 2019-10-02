package com.example.demo;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class interceptor_addinterceptor implements HandlerInterceptor{
   
	@Autowired
	private service_notityservice sns;
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
 		entity_user eu=(entity_user)request.getSession().getAttribute("login");
 		  if(eu!=null)
		  {  
  			  int count=0;
			  List<entity_notity> en=sns.queryall(eu.getId());
 			  for(entity_notity end:en)
	            {
	              if(end.getStatus()==1&&end.getReceiver().equals(eu.getId()))
	              {
	            	  count++;
	              }
	            }
 			  request.getSession().setAttribute("countnum",count);
 			  request.getSession().setAttribute("loginuser",eu);
		  }
 		  
		 
	      return true;	
	}

}
