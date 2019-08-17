package com.example.demo;

public class entity_question {
     public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(Long gmt_create) {
		this.gmt_create = gmt_create;
	}
	public Long getGmt_modify() {
		return gmt_modify;
	}
	public void setGmt_modify(Long gmt_modify) {
		this.gmt_modify = gmt_modify;
	}
	public String getCreateid() {
		return createid;
	}
	public void setCreateid(String createid) {
		this.createid = createid;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	private String id;
     private String title;
     private String description;
     private Long gmt_create;
     private Long gmt_modify;
     private String createid;
     private int comment_count;
     private int view_count;
     private int like_count;
     private String tag;
}
