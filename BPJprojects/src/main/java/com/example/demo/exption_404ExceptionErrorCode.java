package com.example.demo;

public enum exption_404ExceptionErrorCode implements Iexption_404ExceptionErrorCode {
     
	QUESTION_NOT_FOUND(2002,"The server could not find the specified page"),
	COMMENT_NOT_FOUND(1999,"No responding subject has been selected, so no reply can be made"),
	NOT_LOGIN(2004,"Sorry, you are not logged in and can't do anything"),
    SYSTEM_ERROR(9999,"The system encountered an error")
	;
	
	private String message;
	public Integer getCode() {
		return code;
	}

	private Integer code;
	
	public String getMessage() {
		return message;
	}
	exption_404ExceptionErrorCode(Integer code,String message)
	{ 
		this.message=message;
		this.code=code;
	}

	 
}
