package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller_QuestionController {
	
	@Autowired
	private service_questionservice sqs;
	
	
	
     @RequestMapping("/question/{id}")
     public String question(@PathVariable(name="id")String id,Model model)
     {
         entity_questionDTO eqd=sqs.getquestionshow(id);	 
    	 model.addAttribute("question",eqd);
    	 return "question";
     }
}
