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
 * This class is a wrapper for {@link UserSkills}.
 * </p>
 *
 * @author    Hari
 * @see       UserSkills
 * @generated
 */
public class UserSkillsWrapper implements UserSkills, ModelWrapper<UserSkills> {
	public UserSkillsWrapper(UserSkills userSkills) {
		_userSkills = userSkills;
	}

	public Class<?> getModelClass() {
		return UserSkills.class;
	}

	public String getModelClassName() {
		return UserSkills.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("primId", getPrimId());
		attributes.put("name", getName());
		attributes.put("user_id", getUser_id());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long primId = (Long)attributes.get("primId");

		if (primId != null) {
			setPrimId(primId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long user_id = (Long)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}
	}

	/**
	* Returns the primary key of this user skills.
	*
	* @return the primary key of this user skills
	*/
	public long getPrimaryKey() {
		return _userSkills.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user skills.
	*
	* @param primaryKey the primary key of this user skills
	*/
	public void setPrimaryKey(long primaryKey) {
		_userSkills.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the prim ID of this user skills.
	*
	* @return the prim ID of this user skills
	*/
	public long getPrimId() {
		return _userSkills.getPrimId();
	}

	/**
	* Sets the prim ID of this user skills.
	*
	* @param primId the prim ID of this user skills
	*/
	public void setPrimId(long primId) {
		_userSkills.setPrimId(primId);
	}

	/**
	* Returns the name of this user skills.
	*
	* @return the name of this user skills
	*/
	public java.lang.String getName() {
		return _userSkills.getName();
	}

	/**
	* Sets the name of this user skills.
	*
	* @param name the name of this user skills
	*/
	public void setName(java.lang.String name) {
		_userSkills.setName(name);
	}

	/**
	* Returns the user_id of this user skills.
	*
	* @return the user_id of this user skills
	*/
	public long getUser_id() {
		return _userSkills.getUser_id();
	}

	/**
	* Sets the user_id of this user skills.
	*
	* @param user_id the user_id of this user skills
	*/
	public void setUser_id(long user_id) {
		_userSkills.setUser_id(user_id);
	}

	public boolean isNew() {
		return _userSkills.isNew();
	}

	public void setNew(boolean n) {
		_userSkills.setNew(n);
	}

	public boolean isCachedModel() {
		return _userSkills.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userSkills.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userSkills.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userSkills.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userSkills.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userSkills.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userSkills.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserSkillsWrapper((UserSkills)_userSkills.clone());
	}

	public int compareTo(
		com.tekniti.skilltransit.service.model.UserSkills userSkills) {
		return _userSkills.compareTo(userSkills);
	}

	@Override
	public int hashCode() {
		return _userSkills.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.tekniti.skilltransit.service.model.UserSkills> toCacheModel() {
		return _userSkills.toCacheModel();
	}

	public com.tekniti.skilltransit.service.model.UserSkills toEscapedModel() {
		return new UserSkillsWrapper(_userSkills.toEscapedModel());
	}

	public com.tekniti.skilltransit.service.model.UserSkills toUnescapedModel() {
		return new UserSkillsWrapper(_userSkills.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userSkills.toString();
	}

	public java.lang.String toXmlString() {
		return _userSkills.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userSkills.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserSkillsWrapper)) {
			return false;
		}

		UserSkillsWrapper userSkillsWrapper = (UserSkillsWrapper)obj;

		if (Validator.equals(_userSkills, userSkillsWrapper._userSkills)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UserSkills getWrappedUserSkills() {
		return _userSkills;
	}

	public UserSkills getWrappedModel() {
		return _userSkills;
	}

	public void resetOriginalValues() {
		_userSkills.resetOriginalValues();
	}

	private UserSkills _userSkills;
}