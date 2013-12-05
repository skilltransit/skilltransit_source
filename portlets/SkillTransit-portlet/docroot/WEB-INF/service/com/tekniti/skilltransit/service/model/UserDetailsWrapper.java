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

package com.tekniti.skilltransit.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserDetails}.
 * </p>
 *
 * @author    Hari
 * @see       UserDetails
 * @generated
 */
public class UserDetailsWrapper implements UserDetails,
	ModelWrapper<UserDetails> {
	public UserDetailsWrapper(UserDetails userDetails) {
		_userDetails = userDetails;
	}

	public Class<?> getModelClass() {
		return UserDetails.class;
	}

	public String getModelClassName() {
		return UserDetails.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("hourlyRate", getHourlyRate());
		attributes.put("zipCode", getZipCode());
		attributes.put("category", getCategory());
		attributes.put("client", getClient());
		attributes.put("commute", getCommute());
		attributes.put("skill", getSkill());
		attributes.put("state", getState());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String hourlyRate = (String)attributes.get("hourlyRate");

		if (hourlyRate != null) {
			setHourlyRate(hourlyRate);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String client = (String)attributes.get("client");

		if (client != null) {
			setClient(client);
		}

		String commute = (String)attributes.get("commute");

		if (commute != null) {
			setCommute(commute);
		}

		String skill = (String)attributes.get("skill");

		if (skill != null) {
			setSkill(skill);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}
	}

	/**
	* Returns the primary key of this user details.
	*
	* @return the primary key of this user details
	*/
	public long getPrimaryKey() {
		return _userDetails.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user details.
	*
	* @param primaryKey the primary key of this user details
	*/
	public void setPrimaryKey(long primaryKey) {
		_userDetails.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this user details.
	*
	* @return the user ID of this user details
	*/
	public long getUserId() {
		return _userDetails.getUserId();
	}

	/**
	* Sets the user ID of this user details.
	*
	* @param userId the user ID of this user details
	*/
	public void setUserId(long userId) {
		_userDetails.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user details.
	*
	* @return the user uuid of this user details
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDetails.getUserUuid();
	}

	/**
	* Sets the user uuid of this user details.
	*
	* @param userUuid the user uuid of this user details
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_userDetails.setUserUuid(userUuid);
	}

	/**
	* Returns the hourly rate of this user details.
	*
	* @return the hourly rate of this user details
	*/
	public java.lang.String getHourlyRate() {
		return _userDetails.getHourlyRate();
	}

	/**
	* Sets the hourly rate of this user details.
	*
	* @param hourlyRate the hourly rate of this user details
	*/
	public void setHourlyRate(java.lang.String hourlyRate) {
		_userDetails.setHourlyRate(hourlyRate);
	}

	/**
	* Returns the zip code of this user details.
	*
	* @return the zip code of this user details
	*/
	public java.lang.String getZipCode() {
		return _userDetails.getZipCode();
	}

	/**
	* Sets the zip code of this user details.
	*
	* @param zipCode the zip code of this user details
	*/
	public void setZipCode(java.lang.String zipCode) {
		_userDetails.setZipCode(zipCode);
	}

	/**
	* Returns the category of this user details.
	*
	* @return the category of this user details
	*/
	public java.lang.String getCategory() {
		return _userDetails.getCategory();
	}

	/**
	* Sets the category of this user details.
	*
	* @param category the category of this user details
	*/
	public void setCategory(java.lang.String category) {
		_userDetails.setCategory(category);
	}

	/**
	* Returns the client of this user details.
	*
	* @return the client of this user details
	*/
	public java.lang.String getClient() {
		return _userDetails.getClient();
	}

	/**
	* Sets the client of this user details.
	*
	* @param client the client of this user details
	*/
	public void setClient(java.lang.String client) {
		_userDetails.setClient(client);
	}

	/**
	* Returns the commute of this user details.
	*
	* @return the commute of this user details
	*/
	public java.lang.String getCommute() {
		return _userDetails.getCommute();
	}

	/**
	* Sets the commute of this user details.
	*
	* @param commute the commute of this user details
	*/
	public void setCommute(java.lang.String commute) {
		_userDetails.setCommute(commute);
	}

	/**
	* Returns the skill of this user details.
	*
	* @return the skill of this user details
	*/
	public java.lang.String getSkill() {
		return _userDetails.getSkill();
	}

	/**
	* Sets the skill of this user details.
	*
	* @param skill the skill of this user details
	*/
	public void setSkill(java.lang.String skill) {
		_userDetails.setSkill(skill);
	}

	/**
	* Returns the state of this user details.
	*
	* @return the state of this user details
	*/
	public java.lang.String getState() {
		return _userDetails.getState();
	}

	/**
	* Sets the state of this user details.
	*
	* @param state the state of this user details
	*/
	public void setState(java.lang.String state) {
		_userDetails.setState(state);
	}

	public boolean isNew() {
		return _userDetails.isNew();
	}

	public void setNew(boolean n) {
		_userDetails.setNew(n);
	}

	public boolean isCachedModel() {
		return _userDetails.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userDetails.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userDetails.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userDetails.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userDetails.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserDetailsWrapper((UserDetails)_userDetails.clone());
	}

	public int compareTo(
		com.tekniti.skilltransit.service.model.UserDetails userDetails) {
		return _userDetails.compareTo(userDetails);
	}

	@Override
	public int hashCode() {
		return _userDetails.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.tekniti.skilltransit.service.model.UserDetails> toCacheModel() {
		return _userDetails.toCacheModel();
	}

	public com.tekniti.skilltransit.service.model.UserDetails toEscapedModel() {
		return new UserDetailsWrapper(_userDetails.toEscapedModel());
	}

	public com.tekniti.skilltransit.service.model.UserDetails toUnescapedModel() {
		return new UserDetailsWrapper(_userDetails.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userDetails.toString();
	}

	public java.lang.String toXmlString() {
		return _userDetails.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userDetails.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserDetailsWrapper)) {
			return false;
		}

		UserDetailsWrapper userDetailsWrapper = (UserDetailsWrapper)obj;

		if (Validator.equals(_userDetails, userDetailsWrapper._userDetails)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UserDetails getWrappedUserDetails() {
		return _userDetails;
	}

	public UserDetails getWrappedModel() {
		return _userDetails;
	}

	public void resetOriginalValues() {
		_userDetails.resetOriginalValues();
	}

	private UserDetails _userDetails;
}