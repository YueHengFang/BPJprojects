package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.Session;

@Controller
public class controller_indexcontroller {
	
	@Autowired
	private service_questionservice sqs;
	
    @RequestMapping("/")
    public String index(Model model,@RequestParam(name="page",defaultValue="1") Integer page,@RequestParam(name="size",defaultValue="5")Integer size,@RequestParam(name="search",required=false,defaultValue="")String search)
    {
        entity_PaginationDTO<entity_questionDTO> epO=sqs.eq(page,size,search);
       
        
    	model.addAttribute("Pagination",epO);
    	model.addAttribute("search",search);
    	return "index";
    }
    @RequestMapping("/exitlogin")
    public String exitlogin(HttpServletRequest request,HttpServletResponse response)
    {
    	request.getSession().removeAttribute("login");
    	request.getSession().removeAttribute("loginuser");
    	 
    	Cookie cok=new Cookie("id",null);
    	 
    	  cok.setMaxAge(0);
    		 response.addCookie(cok);
    	 
 
    	return "redirect:/";
    }
     
    @RequestMapping("/sad")
     public String sex()
     {
       return "bs";	
     }
}
