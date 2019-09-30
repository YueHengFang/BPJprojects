package com.example.demo;

import java.util.List;

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
	
	@Autowired
	private service_notityservice sns;
	
	@RequestMapping("/profile/{action}")
	public String profile(@PathVariable(name="action")String action,@RequestParam(name="page",defaultValue="1") Integer page,@RequestParam(name="size",defaultValue="5")Integer size,HttpServletRequest hsr,Model model)
	{
 			 List<entity_notity> en=sns.queryall(((entity_user)(hsr.getSession().getAttribute("login"))).getId());
 
			 int count=0;
 
			 for(entity_notity end:en)
            {
              if(end.getStatus()==1&&end.getReceiver().equals(((entity_user)(hsr.getSession().getAttribute("login"))).getId()))
              {
            	  count++;
              }
            }
 
		if("question".equals(action))
		{
			model.addAttribute("section","Questions");
		    model.addAttribute("sectionName","My Question");
		   //  entity_user eu=(entity_user)hsr.getSession().getAttribute("login");
			entity_PaginationDTO<entity_questionDTO> epdto=sq.listthisuser(((entity_user)hsr.getSession().getAttribute("login")).getId(), page, size);
 			model.addAttribute("Pagination",epdto);
		}else if("Reply".equals(action))
		{
 			entity_PaginationDTO<entity_notifyDTO> endto=sns.list(((entity_user)hsr.getSession().getAttribute("login")).getId(), page, size);
  	        List<entity_notifyDTO> end=endto.getEq();
  	      entity_user eu=((entity_user)hsr.getSession().getAttribute("login"));
   	        for(entity_notifyDTO d:end)
  	        {
  	        	System.out.println(d.getNotifyname()+"----");
  	        }
    		model.addAttribute("Pagination",endto);
    		
			model.addAttribute("section","Reply");
		    model.addAttribute("sectionName","Latest Reply");
		}
 
		model.addAttribute("notread",count);
		return "profile";
	}
}
