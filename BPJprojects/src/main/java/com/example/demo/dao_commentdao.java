package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface dao_commentdao {
	
   public void insertcomment(entity_comment ECO);
   public entity_comment commentbyid(String id);
   public List<entity_comment> getcommentbyquestionid(String questionid);
  
   

}
 