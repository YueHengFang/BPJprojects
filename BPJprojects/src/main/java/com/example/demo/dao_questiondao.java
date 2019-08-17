package com.example.demo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface dao_questiondao {
   public void insertquestion(entity_question eq);
}
