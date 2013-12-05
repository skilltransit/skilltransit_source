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
 * This class is a wrapper for {@link SkillSubCategory}.
 * </p>
 *
 * @author    Hari
 * @see       SkillSubCategory
 * @generated
 */
public class SkillSubCategoryWrapper implements SkillSubCategory,
	ModelWrapper<SkillSubCategory> {
	public SkillSubCategoryWrapper(SkillSubCategory skillSubCategory) {
		_skillSubCategory = skillSubCategory;
	}

	public Class<?> getModelClass() {
		return SkillSubCategory.class;
	}

	public String getModelClassName() {
		return SkillSubCategory.class.getName();
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
	* Returns the primary key of this skill sub category.
	*
	* @return the primary key of this skill sub category
	*/
	public long getPrimaryKey() {
		return _skillSubCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this skill sub category.
	*
	* @param primaryKey the primary key of this skill sub category
	*/
	public void setPrimaryKey(long primaryKey) {
		_skillSubCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the primary ID of this skill sub category.
	*
	* @return the primary ID of this skill sub category
	*/
	public long getPrimaryId() {
		return _skillSubCategory.getPrimaryId();
	}

	/**
	* Sets the primary ID of this skill sub category.
	*
	* @param primaryId the primary ID of this skill sub category
	*/
	public void setPrimaryId(long primaryId) {
		_skillSubCategory.setPrimaryId(primaryId);
	}

	/**
	* Returns the name of this skill sub category.
	*
	* @return the name of this skill sub category
	*/
	public java.lang.String getName() {
		return _skillSubCategory.getName();
	}

	/**
	* Sets the name of this skill sub category.
	*
	* @param name the name of this skill sub category
	*/
	public void setName(java.lang.String name) {
		_skillSubCategory.setName(name);
	}

	public boolean isNew() {
		return _skillSubCategory.isNew();
	}

	public void setNew(boolean n) {
		_skillSubCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _skillSubCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_skillSubCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _skillSubCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _skillSubCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_skillSubCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _skillSubCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_skillSubCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SkillSubCategoryWrapper((SkillSubCategory)_skillSubCategory.clone());
	}

	public int compareTo(
		com.tekniti.skilltransit.service.model.SkillSubCategory skillSubCategory) {
		return _skillSubCategory.compareTo(skillSubCategory);
	}

	@Override
	public int hashCode() {
		return _skillSubCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.tekniti.skilltransit.service.model.SkillSubCategory> toCacheModel() {
		return _skillSubCategory.toCacheModel();
	}

	public com.tekniti.skilltransit.service.model.SkillSubCategory toEscapedModel() {
		return new SkillSubCategoryWrapper(_skillSubCategory.toEscapedModel());
	}

	public com.tekniti.skilltransit.service.model.SkillSubCategory toUnescapedModel() {
		return new SkillSubCategoryWrapper(_skillSubCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _skillSubCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _skillSubCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_skillSubCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SkillSubCategoryWrapper)) {
			return false;
		}

		SkillSubCategoryWrapper skillSubCategoryWrapper = (SkillSubCategoryWrapper)obj;

		if (Validator.equals(_skillSubCategory,
					skillSubCategoryWrapper._skillSubCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SkillSubCategory getWrappedSkillSubCategory() {
		return _skillSubCategory;
	}

	public SkillSubCategory getWrappedModel() {
		return _skillSubCategory;
	}

	public void resetOriginalValues() {
		_skillSubCategory.resetOriginalValues();
	}

	private SkillSubCategory _skillSubCategory;
}