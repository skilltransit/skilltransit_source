<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page
	import="org.tekniti.skilltransit.busobj.SkillEntryRegistration,org.tekniti.skilltransit.busobj.SkillEntry"%>
<portlet:actionURL var="addBillEntry">
	<portlet:param name="action" value="addBillEntry" />
</portlet:actionURL>
<portlet:resourceURL var="resourceURL" />
<script>
var skill_search_tags=${userSkillsTags};
var ajaxurl='${resourceURL}';
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
				category : "required"
			},
			messages : {
				category : "Please enter your technology category",
				hourlyRate : "Please enter your hourly billing rate in dollars.",
				zip : "Please enter a valid 5 digit zip code."
			}
		});
	});
	function submitBilling(){
		var skills = [];
		jQuery("ul#geh_group_select_typeahead_box2_Tag li.addedLst").each( function(){ skills.push({ name: jQuery(this).find(".addLstTxt").html(), id: Number(jQuery(this).find(".srchUIDTxt").html()) }) });
		jQuery("#geh_group_select_skills_tags_json").val(JSON.stringify(skills));
		document.profileForm.action='${addBillEntry}';
		document.profileForm.submit();
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
	commandName="billEntry" class="form-horizontal" id="profileForm">
	<fieldset>
		Thank you for submitting your billing details. Here is the dash board.
		<div class="control-group">
			<label class="control-label" for="category">Technology
				Category*</label>
			<div class="controls">
				<select id="category" name="category">
					<c:forEach items="${categories}" var="categories">
						<option value="${categories.primaryId}" ${categories.primaryId == category ? 'selected' : ''}>${categories.name}</option>
					</c:forEach>
				</select>
				<form:errors path="category" class="help-inline" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="skills">Your skill search criteria</label>
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
	</fieldset>

</form:form>