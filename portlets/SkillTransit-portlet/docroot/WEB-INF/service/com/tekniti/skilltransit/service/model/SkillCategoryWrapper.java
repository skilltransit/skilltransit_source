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
 * This class is a wrapper for {@link SkillCategory}.
 * </p>
 *
 * @author    Hari
 * @see       SkillCategory
 * @generated
 */
public class SkillCategoryWrapper implements SkillCategory,
	ModelWrapper<SkillCategory> {
	public SkillCategoryWrapper(SkillCategory skillCategory) {
		_skillCategory = skillCategory;
	}

	public Class<?> getModelClass() {
		return SkillCategory.class;
	}

	public String getModelClassName() {
		return SkillCategory.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("primaryId", getPrimaryId());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long primaryId = (Long)attributes.get("primaryId");

		if (primaryId != null) {
			setPrimaryId(primaryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this skill category.
	*
	* @return the primary key of this skill category
	*/
	public long getPrimaryKey() {
		return _skillCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this skill category.
	*
	* @param primaryKey the primary key of this skill category
	*/
	public void setPrimaryKey(long primaryKey) {
		_skillCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the primary ID of this skill category.
	*
	* @return the primary ID of this skill category
	*/
	public long getPrimaryId() {
		return _skillCategory.getPrimaryId();
	}

	/**
	* Sets the primary ID of this skill category.
	*
	* @param primaryId the primary ID of this skill category
	*/
	public void setPrimaryId(long primaryId) {
		_skillCategory.setPrimaryId(primaryId);
	}

	/**
	* Returns the name of this skill category.
	*
	* @return the name of this skill category
	*/
	public java.lang.String getName() {
		return _skillCategory.getName();
	}

	/**
	* Sets the name of this skill category.
	*
	* @param name the name of this skill category
	*/
	public void setName(java.lang.String name) {
		_skillCategory.setName(name);
	}

	public boolean isNew() {
		return _skillCategory.isNew();
	}

	public void setNew(boolean n) {
		_skillCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _skillCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_skillCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _skillCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _skillCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_skillCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _skillCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_skillCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SkillCategoryWrapper((SkillCategory)_skillCategory.clone());
	}

	public int compareTo(
		com.tekniti.skilltransit.service.model.SkillCategory skillCategory) {
		return _skillCategory.compareTo(skillCategory);
	}

	@Override
	public int hashCode() {
		return _skillCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.tekniti.skilltransit.service.model.SkillCategory> toCacheModel() {
		return _skillCategory.toCacheModel();
	}

	public com.tekniti.skilltransit.service.model.SkillCategory toEscapedModel() {
		return new SkillCategoryWrapper(_skillCategory.toEscapedModel());
	}

	public com.tekniti.skilltransit.service.model.SkillCategory toUnescapedModel() {
		return new SkillCategoryWrapper(_skillCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _skillCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _skillCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_skillCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SkillCategoryWrapper)) {
			return false;
		}

		SkillCategoryWrapper skillCategoryWrapper = (SkillCategoryWrapper)obj;

		if (Validator.equals(_skillCategory, skillCategoryWrapper._skillCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SkillCategory getWrappedSkillCategory() {
		return _skillCategory;
	}

	public SkillCategory getWrappedModel() {
		return _skillCategory;
	}

	public void resetOriginalValues() {
		_skillCategory.resetOriginalValues();
	}

	private SkillCategory _skillCategory;
}