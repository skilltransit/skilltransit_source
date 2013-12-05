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
 * This class is a wrapper for {@link UserDetailsService}.
 * </p>
 *
 * @author    Hari
 * @see       UserDetailsService
 * @generated
 */
public class UserDetailsServiceWrapper implements UserDetailsService,
	ServiceWrapper<UserDetailsService> {
	public UserDetailsServiceWrapper(UserDetailsService userDetailsService) {
		_userDetailsService = userDetailsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _userDetailsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userDetailsService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userDetailsService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserDetailsService getWrappedUserDetailsService() {
		return _userDetailsService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserDetailsService(
		UserDetailsService userDetailsService) {
		_userDetailsService = userDetailsService;
	}

	public UserDetailsService getWrappedService() {
		return _userDetailsService;
	}

	public void setWrappedService(UserDetailsService userDetailsService) {
		_userDetailsService = userDetailsService;
	}

	private UserDetailsService _userDetailsService;
}