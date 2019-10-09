package com.example.demo;

import java.security.cert.X509Certificate;
import java.util.List;
import java.util.UUID;

import javax.net.ssl.X509TrustManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.impl.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

@Controller
public class controller_AuthorizeController {

	@Autowired
	private util_GithubProvider gpr;
	@Autowired
	private dao_userdao dud;
	
//	@Autowired
//	private dao_persondao dpd;
	
	@Value("${github.client.id}")
	private String clientid;
	@Value("${github.client.secret}")
	private String clientsecret;
	@Value("${github.redirect_uri}")
	private String redurl;
	 
	
	@RequestMapping("/callback")
	public String callback(@RequestParam(name="code")String code,@RequestParam(name="state")String state,HttpServletRequest request,HttpServletResponse response)
	{
		 
		entity_AccessokenDTO ADTO=new entity_AccessokenDTO();
		ADTO.setCode(code);
		ADTO.setRedirect_uri(redurl);
		ADTO.setState(state);
		ADTO.setClient_id(clientid);
		ADTO.setClient_secret(clientsecret);
		String acesstoken=gpr.getAccessToken(ADTO);
		System.out.println("acesstoken"+acesstoken);
 	    entity_user eu=gpr.getuser(acesstoken); 
    	    if(eu!=null)
 	    {
  	 	    eu.setToken(acesstoken);
   	 	    eu.setGmt_creat(System.currentTimeMillis());
 	 	    eu.setGmt_modify(eu.getGmt_creat());
  	 	    dud.deleteuser(eu.getId());
  	 	    dud.insertuser(eu); 	
 	    	//登陆成功写cookie和session
 	 	    response.addCookie(new Cookie("id",eu.getId()));
 	    	request.getSession().setAttribute("login",eu);
 	    	
 	    }else
 	    {
 	    	//登陆失败重新登陆
 	    }
	    	return "redirect:/";
		 
	}
	
//	@RequestMapping("/cao")
//	public void call()
//	{
//		entity_user eu=new entity_user();
//		eu.setAccount_id("asd");
//		eu.setGmt_creat(111L);
//		eu.setName("布拉迪");
//		eu.setToken("sa");
//		eu.setGmt_modify(222L);
//		eu.setId(12);
//		dud.insertuser(eu);
//	}
//	
//	@RequestMapping("/call")
//	@ResponseBody
//	public List<entity_person> call()
//	{
//		return dpd.allperson();
//	}
	

	
}
