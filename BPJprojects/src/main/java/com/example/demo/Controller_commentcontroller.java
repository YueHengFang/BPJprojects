package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller_commentcontroller {
   
	
 
 	
	@Autowired
	private service_commentService scs;
	
	@ResponseBody
	@RequestMapping("/comment")
	public Object Post(@RequestBody entity_commentcreateDTO ecd,HttpServletRequest request)
	{
 
 		   entity_user e=(entity_user)(request.getSession().getAttribute("login"));
 		   if(e==null)
		   {
			   throw new exption_404Excption(exption_404ExceptionErrorCode.NOT_LOGIN);
		   }
			entity_comment ec=new entity_comment();
		    ec.setGmt_create(System.currentTimeMillis());
		    ec.setGmt_modify(ec.getGmt_create());
		    ec.setCommentparentid(ecd.getCommentparentid());
		    ec.setType(ecd.getType());
		    ec.setContext(ecd.getContext());
	        ec.setCommentuserid(e.getId());
		    ec.setLike_count(0);
 	 		ec.setId(UUID.randomUUID().toString());
  	 	    scs.insert(ec);
  	 		Map<Object,Object> objh=new HashMap<Object,Object>();	 		
  	 		objh.put("message","success");
 		 
 
		 
		return  entity_ResultDTO.okof();
	}

}
