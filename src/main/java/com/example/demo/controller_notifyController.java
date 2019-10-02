package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller_notifyController {
   
	@Autowired
	private service_notityservice sns;
	
	@RequestMapping("/notifycation/{id}")
	public String profile(@PathVariable(name="id") String id,HttpServletRequest hsr)
	{
 		entity_notifyDTO end=sns.read(id,((entity_user)hsr.getSession().getAttribute("login")));
	    if(end.getType()==enum_notifyenum.REPLY_QUESTION.getType()||end.getType()==enum_notifyenum.REPLY_COMMIT.getType())
	    {
 	    	return "redirect:/question/"+end.getCommittypeid();
	    }
	    else
	    {
	    	return null;
	    }
	
		
	}
	
}

