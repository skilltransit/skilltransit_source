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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.tekniti.skilltransit.service.model.SkillCategory;

import java.io.Serializable;

/**
 * The cache model class for representing SkillCategory in entity cache.
 *
 * @author Hari
 * @see SkillCategory
 * @generated
 */
public class SkillCategoryCacheModel implements CacheModel<SkillCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{primaryId=");
		sb.append(primaryId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public SkillCategory toEntityModel() {
		SkillCategoryImpl skillCategoryImpl = new SkillCategoryImpl();

		skillCategoryImpl.setPrimaryId(primaryId);

		if (name == null) {
			skillCategoryImpl.setName(StringPool.BLANK);
		}
		else {
			skillCategoryImpl.setName(name);
		}

		skillCategoryImpl.resetOriginalValues();

		return skillCategoryImpl;
	}

	public long primaryId;
	public String name;
}