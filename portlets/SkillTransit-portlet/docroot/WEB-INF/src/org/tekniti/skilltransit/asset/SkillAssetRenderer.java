/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.tekniti.skilltransit.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.tekniti.skilltransit.service.model.UserDetails;


public class SkillAssetRenderer extends BaseAssetRenderer {

	public SkillAssetRenderer(UserDetails entry) {
		_entry = entry;
	}

	@Override
	public long getClassPK() {
		return _entry.getUserId();
	}

	@Override
	public String getDiscussionPath() {
			return null;
	}

	@Override
	public long getGroupId() {
		return _entry.getUserId();
	}

	@Override
	public String getSummary(Locale locale) {
		String summary = _entry.getSkill();

		if (Validator.isNull(summary)) {
			summary = StringUtil.shorten(
				HtmlUtil.stripHtml(_entry.getSkill()), 200);
		}

		return summary;
	}

	@Override
	public String getTitle(Locale locale) {
		return _entry.getCategory();
	}

	@Override
	public PortletURL getURLEdit(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			getControlPanelPlid(liferayPortletRequest), PortletKeys.BLOGS,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter("struts_action", "/blogs/edit_entry");
		portletURL.setParameter("entryId", String.valueOf(_entry.getUserId()));

		return portletURL;
	}

	@Override
	public String getUrlTitle() {
		return _entry.getCategory();
	}

	@Override
	public PortletURL getURLView(
			LiferayPortletResponse liferayPortletResponse,
			WindowState windowState)
		throws Exception {

		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			PortletKeys.BLOGS, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("struts_action", "/blogs/view_entry");
		portletURL.setParameter("entryId", String.valueOf(_entry.getUserId()));
		portletURL.setWindowState(windowState);

		return portletURL;
	}

	@Override
	public String getURLViewInContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		String noSuchEntryRedirect) {

		return getURLViewInContext(
			liferayPortletRequest, noSuchEntryRedirect, "/blogs/find_entry",
			"entryId", _entry.getUserId());
	}

	@Override
	public long getUserId() {
		return _entry.getUserId();
	}

	@Override
	public String getUserName() {
		//return _entry.getUserName();
		//TODO: Not sure how this is useful
		return "dummy User";
	}

	@Override
	public String getUuid() {
		try {
			return _entry.getUserUuid();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		return true;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		return true;
	}

	@Override
	public boolean isPrintable() {
		return true;
	}

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse,
			String template)
		throws Exception {

		if (template.equals(TEMPLATE_ABSTRACT) ||
			template.equals(TEMPLATE_FULL_CONTENT)) {

			renderRequest.setAttribute("SkillTransit_WAR_SkillTransitportle", _entry);

			return "/html/portlet/blogs/asset/" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/blogs/blogs.png";
	}

	private UserDetails _entry;

}