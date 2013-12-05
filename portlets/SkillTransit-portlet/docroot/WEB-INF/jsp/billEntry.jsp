<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@page
	import="org.tekniti.skilltransit.busobj.SkillEntryRegistration,org.tekniti.skilltransit.busobj.SkillEntry"%>
<portlet:actionURL var="addBillEntry">
	<portlet:param name="action" value="addBillEntry" />
</portlet:actionURL>
<liferay-portlet:resourceURL portletName="AjaxPortlet_WAR_SkillTransitportlet" var="ajaxUrl"/>
<portlet:resourceURL var="resourceURL" />
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script>
var skill_search_tags='';
var ajaxurl='${ajaxUrl}';
//alert('ajaxurl is '+ajaxurl);
jQuery(document).ready(function() {
	$('#profileForm').bind('change keyup', function() {
		validateForm();
	});
});
	$(function() {
		$("#profileForm").validate({
			rules : {
				hourlyRate: {
				      required: true,
				      number: true
				 },
				 zip: {
					  required: true,
					  minlength: 5,
	                  maxlength: 5,
					  digits: true
				},
				geh_group_select_typeahead_input_Tag: {
		      	required: {
		        	depends: function() {
		            	var flag=jQuery("ul#geh_group_select_typeahead_box2_Tag li.addedLst").size()==0;
		            	return flag;
		        }
		      	}
		      },
				category : "required"
			},
			messages : {
				geh_group_select_typeahead_input_Tag: {
				      required: "Please enter at least one skill",
				},
				category : "Please enter your technology category",
				hourlyRate : "Please enter your hourly billing rate in dollars.",
				zip : "Please enter a valid 5 digit zip code."
			}
		});
	});
	function submitForm(){
		var skills = [];
		jQuery("ul#geh_group_select_typeahead_box2_Tag li.addedLst").each( function(){ skills.push({ name: jQuery(this).find(".addLstTxt").html(), id: Number(jQuery(this).find(".srchUIDTxt").html()) }) });
		jQuery("#skills").val(JSON.stringify(skills));
		document.getElementById('skills').value=JSON.stringify(skills);
		document.profileForm.action='${addBillEntry}';
		document.profileForm.submit();
	}
	function submitBilling(){
		var zipcode=document.getElementById('zip').value;
		var country = 'United States';               
		var geocoder = new google.maps.Geocoder();
		var stateName = '';
	    geocoder.geocode({ 'address': zipcode + ',' + country }, function (result, status) {
			var addressComponent = result[0]['address_components'];

		    // find state data
		    var stateQueryable = $.grep(addressComponent, function (x) {
		        return $.inArray('administrative_area_level_1', x.types) != -1;
		    });
		    if (stateQueryable.length) {
		        stateName = stateQueryable[0]['short_name'];
		        document.getElementById('stateCode').value=stateName;
		        submitForm();
		    }
		    
		});
		return stateName;
	}
</script>
<div class="container">
	<div class="row">
		<div class="span12">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#">Enter your Billing</a></li>
			</ul>
		</div>
	</div>
</div>
<form:form name="profileForm" method="post" action="${addBillEntry}"
	commandName="skillEntry" class="form-horizontal" id="profileForm">
	<input type="hidden" id="skills" name="skills" value=""/>
	<input type="hidden" id="stateCode" name="stateCode" value=""/>
	<fieldset>
		<div class="control-group">
			<label class="control-label" for="category">Technology
				Category*</label>
			<div class="controls">
				<%-- <form:select path="category" id="reportSelection">
			    <form:options items="${categories}" itemLabel="name" itemValue="primaryId"/>
			</form:select> --%>
				<select id="category" name="category">
					<c:forEach items="${categories}" var="categories">
						<option value="${categories.primaryId}">${categories.name}</option>
					</c:forEach>
				</select>
				<form:errors path="category" class="help-inline" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="hourlyRate">Hourly Rate*</label>
			<div class="controls">
				<input type="text" id="hourlyRate" name="hourlyRate" required>
				<form:errors path="hourlyRate" class="help-inline" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="zip">Zip code*</label>
			<div class="controls">
				<input type="text" id="zip" name="zip" required>
				<form:errors path="zip" class="help-inline" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="skills">Please enter your
				skills*</label>
			<div class="geh_group_select_typeahead_row">
				<div class="geh_group_select_typeahead_widget">
					<div class="geh_group_select_typeahead_box1">
						<ul class="geh_group_select_typeahead_box2" id="geh_group_select_typeahead_box2_Tag">
							<li class="geh_group_select_typeahead_list"><input type="text" required id="geh_group_select_typeahead_input_Tag" name="geh_group_select_typeahead_input_Tag"/><li>
						</ul>	
					</div>
					
					<div class="geh_group_select_typeahead_dropdown1">
						<div class="geh_group_select_typeahead_dropdown2" id="geh_group_select_typeahead_dropdown2_Tag" style="z-index:1000">
							<ul class="geh_group_select_typeahead_dropdown3" id="geh_group_select_typeahead_dropdown3_Tag"></ul>
						</div>
					</div>
				</div>
			</div>	
		</div>
		<div>
		<input class="button button_disabled" type="button" value="Continue" id="submitbutton" name="submitbutton" onclick="javascript:submitBilling()"/>
		
		</div>
	</fieldset>

</form:form>