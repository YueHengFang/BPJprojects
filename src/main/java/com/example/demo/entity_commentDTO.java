package com.example.demo;

import lombok.Data;

@Data
public class entity_commentDTO {
	private String id;
	private String commentparentid;
	private Integer type;
	private String commentuserid;
	private Long gmt_create;
	private Long gmt_modify;
	private Integer like_count;
	private String context;
	private Integer commentcount;
	private entity_user eu;

}
