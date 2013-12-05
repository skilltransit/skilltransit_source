package org.tekniti.skilltransit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.tekniti.skilltransit.busobj.SkillEntry;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.tekniti.skilltransit.service.model.SkillCategory;
import com.tekniti.skilltransit.service.model.SkillSubCategory;
import com.tekniti.skilltransit.service.model.UserDetails;
import com.tekniti.skilltransit.service.model.UserSkills;
import com.tekniti.skilltransit.service.model.impl.UserDetailsImpl;
import com.tekniti.skilltransit.service.service.SkillCategoryLocalServiceUtil;
import com.tekniti.skilltransit.service.service.SkillSubCategoryLocalServiceUtil;
import com.tekniti.skilltransit.service.service.UserDetailsLocalServiceUtil;
import com.tekniti.skilltransit.service.service.UserSkillsLocalServiceUtil;

@Controller(value = "skillEntryController")
@RequestMapping(value = "VIEW")
public class SkillEntryController {

	private static Logger _log = Logger.getLogger(SkillEntryController.class
			.getName());
	private static List<SkillCategory> categories;
	private static List<SkillSubCategory> subcategories;

	@ActionMapping(params = "action=addBillEntry")
	public void addBillEntry(@ModelAttribute SkillEntry skillEntry,
			Errors result, ModelMap model, ActionRequest request,
			ActionResponse response) throws SystemException, PortalException, IOException {
		System.out.println("SkillEntryController: addBillEntry");
		String skillsListForIndexing="";
		/*
		 * PortletSession session = request.getPortletSession();
		 * Enumeration enParams = request.getParameterNames();
		 * while(enParams.hasMoreElements()){ String paramName =
		 * (String)enParams.nextElement();
		 * System.out.println("Attribute Name - "
		 * +paramName+", Value - "+request.getParameter(paramName)); }
		 */
		String skills = request.getParameter("skills");
		String state = request.getParameter("stateCode");
		System.out.println("stae from request "+state);
		//String skillsFromObject = skillEntry.getSkills();
		System.out.println("skills are ::" + skills);
		String hourlyRate=String.valueOf(skillEntry.getHourlyRate());
		String zipCode=skillEntry.getZip();
		//System.out.println("skillsFromObject are ::" + skillsFromObject);
		List<Map> skillsList = (List<Map>) JSONFactoryUtil.looseDeserialize(
				skills, ArrayList.class);
		System.out.println(" skillsList length is " + skillsList.size());
		UserSkills userSkills=UserSkillsLocalServiceUtil.createUserSkills();
		System.out.println("userSkills id is "+userSkills.getPrimId());
		//TODO:insert these skills in database
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean signedIn = themeDisplay.isSignedIn();
		long userId=0;
		if(signedIn){
			userId=themeDisplay.getUserId();
		}else{
			userId=userSkills.getPrimId();
		}
		userSkills.setUser_id(userId);
		
		for (int i=0;i<skillsList.size();i++) {
			Map skillMap=skillsList.get(i);
			String skill=(String)skillMap.get("name");
			UserSkills persistentUserSkills=UserSkillsLocalServiceUtil.createUserSkills();
			persistentUserSkills.setName(skill);
			persistentUserSkills.setUser_id(userId);
			UserSkillsLocalServiceUtil.addUserSkills(persistentUserSkills);
			skillsListForIndexing+=" "+skill;
		}
		//: save billing rate,zip code in another table
		//TODO:index the user skill set
		UserDetails userDetails=new UserDetailsImpl();
		userDetails.setUserId(userId);
		userDetails.setHourlyRate(hourlyRate);
		userDetails.setZipCode(zipCode);
		userDetails.setSkill(skillsListForIndexing);
		userDetails.setCategory(skillEntry.getCategory());
		System.out.println("skillEntry.getState() is "+skillEntry.getStateCode() );
		userDetails.setState(skillEntry.getStateCode());
		UserDetailsLocalServiceUtil.addUserDetails(userDetails);
		/*
		 * use the below indexing example
		 * 
		 * assetEntryLocalService.updateEntry(
			    userId, entry.getGroupId(), BlogsEntry.class.getName(),
			    entry.getEntryId(), entry.getUuid(), assetCategoryIds,
			    assetTagNames, visible, null, null, entry.getDisplayDate(), null,
			    ContentTypes.TEXT_HTML, entry.getTitle(), null, summary, null, 0, 0,
			    null, false);*/
		System.out.println("before updating asset entry");
		//AssetEntryLocalServiceUtil.updateEntry(userId, themeDisplay.getCompanyGroupId(), UserDetails.class.getName(), userId, null, null);
		System.out.println("after updating asset entry");
		Cookie userCookie = new Cookie("userId",String.valueOf(userId));
		userCookie.setMaxAge(60*60*24);
		userCookie.setPath("/");
		response.addProperty(userCookie);
		response.sendRedirect("/web/guest/forums");
		
		//response.setRenderParameter("action", "dashboard");
		
		
		// Validate the addDoctorBasicInfoForm
		/*SkillEntryValidator skillEntryValidator = new SkillEntryValidator();
		skillEntryValidator.validate(skillEntry, result);
		if (result.hasErrors()) {
			System.err.println("SkillEntryController: CUSTOM ERRORS FOUND");
			response.setRenderParameter("action", "billEntry");
			return;
		}
		// First try to get the skillEntryRegistration from the PortletSession
		// in case it already exists.
		SkillEntryRegistration skillEntryRegistration = (SkillEntryRegistration) session
				.getAttribute("skillEntryRegistration");

		// If skillEntryRegistration is null create a new one and store it in
		// PortletSession.
		if (skillEntryRegistration == null) {
			skillEntryRegistration = new SkillEntryRegistration();
			skillEntryRegistration.setSkillEntry(skillEntry);
			session.setAttribute("skillEntryRegistration",
					skillEntryRegistration);
		} else {
			skillEntryRegistration.setSkillEntry(skillEntry);
		}*/

		
	}

