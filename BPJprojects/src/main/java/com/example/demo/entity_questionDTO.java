package com.example.demo;

import lombok.Data;

@Data
public class entity_questionDTO {
	
	private String id;
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_modify;
    private String createrid;
    private int comment_count;
    private int view_count;
    private int like_count;
    private String tag;
    private entity_user eu;
}
