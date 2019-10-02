function returntag(values) {
  
 	var tags = $("#tag").val();
 	
	$.ajax({
		url : "https://localhost:8080/BPJprojects/delorselcet",
			type : "post",
			 
		 data:{"taglist":tags,"titlels":values},
		dataType : "text",
		success : function(result) {
 			$("#tag").val(result);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		});


	}


function selectTag(value) {

	var tagvalue = value.getAttribute("data-tagvalue");

	var tags = $("#tag").val();
	if (tags.indexOf(tagvalue) != -1) {

	} else {
		if (tags) {
			$("#tag").val(tags + "," + tagvalue);
		} else {
			$("#tag").val(tagvalue);
		}

	}

}

function showselectTag() {
	$(".taglike").show();
}
