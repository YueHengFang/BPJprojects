package com.example.demo;

import lombok.Data;

@Data
public class entity_notifyDTO {
	private String id;
	private Long gmt_create;
    private int status;
 	private String notifier;
    private String notifyname;
    private String committypeid;
    private String commttypename;
	private String typevalue;
	private int type;
 
}
