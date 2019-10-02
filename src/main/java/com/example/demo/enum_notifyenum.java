package com.example.demo;

public enum enum_notifyenum {

	REPLY_QUESTION(1,"Recovery Question"),
	REPLY_COMMIT(2,"Recovery Commit")
	;
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	private int type;
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
	enum_notifyenum(int type,String name)
	{
		this.type=type;
		this.name=name;
	}
	public static String nameoftype(int type)
	{
		for(enum_notifyenum emun:enum_notifyenum.values())
		{
			if(emun.getType()==type)
			{
				return  emun.getName();
			}
		}
		return null;
	}

}
