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
 * This class is a wrapper for {@link SkillCategoryService}.
 * </p>
 *
 * @author    Hari
 * @see       SkillCategoryService
 * @generated
 */
public class SkillCategoryServiceWrapper implements SkillCategoryService,
	ServiceWrapper<SkillCategoryService> {
	public SkillCategoryServiceWrapper(
		SkillCategoryService skillCategoryService) {
		_skillCategoryService = skillCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _skillCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_skillCategoryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _skillCategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SkillCategoryService getWrappedSkillCategoryService() {
		return _skillCategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSkillCategoryService(
		SkillCategoryService skillCategoryService) {
		_skillCategoryService = skillCategoryService;
	}

	public SkillCategoryService getWrappedService() {
		return _skillCategoryService;
	}

	public void setWrappedService(SkillCategoryService skillCategoryService) {
		_skillCategoryService = skillCategoryService;
	}

	private SkillCategoryService _skillCategoryService;
}