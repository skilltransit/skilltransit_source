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

import com.tekniti.skilltransit.service.model.UserSkills;

import java.io.Serializable;

/**
 * The cache model class for representing UserSkills in entity cache.
 *
 * @author Hari
 * @see UserSkills
 * @generated
 */
public class UserSkillsCacheModel implements CacheModel<UserSkills>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{primId=");
		sb.append(primId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append("}");

		return sb.toString();
	}

	public UserSkills toEntityModel() {
		UserSkillsImpl userSkillsImpl = new UserSkillsImpl();

		userSkillsImpl.setPrimId(primId);

		if (name == null) {
			userSkillsImpl.setName(StringPool.BLANK);
		}
		else {
			userSkillsImpl.setName(name);
		}

		userSkillsImpl.setUser_id(user_id);

		userSkillsImpl.resetOriginalValues();

		return userSkillsImpl;
	}

	public long primId;
	public String name;
	public long user_id;
}