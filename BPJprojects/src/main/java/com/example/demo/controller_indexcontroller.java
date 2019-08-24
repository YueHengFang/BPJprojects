package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller_indexcontroller {
	
	@Autowired
	private service_questionservice sqs;
	
	
	
    @RequestMapping("/")
    public String index(Model model)
    {
    	List<entity_questionDTO> eqd=sqs.eq();
    	model.addAttribute("question",eqd);
 
    	return "index";
    }

}
