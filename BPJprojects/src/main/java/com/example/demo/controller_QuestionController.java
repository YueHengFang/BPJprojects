package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller_QuestionController {
	
	@Autowired
	private service_questionservice sqs;
	
	@Autowired
	private service_commentService scs;
	
	
     @RequestMapping("/question/{id}")
     public String question(@PathVariable(name="id")String id,Model model)
     {
           sqs.viewcount(id);
            entity_questionDTO eqd=sqs.getquestionshow(id);
           List<entity_commentDTO> ec=scs.getcommentbyquestion(id);
         
            model.addAttribute("comment",ec);
       	 model.addAttribute("question",eqd);
      	 return "question";
     }
}
