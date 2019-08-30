package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface dao_questiondao {
   public void insertquestion(entity_question eq);
   public List<entity_question> equestion(@Param("page")int pagenum,@Param("size")int size);
   public int count();
   public int countbyuserid(String userid);
   public entity_question getbyid(String id);
}
