 
  function reply() {
 
var questionid = $("#questionid").val();
var comment = $("#comment_content").val();
	if (!comment) {
		alert("The comment you entered cannot be empty.");
		return;
	}

	$.ajax({
			url : "https://localhost:8080/BPJprojects/comment",
				type : "post",
				contentType : "application/json",
			data : JSON.stringify({
					"commentparentid" : questionid,
				"context" : comment,
				"type" : 2
				}),
			dataType : "json",
			success : function(response) {
					if (response.code == 100000) {
						$("#comment_section").hide();
					window.location.reload();
					} else {
					if (response.code == 2004) {
							var conf = confirm(response.message);
						if (conf) {
							window
								.open("https://github.com/login/oauth/authorize?client_id=ae9db0ad005fe0e78ee4&redirect_uri=https://localhost:8080/BPJprojects/callback&scope=user&state=1");
							window.localStorage.setItem("closable", "true");
					}
						} else {
							alert(response.message);
						}

					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
				}
			});
 
}

function colcomments(e) {
 	var id = e.getAttribute("data-id");
 	var secondcomment = $("#comment-" + id);
 	var collapse = e.getAttribute("data-collapse");
 	if (collapse==null) {
  		// classList
  		e.classList.add("active");
  		secondcomment.addClass("in");
 		// 标记二级评论展开状态
 		e.setAttribute("data-collapse", "in");
 		// $.getJSON("/comment/id",function(data){})
 		$.ajax({
 			 url:"https://localhost:8080/BPJprojects/comment/"+id,
 			 type:"post",
 			 contentType:"application/json",
 			 
 				dataType : "json",
 				success : function(response) {
 			 
 		         $("#comment-"+id+" .secondcomment").remove();
  					
    				    for(i=0;i<response.length;i++)
  				    {
  				    	var cont=response[i].context;
  				    	var avatar_url=response[i].eu.avatar_url;
  				    	var login=response[i].eu.login;
  				    	addsecondcommit(avatar_url,login,cont,id);
  				    }
 				},
 				error : function(XMLHttpRequest, textStatus, errorThrown) {
 					alert(XMLHttpRequest.status);
 					alert(XMLHttpRequest.readyState);
 					alert(textStatus);
 				}
 			 
 		});
 	} else {
 		e.classList.remove("active");
 		secondcomment.removeClass("in");
 		e.removeAttribute("data-collapse");
 		
	}
}


function addsecondcommit(avater_url,login,context,id)
{
     var s_li='<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 secondcomment">';
        s_li+='<div class="media">';
        s_li+='<div class="media-left">';
        s_li+='<a> <img class="media-object img-rounded" src='+avater_url+'>';//
        s_li+='</a>';
        s_li+='</div>';
        s_li+='<div class="media-body">';
        s_li+='<h4 class="media-heading">';
        s_li+='<span>'+login+'</span>';//
        s_li+='</h4>';
        s_li+='<div>'+context+'</div>';//
        s_li+='<div class="iconmenu">';
        s_li+='<span class="pull-right"></span>';
        s_li+='</div>';
        s_li+='</div>';
        s_li+='</div>';
        s_li+='</div>';
        var $s_li=$(s_li);
        $("#comment-"+id).prepend($s_li);          	
}




function secondcommit(s){
	var questionid = s.getAttribute("data-id");
	var secondcomment = $("#input" + questionid);
 
  	var comment=secondcomment.val();
 	
 
	$.ajax({
		 url:"https://localhost:8080/BPJprojects/comment",
		 type:"post",
		 contentType:"application/json",
		 data : JSON.stringify({
				"commentparentid" : questionid,
				"context" : comment,
				"type" : 1
			}),
			dataType : "json",
			success : function(response) {
				if (response.code == 100000) {
					$("#comment_section").hide();
					window.location.reload();
				} else {
					if (response.code == 2004) {
						var conf = confirm(response.message);
						if (conf) {
							window.open("https://github.com/login/oauth/authorize?client_id=ae9db0ad005fe0e78ee4&redirect_uri=https://localhost:8080/BPJprojects/callback&scope=user&state=1");
							window.localStorage.setItem("closable", "true");
						}
					} else {
						alert(response.message);
					}

				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		 
	});
}


