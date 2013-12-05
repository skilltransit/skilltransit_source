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
 * This class is a wrapper for {@link SkillSubCategoryService}.
 * </p>
 *
 * @author    Hari
 * @see       SkillSubCategoryService
 * @generated
 */
public class SkillSubCategoryServiceWrapper implements SkillSubCategoryService,
	ServiceWrapper<SkillSubCategoryService> {
	public SkillSubCategoryServiceWrapper(
		SkillSubCategoryService skillSubCategoryService) {
		_skillSubCategoryService = skillSubCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _skillSubCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_skillSubCategoryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _skillSubCategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SkillSubCategoryService getWrappedSkillSubCategoryService() {
		return _skillSubCategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSkillSubCategoryService(
		SkillSubCategoryService skillSubCategoryService) {
		_skillSubCategoryService = skillSubCategoryService;
	}

	public SkillSubCategoryService getWrappedService() {
		return _skillSubCategoryService;
	}

	public void setWrappedService(
		SkillSubCategoryService skillSubCategoryService) {
		_skillSubCategoryService = skillSubCategoryService;
	}

	private SkillSubCategoryService _skillSubCategoryService;
}