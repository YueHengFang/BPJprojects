package com.example.demo;

public class entity_user {
  public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
private String id;
  
public String getAccount_id() {
	return account_id;
}
public void setAccount_id(String account_id) {
	this.account_id = account_id;
}

public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public Long getGmt_creat() {
	return gmt_creat;
}
public void setGmt_creat(Long gmt_creat) {
	this.gmt_creat = gmt_creat;
}
public Long getGmt_modify() {
	return gmt_modify;
}
public void setGmt_modify(Long gmt_modify) {
	this.gmt_modify = gmt_modify;
}
private String account_id;
  public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
private String login;
  private String token;
  private Long gmt_creat;
  private Long gmt_modify;
  public String getBio() {
	return bio;
}
public void setBio(String bio) {
	this.bio = bio;
}
private String bio;
}
