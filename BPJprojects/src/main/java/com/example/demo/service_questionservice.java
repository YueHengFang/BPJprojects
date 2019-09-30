package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class service_questionservice {
	
	@Autowired
	private dao_questiondao dqd;
	@Autowired
	private dao_userdao dud;
	  
	public entity_PaginationDTO<entity_questionDTO> eq(int page,int size,String search)
	{
		int totalcount=dqd.count(search);
		int countpage=0;
		  if(totalcount%size==0)
		  {
			  countpage=totalcount/size;
		  }
		  else
		  {
			  countpage=totalcount/size+1;
		  }
		  if(page>countpage)
		  {
			  page=countpage;
		  }
		  if(page<1)
		  {
			  page=1;
		  }
		int pagec=size*(page-1);
  		List<entity_question> eq=dqd.equestion(pagec,size,search);
		List<entity_questionDTO> eqDTO=new ArrayList<entity_questionDTO>();
         entity_PaginationDTO<entity_questionDTO> epo=new entity_PaginationDTO<entity_questionDTO>();
		for(entity_question e:eq)
        {
         	entity_user eu=dud.getfindbyuser(e.getCreaterid());       
         	entity_questionDTO equestion=new entity_questionDTO();
        	BeanUtils.copyProperties(e,equestion);
        	equestion.setBrief_introduction(countbrief_introduction(Util_HtmlUtil.delHTMLTag(equestion.getDescription())));
             equestion.setEu(eu);
              eqDTO.add(equestion);
             
        }
		epo.setEq(eqDTO);
		
		 
		epo.setPagination(countpage, page);
		
   		return epo;
	}
	
	public entity_PaginationDTO<entity_questionDTO> listthisuser(String userid,int page,int size)
	{
		int totalcount=dqd.countbyuserid(userid);
		int countpage=0;
		  if(totalcount%size==0)
		  {
			  countpage=totalcount/size;
		  }
		  else
		  {
			  countpage=totalcount/size+1;
		  }
		  if(page>countpage)
		  {
			  page=countpage;
		  }
		  if(page<1)
		  {
			  page=1;
		  }
		int pagec=size*(page-1);
		entity_user eu=dud.getfindbyuser(userid);
		List<entity_question> eqe=dqd.equestion(pagec,size,null);
        entity_PaginationDTO<entity_questionDTO> epo=new entity_PaginationDTO<entity_questionDTO>();
        List<entity_questionDTO> eqd=new ArrayList<entity_questionDTO>();
		for(entity_question eqs:eqe)
		{
			entity_questionDTO equestion=new entity_questionDTO();
        	BeanUtils.copyProperties(eqs,equestion);
        	equestion.setEu(eu);
        	eqd.add(equestion);
        	 
		}
         epo.setEq(eqd);
         epo.setPagination(countpage, page);
 		return epo;
	}
	public entity_questionDTO getquestionshow(String id)
	{
		 entity_question eq=dqd.getbyid(id);
		 entity_questionDTO eqd=new entity_questionDTO(); 
 		 if(eq==null)
		 {
 		      throw new exption_404Excption(exption_404ExceptionErrorCode.QUESTION_NOT_FOUND);	         
		 }else
		 {
			 BeanUtils.copyProperties(eq, eqd);
			 entity_user eu=dud.getfindbyuser(eqd.getCreaterid());
			 eqd.setEu(eu);
		 }
 		 return eqd;
	}
    public String countbrief_introduction(String context)
    {
       	if(context.length()<=1500)
    	{
    		return context;
    	}
    	else if(context.length()<=7500)
    	{
    		String conte=context.substring(0,context.length()/5)+"...";
            return conte;		
    	}else {
      		String conte=context.substring(0,60)+"......";
    		return conte;
    	}
    }
    
	public void Update(entity_question eq,Model model)
	{
		eq.setGmt_modify(System.currentTimeMillis());
		int i=dqd.update(eq);
		if(i>0)
		{
			
		}else
		{
			model.addAttribute("publisherror","Update Error");
		}
		
	}
   
	 public void viewcount(String id,HttpServletRequest hsr)
	 {
 	       entity_question eq=dqd.getbyid(id);
 	      ServletContext sc=null;
 	       if(eq==null)
			 {
 			      throw new exption_404Excption(exption_404ExceptionErrorCode.QUESTION_NOT_FOUND);	         
			 }else
			 {
				sc=hsr.getServletContext();
  				if(sc.getAttribute("read")==null)
				{
  					Map<String,List<String>> s=new HashMap<String,List<String>>();
 					List<String> li=new ArrayList<String>();
 					li.add(hsr.getSession().getId());
 					s.put(id,li);
 					sc.setAttribute("read",s);
				}else
				{
					Map<String,List<String>>  ls=(Map<String,List<String>>)sc.getAttribute("read");
					 List<String> readid=new ArrayList<String>(ls.keySet());
 					for(int i=0;i<readid.size();i++)
 					{
   						List<String> sessionid=ls.get(id);
 						if(readid.get(i).equals(id))
 						{
 							 
 							for(int j=0;j<sessionid.size();j++)
 							{
 								 
 								if(sessionid.get(j).equals(hsr.getSession().getId()))
 								{
 								 
 									return;
 								}else if(j==sessionid.size()-1)
 								{
  									sessionid.add(hsr.getSession().getId());
 									ls.put(id, sessionid);
 									i=readid.size();
 									break;
 								}
 							}
 						}else if(i==readid.size()-1)
 						{
  							readid.add(hsr.getSession().getId());
 							ls.put(id,readid);
 							i=readid.size();
 						}
 					}
					 
 					sc.setAttribute("read",ls);
				}
			    				
 			 }
	         dqd.countaddview(eq.getView_count()+1,id);
	         
  	       
	 }
	 
	 public List<entity_questionDTO> gettagquestion(entity_questionDTO eq)
	 {
		 List<entity_questionDTO> eqds=null;
		 if(eq.getTag()==null)
		 {
		   return new ArrayList<entity_questionDTO>();	 
		 }else
		 {
			 String tags[]=StringUtils.split(eq.getTag(),",");
 			 String restag=Arrays.stream(tags).collect(Collectors.joining("|"));
			 eq.setTag(restag);
	 		List<entity_question> eqb= dqd.tagquestion(eq);
	 		if(eqb==null||eqb.size()==0)
	 		{
	 			String tags2[]=StringUtils.split(eq.getTag(),"|");
	 			 String restag2=Arrays.stream(tags2).collect(Collectors.joining(","));
	 			eq.setTag(restag2);
	 		}else
	 		{
	 			 String restag2=null;
	 			for(entity_question qq:eqb)
		 		 {
		 			 String tags2[]=StringUtils.split(eq.getTag(),"|");
		 			 restag2=Arrays.stream(tags2).collect(Collectors.joining(","));
 		 			 qq.setTag(restag2);
		 			
		 			 
		 		 }
	 			eq.setTag(restag2);
	 		}
	    eqds=eqb.stream().map(entity_question -> {
 	 	         	 entity_questionDTO eqd=new entity_questionDTO();
 	 	         	 BeanUtils.copyProperties(entity_question,eqd);
  	 	         	 return eqd;
 	 	     }).collect(Collectors.toList());
		 }
		 return eqds;
	 }
	 
}
