package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface dao_notitydao {
   public int insertnotity(entity_notity en);
   public List<entity_notity> querynotify(@Param("receiverid")String receiverid,@Param("page")int page,@Param("size")int size);
   public List<entity_notity> queryAll(String receiverid);
   public int countbyuserid(String receiverid);
   public entity_notity selectbyid(String id);
   public int readtrue(String userid);
}