	@RenderMapping
	public String showBasicInfoForm(ModelMap model, RenderRequest request,
			RenderResponse response) throws SystemException {
		_log.info("SkillEntryController: showBasicInfoForm (Render)");
		System.out.println("inside basic info");
		// don't overwrite the userProfileForm if it's already there
		if (!model.containsAttribute("skillEntry")) {
			SkillEntry skillEntry = new SkillEntry();
			model.addAttribute("skillEntry", skillEntry);
		}

		return "billEntry";
	}

	@ModelAttribute("categories")
	public List<SkillCategory> getCategories() throws SystemException {
		if (categories == null) {
			categories = SkillCategoryLocalServiceUtil
					.getSkillCategories(1, 30);
		}
		return categories;
	}

	@ModelAttribute("subcategories")
	public List<SkillSubCategory> getSubCategories() throws SystemException {
		if (subcategories == null) {
			int count = SkillSubCategoryLocalServiceUtil
					.getSkillSubCategoriesCount();
			subcategories = SkillSubCategoryLocalServiceUtil
					.getSkillSubCategories(1, count);
		}
		return subcategories;
	}

	@ResourceMapping
	public void getSkill(ResourceRequest request, ResourceResponse response,
			@RequestParam("skill") final String skill) throws PortletException {
		// serve resource here
		System.out.println("inside serve resource" + skill);
		String search = StringUtils.trimToEmpty(request.getParameter("skill"));
		if (!search.isEmpty()) {
			try {
				List<SkillSubCategory> subCategoryList = SkillSubCategoryLocalServiceUtil
						.typeaheadSearch(search);
				JSONArray results = JSONFactoryUtil.createJSONArray();
				for (SkillSubCategory subcat : subCategoryList) {
					JSONObject listEntry = JSONFactoryUtil.createJSONObject();
					listEntry.put("categoryId", subcat.getPrimaryId());
					listEntry.put("search", subcat.getName());
					listEntry.put("empty", StringUtils.EMPTY);
					results.put(listEntry);
				}
				response.getPortletOutputStream().write(
						results.toString().getBytes());
			} catch (Exception e) {
				_log.error("error rendering search request ", e.getCause());
				throw new PortletException("search failed");
			}

		}
	}
}