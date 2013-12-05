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

import com.tekniti.skilltransit.service.model.UserDetails;

import java.io.Serializable;

/**
 * The cache model class for representing UserDetails in entity cache.
 *
 * @author Hari
 * @see UserDetails
 * @generated
 */
public class UserDetailsCacheModel implements CacheModel<UserDetails>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", hourlyRate=");
		sb.append(hourlyRate);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", category=");
		sb.append(category);
		sb.append(", client=");
		sb.append(client);
		sb.append(", commute=");
		sb.append(commute);
		sb.append(", skill=");
		sb.append(skill);
		sb.append(", state=");
		sb.append(state);
		sb.append("}");

		return sb.toString();
	}

	public UserDetails toEntityModel() {
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();

		userDetailsImpl.setUserId(userId);

		if (hourlyRate == null) {
			userDetailsImpl.setHourlyRate(StringPool.BLANK);
		}
		else {
			userDetailsImpl.setHourlyRate(hourlyRate);
		}

		if (zipCode == null) {
			userDetailsImpl.setZipCode(StringPool.BLANK);
		}
		else {
			userDetailsImpl.setZipCode(zipCode);
		}

		if (category == null) {
			userDetailsImpl.setCategory(StringPool.BLANK);
		}
		else {
			userDetailsImpl.setCategory(category);
		}

		if (client == null) {
			userDetailsImpl.setClient(StringPool.BLANK);
		}
		else {
			userDetailsImpl.setClient(client);
		}

		if (commute == null) {
			userDetailsImpl.setCommute(StringPool.BLANK);
		}
		else {
			userDetailsImpl.setCommute(commute);
		}

		if (skill == null) {
			userDetailsImpl.setSkill(StringPool.BLANK);
		}
		else {
			userDetailsImpl.setSkill(skill);
		}

		if (state == null) {
			userDetailsImpl.setState(StringPool.BLANK);
		}
		else {
			userDetailsImpl.setState(state);
		}

		userDetailsImpl.resetOriginalValues();

		return userDetailsImpl;
	}

	public long userId;
	public String hourlyRate;
	public String zipCode;
	public String category;
	public String client;
	public String commute;
	public String skill;
	public String state;
}