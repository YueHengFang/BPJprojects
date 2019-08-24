package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface dao_questiondao {
   public void insertquestion(entity_question eq);
   public List<entity_question> equestion();
}
