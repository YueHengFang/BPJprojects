package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service_questionservice {
	
	@Autowired
	private dao_questiondao dqd;
	@Autowired
	private dao_userdao dud;
	  
	public entity_PaginationDTO eq(int page,int size)
	{
		int totalcount=dqd.count();
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
  		List<entity_question> eq=dqd.equestion(pagec,size);
		List<entity_questionDTO> eqDTO=new ArrayList<entity_questionDTO>();
         entity_PaginationDTO epo=new entity_PaginationDTO();
		for(entity_question e:eq)
        {
         	entity_user eu=dud.getfindbyuser(e.getCreaterid());       
         	entity_questionDTO equestion=new entity_questionDTO();
        	BeanUtils.copyProperties(e,equestion);
             equestion.setEu(eu);
              eqDTO.add(equestion);
             
        }
		epo.setEq(eqDTO);
		
		epo.setPagination(countpage, page);
		
   		return epo;
	}
	
	public entity_PaginationDTO listthisuser(String userid,int page,int size)
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
		List<entity_question> eqe=dqd.equestion(pagec,size);
        entity_PaginationDTO epo=new entity_PaginationDTO();
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
		 BeanUtils.copyProperties(eq, eqd);
		 return eqd;
	}
	  

}
