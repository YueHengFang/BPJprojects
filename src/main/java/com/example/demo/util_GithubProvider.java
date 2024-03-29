package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import okhttp3.*;

@Component
public class util_GithubProvider {
 
	public String getAccessToken(entity_AccessokenDTO ato){
 		MediaType mediatype
	    = MediaType.get("application/json; charset=utf-8");
 	   OkHttpClient client = new OkHttpClient();
 	   RequestBody body = RequestBody.create(mediatype,JSON.toJSONString(ato));
	   Request request = new Request.Builder()
	       .url("https://github.com/login/oauth/access_token")
	       .post(body)
	       .build();
  	   try (Response response = client.newCall(request).execute()) {
 		   String s=response.body().string();
 		   //拿到accsee_token
  		   String[] splits=s.split("&");
 		   String[] token=splits[0].split("=");
 		   
 	     return token[1];
	   }catch(Exception ex)
	   {
 		   return null;  
	   }
	   
	}

	
	public entity_user getuser(String accesstoken)
	{
 		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
			      .url("https://api.github.com/user?access_token="+accesstoken)
			      .build();
		 Response response;
		try {
			response = (client.newCall(request).execute());
			 String s=response.body().string();
			 entity_user eu=JSON.parseObject(s,entity_user.class);
 			  
			  return eu;
		} catch (Exception e) {
 			e.printStackTrace();
 			return null;
		}
		
  	}
	
	
 }
	

