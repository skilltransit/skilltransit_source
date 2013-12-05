jQuery(document).ready(function() {
	geh_group_fnct_init_typeahead("_Tag", skill_search_tags);
	geh_group_fnct_typeahead("_Tag", ajaxurl,  ['search','empty', 'categoryId']);
	$('#geh_group_select_typeahead_input_FolkSon').keypress( function(e){	
		alert("e.which is"+e.which);
		if (e.which == 44){ // keyCode comma is 44	
			var version="_FolkSon";
			var name = $('#geh_group_select_typeahead_input' + version).val();
			var id = 0;
			
			jQuery("ul#geh_group_select_typeahead_box2" + version + " li.geh_group_select_typeahead_list").append('<li class="addedLst"><span class="addLstTxt">'+name+'</span><span class="srchUIDTxt">'+id+'</span><a href="javascript:void(0);">X</a></li>');
			$('#geh_group_select_typeahead_input' + version).val("");
			
			e.preventDefault();
		}
	});
	

	jQuery("ul#geh_group_select_typeahead_box2_FolkSon").delegate('li.addedLst a', 'click', function(){
		jQuery(this).parent().remove();
		jQuery('input#geh_group_select_typeahead_input' + version).focus();
	});
	
});
//setup typeahead functionality for group owners, group members, tags
function geh_group_fnct_typeahead(version, url, fields) {
	jQuery("ul#geh_group_select_typeahead_dropdown3" + version).delegate('li', 'click', function(){	
		var userName = jQuery(this).find("span.srchUserName").text();
		var userId = jQuery(this).find("span.userIdLst").text();
		jQuery("ul#geh_group_select_typeahead_box2" + version + " li.geh_group_select_typeahead_list").before('<li class="addedLst"><span class="addLstTxt">'+userName+'</span><span class="srchUIDTxt">'+userId+'</span><a href="javascript:void(0);">X</a></li>');
		jQuery("input#geh_group_select_typeahead_input" + version).val('');
		jQuery("ul#geh_group_select_typeahead_dropdown3" + version).empty();
		jQuery('input#geh_group_select_typeahead_input' + version).focus();
		validateForm();
	});
	
	jQuery("ul#geh_group_select_typeahead_box2" + version).delegate('li.addedLst a', 'click', function(){
		jQuery(this).parent().remove();
		jQuery('input#geh_group_select_typeahead_input' + version).focus();
		validateForm();
	});
	
	jQuery('#geh_group_select_typeahead_input' + version).bind('input', function() {
			jQuery("ul#geh_group_select_typeahead_dropdown3" + version).empty();
			geh_group_fnct_ajax_typeahead(version, url, jQuery("input#geh_group_select_typeahead_input" + version).val(), fields);
			validateForm();
	});
}
function validateForm(){
	var liSize=jQuery("ul#geh_group_select_typeahead_box2_Tag li.addedLst").size();
	if($('#profileForm').validate().checkForm() && liSize >0) {
        $('#submitbutton').removeClass('button_disabled').attr('disabled', false);
    } else {
        $('#submitbutton').addClass('button_disabled').attr('disabled', true);
    }
}
//ajax to get user list based on starting characters of name.
function geh_group_fnct_ajax_typeahead(version, retrieveUsersUrl, text, fields) {
	jQuery.ajax({
		type : "POST",
		url : retrieveUsersUrl,
		async : true, /* If set to non-async, browser shows page as "Loading.."*/
		data : {
			searchString: text,
			skill:text
		},
		cache : false,
		success : function(data) {
			var obj = jQuery.parseJSON(data);
			jQuery.each(obj,function(){
				jQuery("#geh_group_select_typeahead_dropdown3" + version).append('<li><span class="srchUserName">'+this[fields[0]]+'</span><span class="srchJobTitle">'+this[fields[1]]+'</span><span class="userIdLst">'+this[fields[2]]+'</span></li>');
			});
		} 
	});
}
//init typeahead for explicit search criteria
function geh_group_fnct_init_typeahead(version, values) {
	jQuery.each(values,function(){
		var name = this.name;
		var id = this.id;
		jQuery("ul#geh_group_select_typeahead_box2" + version + " li.geh_group_select_typeahead_list").append('<li class="addedLst"><span class="addLstTxt">'+name+'</span><span class="srchUIDTxt">'+id+'</span><a href="javascript:void(0);">X</a></li>');
	});
}