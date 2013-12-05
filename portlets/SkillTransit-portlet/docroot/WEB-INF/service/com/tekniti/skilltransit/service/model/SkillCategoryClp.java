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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.tekniti.skilltransit.service.service.ClpSerializer;
import com.tekniti.skilltransit.service.service.SkillCategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hari
 */
public class SkillCategoryClp extends BaseModelImpl<SkillCategory>
	implements SkillCategory {
	public SkillCategoryClp() {
	}

	public Class<?> getModelClass() {
		return SkillCategory.class;
	}

	public String getModelClassName() {
		return SkillCategory.class.getName();
	}

	public long getPrimaryKey() {
		return _primaryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPrimaryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_primaryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("primaryId", getPrimaryId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
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

	public long getPrimaryId() {
		return _primaryId;
	}

	public void setPrimaryId(long primaryId) {
		_primaryId = primaryId;

		if (_skillCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _skillCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPrimaryId", long.class);

				method.invoke(_skillCategoryRemoteModel, primaryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;

		if (_skillCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _skillCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_skillCategoryRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSkillCategoryRemoteModel() {
		return _skillCategoryRemoteModel;
	}

	public void setSkillCategoryRemoteModel(
		BaseModel<?> skillCategoryRemoteModel) {
		_skillCategoryRemoteModel = skillCategoryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _skillCategoryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_skillCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SkillCategoryLocalServiceUtil.addSkillCategory(this);
		}
		else {
			SkillCategoryLocalServiceUtil.updateSkillCategory(this);
		}
	}

	@Override
	public SkillCategory toEscapedModel() {
		return (SkillCategory)ProxyUtil.newProxyInstance(SkillCategory.class.getClassLoader(),
			new Class[] { SkillCategory.class }, new AutoEscapeBeanHandler(this));
	}

	public SkillCategory toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		SkillCategoryClp clone = new SkillCategoryClp();

		clone.setPrimaryId(getPrimaryId());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(SkillCategory skillCategory) {
		int value = 0;

		if (getPrimaryId() < skillCategory.getPrimaryId()) {
			value = -1;
		}
		else if (getPrimaryId() > skillCategory.getPrimaryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SkillCategoryClp)) {
			return false;
		}

		SkillCategoryClp skillCategory = (SkillCategoryClp)obj;

		long primaryKey = skillCategory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{primaryId=");
		sb.append(getPrimaryId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.tekniti.skilltransit.service.model.SkillCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>primaryId</column-name><column-value><![CDATA[");
		sb.append(getPrimaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _primaryId;
	private String _name;
	private BaseModel<?> _skillCategoryRemoteModel;
}