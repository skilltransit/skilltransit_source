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

package com.tekniti.skilltransit.service.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.tekniti.skilltransit.service.model.SkillSubCategory;
import com.tekniti.skilltransit.service.service.SkillSubCategoryLocalServiceUtil;

/**
 * The extended model base implementation for the SkillSubCategory service. Represents a row in the &quot;skill_subcategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SkillSubCategoryImpl}.
 * </p>
 *
 * @author Hari
 * @see SkillSubCategoryImpl
 * @see com.tekniti.skilltransit.service.model.SkillSubCategory
 * @generated
 */
public abstract class SkillSubCategoryBaseImpl extends SkillSubCategoryModelImpl
	implements SkillSubCategory {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a skill sub category model instance should use the {@link SkillSubCategory} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			SkillSubCategoryLocalServiceUtil.addSkillSubCategory(this);
		}
		else {
			SkillSubCategoryLocalServiceUtil.updateSkillSubCategory(this);
		}
	}
}