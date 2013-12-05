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

package com.tekniti.skilltransit.service.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.tekniti.skilltransit.service.service.ClpSerializer;
import com.tekniti.skilltransit.service.service.SkillCategoryLocalServiceUtil;
import com.tekniti.skilltransit.service.service.SkillCategoryServiceUtil;
import com.tekniti.skilltransit.service.service.SkillSubCategoryLocalServiceUtil;
import com.tekniti.skilltransit.service.service.SkillSubCategoryServiceUtil;
import com.tekniti.skilltransit.service.service.UserDetailsLocalServiceUtil;
import com.tekniti.skilltransit.service.service.UserDetailsServiceUtil;
import com.tekniti.skilltransit.service.service.UserSkillsLocalServiceUtil;
import com.tekniti.skilltransit.service.service.UserSkillsServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			SkillCategoryLocalServiceUtil.clearService();

			SkillCategoryServiceUtil.clearService();
			SkillSubCategoryLocalServiceUtil.clearService();

			SkillSubCategoryServiceUtil.clearService();
			UserDetailsLocalServiceUtil.clearService();

			UserDetailsServiceUtil.clearService();
			UserSkillsLocalServiceUtil.clearService();

			UserSkillsServiceUtil.clearService();
		}
	}
}