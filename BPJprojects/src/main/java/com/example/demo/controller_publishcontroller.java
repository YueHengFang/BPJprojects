package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller_publishcontroller {
	
	@Autowired
	private dao_questiondao dqd;
	
	
    @PostMapping("/publish")
    public String publish(@RequestParam("title")String title,@RequestParam("des")String des,@RequestParam("tag")String tag,HttpServletRequest hsr)
    {
    	entity_question eq=new entity_question();
    	eq.setTitle(title);
    	eq.setDescription(des);
    	eq.setTag(tag);
    	
    	return null;
    }
}
