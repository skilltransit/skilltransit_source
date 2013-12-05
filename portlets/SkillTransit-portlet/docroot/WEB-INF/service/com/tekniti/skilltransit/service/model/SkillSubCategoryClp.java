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
import com.tekniti.skilltransit.service.service.SkillSubCategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hari
 */
public class SkillSubCategoryClp extends BaseModelImpl<SkillSubCategory>
	implements SkillSubCategory {
	public SkillSubCategoryClp() {
	}

	public Class<?> getModelClass() {
		return SkillSubCategory.class;
	}

	public String getModelClassName() {
		return SkillSubCategory.class.getName();
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

		if (_skillSubCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _skillSubCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPrimaryId", long.class);

				method.invoke(_skillSubCategoryRemoteModel, primaryId);
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

		if (_skillSubCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _skillSubCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_skillSubCategoryRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSkillSubCategoryRemoteModel() {
		return _skillSubCategoryRemoteModel;
	}

	public void setSkillSubCategoryRemoteModel(
		BaseModel<?> skillSubCategoryRemoteModel) {
		_skillSubCategoryRemoteModel = skillSubCategoryRemoteModel;
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

		Class<?> remoteModelClass = _skillSubCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_skillSubCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SkillSubCategoryLocalServiceUtil.addSkillSubCategory(this);
		}
		else {
			SkillSubCategoryLocalServiceUtil.updateSkillSubCategory(this);
		}
	}

	@Override
	public SkillSubCategory toEscapedModel() {
		return (SkillSubCategory)ProxyUtil.newProxyInstance(SkillSubCategory.class.getClassLoader(),
			new Class[] { SkillSubCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	public SkillSubCategory toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		SkillSubCategoryClp clone = new SkillSubCategoryClp();

		clone.setPrimaryId(getPrimaryId());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(SkillSubCategory skillSubCategory) {
		int value = 0;

		if (getPrimaryId() < skillSubCategory.getPrimaryId()) {
			value = -1;
		}
		else if (getPrimaryId() > skillSubCategory.getPrimaryId()) {
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

		if (!(obj instanceof SkillSubCategoryClp)) {
			return false;
		}

		SkillSubCategoryClp skillSubCategory = (SkillSubCategoryClp)obj;

		long primaryKey = skillSubCategory.getPrimaryKey();

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
		sb.append("com.tekniti.skilltransit.service.model.SkillSubCategory");
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
	private BaseModel<?> _skillSubCategoryRemoteModel;
}