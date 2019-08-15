package com.example.demo;

import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

import org.apache.http.impl.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

@Controller
public class AuthorizeController {

	@Autowired
	private GithubProvider gpr;
	
	@Value("${github.client.id}")
	private String clientid;
	@Value("${github.client.secret}")
	private String clientsecret;
	@Value("${github.redirect_uri}")
	private String redurl;
	 
	
	@RequestMapping("/callback")
	public String callback(@RequestParam(name="code")String code,@RequestParam(name="state")String state)
	{
		 
		AccessokenDTO ADTO=new AccessokenDTO();
		ADTO.setCode(code);
		ADTO.setRedirect_uri(redurl);
		ADTO.setState(state);
		ADTO.setClient_id(clientid);
		ADTO.setClient_secret(clientsecret);
		String acesstoken=gpr.getAccessToken(ADTO);
 	    GithubUser GU=gpr.getuser(acesstoken); 
 		return "index";
		 
	}
}
