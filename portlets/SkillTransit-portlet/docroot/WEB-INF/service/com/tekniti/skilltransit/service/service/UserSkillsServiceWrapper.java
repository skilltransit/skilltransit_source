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

package com.tekniti.skilltransit.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UserSkillsService}.
 * </p>
 *
 * @author    Hari
 * @see       UserSkillsService
 * @generated
 */
public class UserSkillsServiceWrapper implements UserSkillsService,
	ServiceWrapper<UserSkillsService> {
	public UserSkillsServiceWrapper(UserSkillsService userSkillsService) {
		_userSkillsService = userSkillsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _userSkillsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userSkillsService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userSkillsService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserSkillsService getWrappedUserSkillsService() {
		return _userSkillsService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserSkillsService(UserSkillsService userSkillsService) {
		_userSkillsService = userSkillsService;
	}

	public UserSkillsService getWrappedService() {
		return _userSkillsService;
	}

	public void setWrappedService(UserSkillsService userSkillsService) {
		_userSkillsService = userSkillsService;
	}

	private UserSkillsService _userSkillsService;
}