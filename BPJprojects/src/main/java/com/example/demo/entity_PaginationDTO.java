package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class entity_PaginationDTO {
  private List<entity_questionDTO> eq;
  private boolean showPrevious;
  private boolean showFirstPage;
  private boolean showEndPage;
  private boolean showNext;
  private Integer page;
  private List<Integer> pages=new ArrayList<Integer>();
  private Integer countpage;
  
  public void setPagination(Integer countpage,Integer page)
  {
	 
	  this.countpage=countpage;
	  if(page<=4)
	  {
		if(countpage>=7)
		{
			for(int i=1;i<=7;i++)
			{
				pages.add(i);
			}
		}else
		{
			for(int i=1;i<=countpage;i++)
			{
				pages.add(i);
			}
		}
	  }else if(page>4&&page<countpage-4)
	  {
		  for(int i=page-3;i<=page+3;i++)
		  {
			  pages.add(i);
		  }
	  }
	  else
	  {
		  if(countpage>7)
		  {
			  for(int i=countpage-7;i<=countpage;i++)
				{
					pages.add(i);
				}
		  }
		  else
		  {
			    for(int i=1;i<=countpage;i++)
			    {
			    	pages.add(i);
			    }
		  }
		
	  }
	  
 	if(page==1)
	{
 		this.showPrevious=false;
	}
	else
	{
		this.showPrevious=true;
	}
	if(page==countpage)
	{
 		this.showNext=false;
	}else
	{
 	    this.showNext=true;
	}
    if(pages.contains(1))
    {
    	this.showFirstPage=false;
    }else
    {
    	this.showFirstPage=true;
    }
    if(pages.contains(countpage))
    {
    	this.showEndPage=false;
    }
    else
    {
    	this.showEndPage=true;
    }
	this.page=page;
	
	 
  }
  
}
