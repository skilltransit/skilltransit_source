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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SkillCategory service. Represents a row in the &quot;skill_category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.tekniti.skilltransit.service.model.impl.SkillCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.tekniti.skilltransit.service.model.impl.SkillCategoryImpl}.
 * </p>
 *
 * @author Hari
 * @see SkillCategory
 * @see com.tekniti.skilltransit.service.model.impl.SkillCategoryImpl
 * @see com.tekniti.skilltransit.service.model.impl.SkillCategoryModelImpl
 * @generated
 */
public interface SkillCategoryModel extends BaseModel<SkillCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a skill category model instance should use the {@link SkillCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this skill category.
	 *
	 * @return the primary key of this skill category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this skill category.
	 *
	 * @param primaryKey the primary key of this skill category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the primary ID of this skill category.
	 *
	 * @return the primary ID of this skill category
	 */
	public long getPrimaryId();

	/**
	 * Sets the primary ID of this skill category.
	 *
	 * @param primaryId the primary ID of this skill category
	 */
	public void setPrimaryId(long primaryId);

	/**
	 * Returns the name of this skill category.
	 *
	 * @return the name of this skill category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this skill category.
	 *
	 * @param name the name of this skill category
	 */
	public void setName(String name);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(SkillCategory skillCategory);

	public int hashCode();

	public CacheModel<SkillCategory> toCacheModel();

	public SkillCategory toEscapedModel();

	public SkillCategory toUnescapedModel();

	public String toString();

	public String toXmlString();
}