package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class service_commentService {
	
	@Autowired
	 private dao_commentdao dcd;
	
	@Autowired
	private dao_questiondao dqd;
	
	@Autowired
	private dao_userdao dud;
	
	@Autowired
	private dao_notitydao dnd;
	
	@Transactional
	public void insert(entity_comment ec,String username)
	{
	  try {
		  if(ec.getCommentparentid()==null)
			{
				  throw new exption_404Excption(exption_404ExceptionErrorCode.QUESTION_NOT_FOUND);
			}
			if(ec.getType()==0)
			{
				 throw new exption_404Excption(exption_404ExceptionErrorCode.SYSTEM_ERROR);
			}
	 		if(ec.getType()==1)
			{
 		         entity_comment ecs=dcd.commentbyid(ec.getCommentparentid());
 		     
 	 	         if(ecs==null)
		         {
		             throw new exption_404Excption(exption_404ExceptionErrorCode.COMMENT_NOT_FOUND);	 
		         }
  	 	        dcd.countaddcomment(ecs.getCommentcount()+1, ecs.getId());
  	 	     entity_notity en=new entity_notity();
  	 	     en.setGmt_create(System.currentTimeMillis());
  	 	     en.setId(UUID.randomUUID().toString());
  	 	     en.setStatus(enum_notifystatusenum.NOTREAD.getStatus());
  	 	     en.setType(enum_notifyenum.REPLY_COMMIT.getType());
  	 	     en.setNotifier(ec.getCommentuserid());
  	 	     en.setReceiver(ecs.getCommentuserid());
  	 	     en.setCommittypeid(ecs.getCommentparentid());
  	 	     en.setNotifyname(username);
  	 	     en.setCommttypename(ecs.getContext());
  	 	     dnd.insertnotity(en);
 			}else
			{
				  entity_question eq=dqd.getbyid(ec.getCommentparentid());
				  if(eq==null)
				  {
					  throw new exption_404Excption(exption_404ExceptionErrorCode.QUESTION_NOT_FOUND);
				  }
				  entity_notity en=new entity_notity();
		  	 	     en.setGmt_create(System.currentTimeMillis());
		  	 	     en.setId(UUID.randomUUID().toString());
		  	 	     en.setStatus(enum_notifystatusenum.NOTREAD.getStatus());
		  	 	     en.setType(enum_notifyenum.REPLY_QUESTION.getType());
		  	 	     en.setNotifier(ec.getCommentuserid());
		  	 	     en.setReceiver(eq.getCreaterid());
		  	 	     en.setCommittypeid(eq.getId());
		  	 	     en.setNotifyname(username);
		  	 	     en.setCommttypename(eq.getTitle());
		  	 	     dnd.insertnotity(en);
				  dqd.countaddcomment(eq.getComment_count()+1,eq.getId());
			}
 	        dcd.insertcomment(ec);
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
 		
             
	}
	
	public List<entity_commentDTO> getcommentbyquestion(String questionid)	
	{
		List<entity_user> u=new ArrayList<entity_user>();
  		//dcd.commentbyid(id);
		List<entity_comment> comment=dcd.getcommentbyquestionid(questionid);
		
		if(comment.size()==0)
		{
		  return new ArrayList();
		}
 		List<String> Commentuserid=comment.stream().map(entity_comment -> entity_comment.getCommentuserid()).collect(Collectors.toList());
	    for(String userid:Commentuserid)
	    {
	    	u.add(dud.getfindbyuser(userid));
	    }
 	   // Map<String,entity_user> ms=u.stream().collect(Collectors.toMap(entity_comment::id));
		Map<String,entity_user> mapuser=new HashMap<String,entity_user>();
		for(int i=0;i<Commentuserid.size();i++)
		{
			mapuser.put(Commentuserid.get(i),u.get(i));
		}
		List<entity_commentDTO> s=comment.stream().map(entity_comment -> {
			entity_commentDTO ecd=new entity_commentDTO();
			BeanUtils.copyProperties(entity_comment, ecd);
			ecd.setEu(mapuser.get(entity_comment.getCommentuserid()));
			return ecd;
		}).collect(Collectors.toList());
	    
 		//for()
		//dud.getfindbyuser()
		
		return s;
		
	}
	 
	public List<entity_commentDTO> getsecondcomment(String parentid)
	{
	  List<entity_comment> ec=dcd.getsecondcomment(parentid);
	  List<entity_user> eus=new ArrayList<entity_user>();
	  if(ec.size()==0)
	  {
		  return new ArrayList();
	  }
		List<String> Commentuserid=ec.stream().map(entity_comment -> entity_comment.getCommentuserid()).collect(Collectors.toList());
	 for(String userid:Commentuserid)
	 {
		 eus.add(dud.getfindbyuser(userid));
	 }
		Map<String,entity_user> mapuser=new HashMap<String,entity_user>();
		for(int i=0;i<Commentuserid.size();i++)
		{
			mapuser.put(Commentuserid.get(i),eus.get(i));
		}
		List<entity_commentDTO> s=ec.stream().map(entity_comment -> {
			entity_commentDTO ecd=new entity_commentDTO();
			BeanUtils.copyProperties(entity_comment, ecd);
			ecd.setEu(mapuser.get(entity_comment.getCommentuserid()));
			return ecd;
		}).collect(Collectors.toList());		
		return s;
	  //return null;
	}
	

}
