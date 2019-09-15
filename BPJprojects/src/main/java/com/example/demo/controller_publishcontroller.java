package com.example.demo;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller_publishcontroller {
	
	@Autowired
	private dao_questiondao dqd;
	
	@Autowired
	private service_questionservice sqs;
	
	@Autowired
	private service_TagService sts;
	
	
	
	
	@RequestMapping("/publish/{id}")
	public String edit(@PathVariable(name="id")String id,Model model)
	{   
		 System.out.println(1218213781);
 		entity_questionDTO eq=sqs.getquestionshow(id);
 	     
 		 model.addAttribute("title",eq.getTitle());
         model.addAttribute("des",eq.getDescription());
      	 model.addAttribute("tag",eq.getTag());
      	 model.addAttribute("id",id);
      	
         model.addAttribute("tags",sts.getTag());
		return "publish";
	}
	
	 
    @PostMapping("/submitpublish")
    public String publish(@RequestParam("title")String title,@RequestParam("des")String des,@RequestParam("tag")String tag,@RequestParam("id")String id,HttpServletRequest hsr,Model model)
    {
        try {
    	  model.addAttribute("title",title);
 
          model.addAttribute("des",des);
       	model.addAttribute("tag",tag);
 
        	
      	entity_question eq=new entity_question();
 
      	eq.setTitle(title);
    	eq.setDescription(des);
    	eq.setTag(tag);
    	eq.setComment_count(0);
    	eq.setGmt_create(System.currentTimeMillis());
    	eq.setGmt_modify(eq.getGmt_create());
    	eq.setLike_count(0);
    	eq.setView_count(0);
 
    	entity_user es=(entity_user)(hsr.getSession().getAttribute("login"));
    	eq.setCreaterid(es.getId());
     	if(id==null||id.trim().equals(""))
    	{
     		eq.setId(UUID.randomUUID().toString());
        	dqd.insertquestion(eq);
    	}else
    	{
    		eq.setId(id);
    		sqs.Update(eq,model);
    		
    	}
    	return "redirect:/";
      }catch(Exception ex)
      {
    	  System.out.println(ex.getMessage());
    	  model.addAttribute("publisherror","Sorry,this ApplicationContext error");
          return "publish";
      }
    }
}
