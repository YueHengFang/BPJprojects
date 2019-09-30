package com.example.demo;

public enum enum_notifystatusenum {
     ISREAD(0),
     NOTREAD(1)
	;
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private int status;

	private enum_notifystatusenum(int status) {
		this.status = status;
	}
	

}
