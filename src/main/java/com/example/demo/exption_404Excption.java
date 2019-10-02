package com.example.demo;

public class exption_404Excption extends RuntimeException {
   public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
private String message;
private Integer code;
   public Integer getCode() {
	return code;
}
public void setCode(Integer code) {
	this.code = code;
}
public exption_404Excption(String message,Integer code)
   {
	   this.message=message;
	   this.code=code;
   }
   public exption_404Excption(Iexption_404ExceptionErrorCode i4e)
   {
	   this.message=i4e.getMessage();
	   this.code=i4e.getCode();
   }
   
}
