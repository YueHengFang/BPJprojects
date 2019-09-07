package com.example.demo;

import lombok.Data;

@Data
public class entity_ResultDTO {
	private Integer Code;
	private String message;
	
	public static entity_ResultDTO errorof(Integer code,String message)
	{
		entity_ResultDTO er=new entity_ResultDTO();
		er.setCode(code);
		er.setMessage(message);
		return er;
	}
	
	public static entity_ResultDTO errorof(exption_404ExceptionErrorCode e4eec)
	{
		return errorof(e4eec.getCode(),e4eec.getMessage());
	}
	public static entity_ResultDTO errorof(exption_404Excption e4e)
	{
		return errorof(e4e.getCode(),e4e.getMessage());
	}
	
	public static entity_ResultDTO okof()
	{
		entity_ResultDTO er=new entity_ResultDTO();
		er.setCode(100000);
		er.setMessage("Successful request");
		return er;
	}
   

}
