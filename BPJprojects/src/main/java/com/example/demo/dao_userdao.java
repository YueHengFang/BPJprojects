package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface dao_userdao {
	public List<entity_user> alluser();
	public entity_user getfindbyuser(String id);
	public void insertuser(entity_user eu);
}
