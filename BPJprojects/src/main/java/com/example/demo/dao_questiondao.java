package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface dao_questiondao {
   public void insertquestion(entity_question eq);
   public List<entity_question> equestion(@Param("page")int pagenum,@Param("size")int size,@Param("search")String search);
   public int count(String search);
   public int countbyuserid(String userid);
   public entity_question getbyid(String id);
   public int update(entity_question eq);
   public int countaddview(@Param("viewcount")int viewcount,@Param("id")String id);
   public int countaddcomment(@Param("commentcount")int commentcount,@Param("id")String id);
   public List<entity_question> tagquestion(entity_questionDTO eq);
}
