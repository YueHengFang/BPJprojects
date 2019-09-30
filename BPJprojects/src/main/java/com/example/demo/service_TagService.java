package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class service_TagService {
    
	public List<entity_TagDTO> getTag()
	{
		List<entity_TagDTO> etst=new ArrayList<entity_TagDTO>();
		 entity_TagDTO et=new entity_TagDTO();
		 et.setCategoryname("country");
		 List<String> showtagst=new ArrayList<String>();
		 List<String> valuetagst=new ArrayList<String>();
		 showtagst.add("🇺🇸");
		 valuetagst.add("United States");
		 showtagst.add("🇨🇳");
		 valuetagst.add("China");
		 showtagst.add("🇮🇳");
		 valuetagst.add("India");
		 showtagst.add("🇷🇺");
		 valuetagst.add("Russia");
		 showtagst.add("🇩🇪");
		 valuetagst.add("Germany");
		 showtagst.add("🇬🇧");
		 valuetagst.add("United Kingdom");
		 showtagst.add("🇯🇵");
		 valuetagst.add("Japan");
		 showtagst.add("🇫🇷");
		 valuetagst.add("France");
		 showtagst.add("🇧🇷");
		 valuetagst.add("Brazil");
		 showtagst.add("🇮🇹");
		 valuetagst.add("Italy");
		 showtagst.add("🇪🇸");
		 valuetagst.add("Spain");
		 showtagst.add("🇦🇺");
		 valuetagst.add("Australia");
		 showtagst.add("🇨🇦");
		 valuetagst.add("Canada");
		 showtagst.add("🇸🇪");
		 valuetagst.add("Sweden");
		 showtagst.add("🇧🇪");
		 valuetagst.add("Belgium");
		 showtagst.add("🇳🇱");
		 valuetagst.add("Netherlands");
		 showtagst.add("🇰🇷");
		 valuetagst.add("South Korea");
		 showtagst.add("🇺🇳");
		 valuetagst.add("Other country");
		 et.setShowTags(showtagst);
		 et.setValueTags(valuetagst);
		 entity_TagDTO et2=new entity_TagDTO();
		 et2.setCategoryname("topic");
		 List<String> showtagst2=new ArrayList<String>();
		 List<String> valuetagst2=new ArrayList<String>();
		 showtagst2.add("🏰");
		 valuetagst2.add("political");
		 showtagst2.add("⚖️");
		 valuetagst2.add("legal");
		 showtagst2.add("🚀");
		 valuetagst2.add("military");
		 showtagst2.add("🎢");
		 valuetagst2.add("entertainment");
		 showtagst2.add("🛰");
		 valuetagst2.add("Technology");
		 showtagst2.add("🚗️");
		 valuetagst2.add("society");
		 showtagst2.add("💰");
		 valuetagst2.add("economic");
		 et2.setShowTags(showtagst2);
		 et2.setValueTags(valuetagst2);
		 entity_TagDTO et3=new entity_TagDTO();
		 et3.setCategoryname("political");
		 List<String> showtagst3=new ArrayList<String>();
		 List<String> valuetagst3=new ArrayList<String>();
		 showtagst3.add("personage");
		 valuetagst3.add("political-personage");
		 showtagst3.add("current politics");
		 valuetagst3.add("political-current politics");
		 showtagst3.add("information disclosure");
		 valuetagst3.add("political-information disclosure");
		 showtagst3.add("Political history");
		 valuetagst3.add("political-Political history");
		 showtagst3.add("Other");
		 valuetagst3.add("political-Other");
		 et3.setShowTags(showtagst3);
		 et3.setValueTags(valuetagst3);
		 entity_TagDTO et4=new entity_TagDTO();
		 et4.setCategoryname("legal");
		 List<String> showtagst4=new ArrayList<String>();
		 List<String> valuetagst4=new ArrayList<String>();
		 showtagst4.add("personage");
		 valuetagst4.add("legal-personage");
		 showtagst4.add("Sentence");
		 valuetagst4.add("legal-Sentence");
		 showtagst4.add("article");
		 valuetagst4.add("legal-article");
		 showtagst4.add("National law");
		 valuetagst4.add("legal-National law");
		 showtagst4.add("local law");
		 valuetagst4.add("legal-local law");
		 showtagst4.add("other");
		 valuetagst4.add("legal-other");
		 et4.setShowTags(showtagst4);
		 et4.setValueTags(valuetagst4);
		 entity_TagDTO et5=new entity_TagDTO();
		 et5.setCategoryname("military");
		 List<String> showtagst5=new ArrayList<String>();
		 List<String> valuetagst5=new ArrayList<String>();
		 showtagst5.add("personage");
		 valuetagst5.add("military-personage");
		 showtagst5.add("war");
		 valuetagst5.add("military-war");
		 showtagst5.add("arms");
		 valuetagst5.add("military-arms");
		 showtagst5.add("conflict");
		 valuetagst5.add("military-conflict");
		 showtagst5.add("other");
		 valuetagst5.add("military-other");
		 et5.setShowTags(showtagst5);
		 et5.setValueTags(valuetagst5);
		 entity_TagDTO et6=new entity_TagDTO();
		 et6.setCategoryname("Technology");
		 List<String> showtagst6=new ArrayList<String>();
		 List<String> valuetagst6=new ArrayList<String>();
		 showtagst6.add("personage");
		 valuetagst6.add("Technology-personage");
		 showtagst6.add("Internet");
		 valuetagst6.add("Technology-Internet");
		 showtagst6.add("artificial intelligence");
		 valuetagst6.add("Technology-artificial intelligence");
		 showtagst6.add("discover");
		 valuetagst6.add("Technology-discover");
		 showtagst6.add("theory");
		 valuetagst6.add("Technology-theory");
		 showtagst6.add("explore");
		 valuetagst6.add("Technology-explore");
		 showtagst6.add("other");
		 valuetagst6.add("Technology-other");
		 et6.setShowTags(showtagst6);
		 et6.setValueTags(valuetagst6);
		 entity_TagDTO et7=new entity_TagDTO();
		 et7.setCategoryname("society");
		 List<String> showtagst7=new ArrayList<String>();
		 List<String> valuetagst7=new ArrayList<String>();
		 showtagst7.add("personage");
		 valuetagst7.add("society-personage");
		 showtagst7.add("Crime");
		 valuetagst7.add("society-Crime");
		 showtagst7.add("education");
		 valuetagst7.add("society-education");
		 showtagst7.add("Healthy");
		 valuetagst7.add("society-Healthy");
		 showtagst7.add("Culture");
		 valuetagst7.add("society-Culture");
		 showtagst7.add("Eco climate");
		 valuetagst7.add("society-Eco climate");
		 showtagst7.add("Social news");
		 valuetagst7.add("society-Social news");
		 showtagst7.add("Strange news");
		 valuetagst7.add("society-Strange news");
		 showtagst7.add("other");
		 valuetagst7.add("society-other");
		 et7.setShowTags(showtagst7);
		 et7.setValueTags(valuetagst7);
		 entity_TagDTO et8=new entity_TagDTO();
		 et8.setCategoryname("economic");
		 List<String> showtagst8=new ArrayList<String>();
		 List<String> valuetagst8=new ArrayList<String>();
		 showtagst8.add("personage");
		 valuetagst8.add("economic-personage");
		 showtagst8.add("business");
		 valuetagst8.add("economic-business");
		 showtagst8.add("Bank");
		 valuetagst8.add("economic-Bank");
		 showtagst8.add("enterprise");
		 valuetagst8.add("economic-enterprise");
		 showtagst8.add("data");
		 valuetagst8.add("economic-data");
		 showtagst8.add("other");
		 valuetagst8.add("economic-other");
		 et8.setShowTags(showtagst8);
		 et8.setValueTags(valuetagst8);
		 
		 entity_TagDTO et9=new entity_TagDTO();
		 et9.setCategoryname("entertainment");
		 List<String> showtagst9=new ArrayList<String>();
		 List<String> valuetagst9=new ArrayList<String>();
		 showtagst9.add("personage");
		 valuetagst9.add("entertainment-personage");
		 showtagst9.add("physical culture");
		 valuetagst9.add("entertainment-physical culture");
		 showtagst9.add("Variety");
		 valuetagst9.add("entertainment-Variety");
		 showtagst9.add("Game");
		 valuetagst9.add("entertainment-Game");
		 showtagst9.add("other");
		 valuetagst9.add("entertainment-other");
		 
		 et9.setShowTags(showtagst9);
		 et9.setValueTags(valuetagst9);
		 
		 
		 
		 etst.add(et);
		 etst.add(et2);
		 etst.add(et3);
		 etst.add(et4);
		 
		 etst.add(et5);
		 etst.add(et6);
		 etst.add(et7);
		 etst.add(et8);
		 etst.add(et9);
		 return etst;
		 
	}
	
    public String returntag(String tag,String value)
    {   
    	try {
         	List<String> delete=null;
        	List<entity_TagDTO> ets=getTag();
 
        	for(entity_TagDTO e:ets)
        	{
        		if(e.getCategoryname().equals(value))
        		{
        			 delete=e.getValueTags();
        			break;
        		}
        	}
 
        	String[] tags=tag.split(",");
         	 
        	
        	for(int i=0;i<tags.length;i++)
        	{
        		for(int j=0;j<delete.size();j++)
        		{
         			  if(tags[i].equals(delete.get(j))||tags[i].equals(value))
        			  {
        				  tags[i]=null;
        				  break;
        			  }
        		}
        	}
 
            List<String> tags2=new ArrayList<String>();
        	for(int i=0;i<tags.length;i++)
        	{
        		 
        		if(tags[i]!=null)
        		{
        			tags2.add(tags[i]);
        		}
        	}
 
        	String[] stag=new String[tags2.size()];
        	
        	tags2.toArray(stag);
 
        	String restag2=Arrays.stream(stag).collect(Collectors.joining(","));
 
        	return restag2;
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    		System.out.println(ex.getMessage());
    		return null;
    	}
    	
    
    	
    }
    
    public boolean submittagpublish(String tag)
    {
    	
     try {
    		List<entity_TagDTO> etd=getTag();
        	Map<String,List<String>> ma=new HashMap<String,List<String>>();
        
        	//String tags[]=tag.split(",");
        	String[] tags=tag.split(",");
        	 ArrayList<String> list = new ArrayList<String>();
       	
            for (int i = 0; i < tags.length; i++) {
                if (!list.contains(tags[i]))
                    list.add(tags[i]);
            }
            String[] taga=list.toArray(new String[0]);
       	 
             if(taga.length!=tags.length)
             {
            	 return false;
             }
        	for(int i=0;i<etd.size();i++)
        	{
        		ma.put(etd.get(i).getCategoryname(),etd.get(i).getValueTags());
         	}
        	Set<String> catekey=ma.keySet();
        	List<String> catekeylist=new ArrayList<String>(catekey);
        	for(int i=0;i<tags.length;i++)
        	{
        		for(int j=0;j<catekeylist.size();j++)
        		{
        			  List<String> m=ma.get(catekeylist.get(j));
        			  for(int sm=0;sm<m.size();sm++)
        			  {
          				  if(tags[i].equals(m.get(sm)))
        				  {
        					 j=catekeylist.size()-1;
        					break;
        				  }else if(j==catekeylist.size()-1)
        				  {
        					 
        					  return false;
        				  }
        					  
        			  }
        			
        		}
         	}
        	List<String> con=ma.get("country");
        	for(int i=0;i<tags.length;i++)//消灭国家标签
        	{
        		for(int j=0;j<con.size();j++)
        		{
        			if(tags[i].equals(con.get(j)))
        			{
        				tags[i]=null;
        				break;
        			}
        		}
        	}
        	
        	
        	
          	ma.remove(catekeylist.get(0));
         	catekeylist.remove(0);
         	
           List<String> checkout=new ArrayList<String>();
         	
         	//判断某个父类标签下有没有写子类标签
          	
          
         	for(int i=1;i<catekeylist.size();i++)
         	{
               for(int j=0;j<tags.length;j++)
               {
             	      if(tags[j]!=null&&catekeylist.get(i).equals(tags[j]))
            	      {
             	    	  checkout.add(tags[j]);
            	    	  j=tags.length-1;
            	    	  break;
            	      }
               }
         	}
         	
         	if(fathertagishavesontag(tags,checkout,ma,catekeylist)&&sontagishavefathertag(tags,checkout,ma,catekeylist))
         	{
         		return true;
         	}else
         	{
         		return false;
         	}
         	
 
 
        	
        	
      }catch(Exception ex)
     {
    	 ex.printStackTrace();
    	 System.out.println("--"+ex.getMessage());
    	 return false;
     }
    
    }
    
    public boolean fathertagishavesontag(String[] tags,List<String> checkout,Map<String,List<String>> ms,List<String> catelist)
    {
          for(int i=0;i<catelist.size();i++)
          {
        	  for(int j=0;j<checkout.size();j++)
        	 {
        	       if(checkout.get(j).equals(catelist.get(i)))
        	       {
        	    	   List<String> ls=ms.get(catelist.get(i));
        	    	   for(int m=0;m<ls.size();m++)
        	    	   {
        	    		   for(int s=0;s<tags.length;s++)
        	    		   {
        	    			    if(tags[s]!=null&&tags[s].equals(ls.get(m)))
        	    			    {
        	    			    	s=tags.length-1;
        	    			    	m=ls.size()-1;   	    			    	
        	    			    	break;
        	    			    }else if(m==ls.size()-1&&s==tags.length-1)
        	    			    {
        	    			    	return false;
        	    			    }
        	    		   }
        	    	   }
        	       }
        	 }
          }
    	return true;
    }
    public boolean sontagishavefathertag(String[] tags,List<String> checkout,Map<String,List<String>> ms,List<String> catelist)
    {
    	 for(int i=0;i<checkout.size();i++)
    	 {
    		 catelist.remove(checkout.get(i));
    	 }
    	 catelist.remove("topic");
    	 for(int i=0;i<catelist.size();i++)
    	 {
    		 List<String> tag=ms.get(catelist.get(i));
    		 for(int j=0;j<tags.length;j++)
    		 {
    			 for(String t:tag){
    	            if(tags[j]!=null&&t.equals(tags[j]))
    	            {
       				 System.out.println(t+"---"+tags[j]);
    	            	return false;
    	            }
    			 }
    		 }
    	 }
    	 
    	 return true;
    }
	
}
