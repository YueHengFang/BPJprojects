package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@ControllerAdvice
public class advice_CustomizeExceptionHandler {
	@ExceptionHandler(Exception.class)
	Object handle(HttpServletRequest hsr,HttpServletResponse response,Throwable ew,Model model)
	{
        entity_ResultDTO ert=new entity_ResultDTO();
		String ContentType=hsr.getContentType();
		
 		if("application/json".equals(ContentType))
		{
			if(ew instanceof exption_404Excption)
			{
                ert=entity_ResultDTO.errorof((exption_404Excption)ew);
			}else
			{
			     ert=entity_ResultDTO.errorof(exption_404ExceptionErrorCode.SYSTEM_ERROR);
 			}
			 try {
				 response.setContentType("application/json");
				 response.setStatus(200);
				 response.setCharacterEncoding("utf-8");
				 PrintWriter pw=response.getWriter();
				 pw.write(JSON.toJSONString(ert));
				 pw.close();
			 }catch(Exception ex)
			 {
				 
			 }
			 
		    
		}
		else
		{
			if(ew instanceof exption_404Excption)
			{
 				model.addAttribute("errormessage",ew.getMessage());
			}else
			{
 				model.addAttribute("errormessage",exption_404ExceptionErrorCode.SYSTEM_ERROR.getMessage());
			}
		}
        return "error";
		
 	}
	
}
