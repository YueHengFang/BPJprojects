package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller_ProfileController {
    
	@Autowired
	private service_questionservice sq;
	
	@RequestMapping("/profile/{action}")
	public String profile(@PathVariable(name="action")String action,@RequestParam(name="page",defaultValue="1") Integer page,@RequestParam(name="size",defaultValue="5")Integer size,HttpServletRequest hsr,Model model)
	{
		if("question".equals(action))
		{
			model.addAttribute("section","Questions");
		    model.addAttribute("sectionName","My Question");
		}else if("Reply".equals(action))
		{
			model.addAttribute("section","Reply");
		    model.addAttribute("sectionName","Latest Reply");
		}
		entity_user eu=(entity_user)hsr.getSession().getAttribute("login");
		entity_PaginationDTO epdto=sq.listthisuser(((entity_user)hsr.getSession().getAttribute("login")).getId(), page, size);
 		model.addAttribute("Pagination",epdto);
		return "profile";
	}
}
