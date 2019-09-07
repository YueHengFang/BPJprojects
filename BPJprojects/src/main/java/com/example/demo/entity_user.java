package com.example.demo;

import lombok.Data;

@Data
public class entity_user {
  
private String id;
private String login;
private String token;
private Long gmt_creat;
private Long gmt_modify;
private String bio;
private String avatar_url;
 
}
