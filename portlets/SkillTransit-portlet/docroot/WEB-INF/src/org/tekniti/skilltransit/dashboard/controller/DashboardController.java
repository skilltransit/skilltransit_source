package org.tekniti.skilltransit.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.util.PortalUtil;
import com.tekniti.skilltransit.service.model.SkillCategory;
import com.tekniti.skilltransit.service.model.SkillSubCategory;
import com.tekniti.skilltransit.service.model.UserDetails;
import com.tekniti.skilltransit.service.service.SkillCategoryLocalServiceUtil;
import com.tekniti.skilltransit.service.service.SkillSubCategoryLocalServiceUtil;
import com.tekniti.skilltransit.service.service.UserDetailsLocalServiceUtil;
import com.tekniti.skilltransit.service.service.UserSkillsLocalServiceUtil;

@Controller(value = "dashBoardController")
@RequestMapping(value = "VIEW")
public class DashboardController {

	private static Logger _log = Logger.getLogger(DashboardController.class
			.getName());
	private static List<SkillCategory> categories;
	private static List<SkillSubCategory> subcategories;

	@RenderMapping
	public String showBasicInfoForm(ModelMap model, RenderRequest request,
			RenderResponse response) throws SystemException, NumberFormatException, PortalException {
		UserDetails userDetails=null;
		List<String> userSkills=new ArrayList<String>();
		String category="";
		long userId=0L;
		_log.info("dashBoardController: showBasicInfoForm (Render)");
		HttpServletRequest httpRequest = PortalUtil
				.getHttpServletRequest(request);
		String userIdCookie="";
		Cookie[] cookies = httpRequest.getCookies();
		System.out.println("cookies lenght is "+cookies.length);
		for (int i = 0; i < cookies.length; i++) {
			System.out.println("cookie name is "+cookies[i].getName());
			if (cookies[i].getName().equals("userId")){
				userIdCookie=cookies[i].getValue();
				System.out.println("Hello" + userIdCookie);
			}
		}
		if(!StringUtils.isEmpty(userIdCookie)){
			userId=Long.parseLong(userIdCookie);
			userDetails=UserDetailsLocalServiceUtil.getUserDetails(userId);
			category=userDetails.getCategory();
			userSkills=UserSkillsLocalServiceUtil.getUserSkillsByUserId(userId);
		}else{
			category="1";
		}
		model.addAttribute("userSkills", userSkills);
		model.addAttribute("category", category);
		model.addAttribute("userSkillsTags",JSONFactoryUtil.looseSerialize(userSkills));
		
		return "dashboard";
	}

	@RequestMapping(params = "action=dashboard")
	public void showDashboard(ModelMap model, ActionRequest request,
			ActionResponse response) {
		_log.info("dashBoardController: showBasicInfoForm (action)");
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
}