package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service_notityservice {
	
	@Autowired
	private dao_notitydao dnd;
	@Autowired
	private dao_questiondao dqd;
	@Autowired
	private dao_userdao dud;
	
	
    public entity_PaginationDTO<entity_notifyDTO> list(String userid,int page,int size)
    {
    	
     try {
     	 int totalcount=dnd.countbyuserid(userid);
 
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
  		List<entity_notity> en=dnd.querynotify(userid, pagec, size);
  		List<entity_notifyDTO> end=en.stream().map(ens->{
        	        entity_notifyDTO ends=new entity_notifyDTO();
        	        BeanUtils.copyProperties(ens,ends);
        	        ends.setTypevalue(enum_notifyenum.nameoftype(ens.getType()));
        	       return ends;        
          }).collect(Collectors.toList());
  		
 
  		
  		
 		entity_PaginationDTO<entity_notifyDTO> epd=new entity_PaginationDTO<entity_notifyDTO>();
  		epd.setEq(end);
      	epd.setPagination(countpage, page);
 		return epd;
     }catch(Exception ex)
     {
    	 ex.printStackTrace();
    	 return null;
     }
    	
    }
    
    public entity_notifyDTO read(String id,entity_user eu)
    {
     	entity_notity end=dnd.selectbyid(id);
    	if(end==null)
    	{
    		throw new exption_404Excption(exption_404ExceptionErrorCode.NOTIFY_NULL);
    	}
    	if(!end.getReceiver().equals(eu.getId()))
    	{
    		throw new exption_404Excption(exption_404ExceptionErrorCode.NOTIFY_NOT_EXPTION);
    	}
    	dnd.readtrue(end.getId());
    	entity_notifyDTO ends=new entity_notifyDTO();
    	BeanUtils.copyProperties(end,ends);
        
    	return ends;
    }
    
    public List<entity_notity> queryall(String userid)
    {
    	return dnd.queryAll(userid);
    }
    
}
