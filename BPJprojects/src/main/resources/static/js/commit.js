function reply()
{
 
    var questionid=$("#questionid").val();
   var comment=$("#comment_content").val();
  

   $.ajax({
	  url:"https://localhost:8080/BPJprojects/comment",
	  type:"post",
	  contentType:"application/json",
	   data: JSON.stringify(
		 		{"commentparentid":questionid,
		 		  "context":comment,
		 		  "type":2}),
	  dataType: "json",
	  success:function(response)
	  {
 	       if(response.code==100000)
	       {
	    	   $("#comment_section").hide();
	       }else
	       {
	    	  if(response.code==2004)
	    		  {
	    		     var conf=confirm(response.message);
	    		     if(conf)
	    		     {
	    		    	 window.open("https://github.com/login/oauth/authorize?client_id=ae9db0ad005fe0e78ee4&redirect_uri=https://localhost:8080/BPJprojects/callback&scope=user&state=1");
	    		         window.localStorage.setItem("closable","true");
	    		     } 
	    		  }else
	    			  {
	    			  alert(response.message);
	    			  }
	    	   
	       }
	  },
	  error:function(XMLHttpRequest, textStatus, errorThrown)
	  {
		    alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
	  }
	});
 
 
 
 
 
 
//   success:function(response){
//		 if(response.code=9999)
//		{
//			 
//		}else
//			{
//			  alert(response.message);
//			}
//	  }
//   $.ajax({
//		url:"https://localhost:8080/BPJprojects/comment",
//   	type:"post",
//   	data:{"user_id":"asds"},
//   	dataType:"json"
//   
//	});
  }