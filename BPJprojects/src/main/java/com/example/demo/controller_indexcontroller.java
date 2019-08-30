package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller_indexcontroller {
	
	@Autowired
	private service_questionservice sqs;
	
	
	
    @RequestMapping("/")
    public String index(Model model,@RequestParam(name="page",defaultValue="1") Integer page,@RequestParam(name="size",defaultValue="5")Integer size)
    {
        entity_PaginationDTO epO=sqs.eq(page,size);
    	
    	model.addAttribute("Pagination",epO);
        
    	return "index";
    }
     
    @RequestMapping("/sad")
     public String sex()
     {
       return "bs";	
     }
}
