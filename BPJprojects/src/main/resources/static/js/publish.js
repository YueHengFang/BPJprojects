function selectTag(value) {
	 
	var tagvalue=value.getAttribute("data-tagvalue");
	 
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
function showselectTag()
{
   $(".taglike").show();  
}
 