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
import com.tekniti.skilltransit.service.service.UserSkillsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hari
 */
public class UserSkillsClp extends BaseModelImpl<UserSkills>
	implements UserSkills {
	public UserSkillsClp() {
	}

	public Class<?> getModelClass() {
		return UserSkills.class;
	}

	public String getModelClassName() {
		return UserSkills.class.getName();
	}

	public long getPrimaryKey() {
		return _primId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPrimId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_primId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("primId", getPrimId());
		attributes.put("name", getName());
		attributes.put("user_id", getUser_id());

		return attributes;
	}

	@Override
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

	public long getPrimId() {
		return _primId;
	}

	public void setPrimId(long primId) {
		_primId = primId;

		if (_userSkillsRemoteModel != null) {
			try {
				Class<?> clazz = _userSkillsRemoteModel.getClass();

				Method method = clazz.getMethod("setPrimId", long.class);

				method.invoke(_userSkillsRemoteModel, primId);
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

		if (_userSkillsRemoteModel != null) {
			try {
				Class<?> clazz = _userSkillsRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_userSkillsRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUser_id() {
		return _user_id;
	}

	public void setUser_id(long user_id) {
		_user_id = user_id;

		if (_userSkillsRemoteModel != null) {
			try {
				Class<?> clazz = _userSkillsRemoteModel.getClass();

				Method method = clazz.getMethod("setUser_id", long.class);

				method.invoke(_userSkillsRemoteModel, user_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserSkillsRemoteModel() {
		return _userSkillsRemoteModel;
	}

	public void setUserSkillsRemoteModel(BaseModel<?> userSkillsRemoteModel) {
		_userSkillsRemoteModel = userSkillsRemoteModel;
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

		Class<?> remoteModelClass = _userSkillsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userSkillsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UserSkillsLocalServiceUtil.addUserSkills(this);
		}
		else {
			UserSkillsLocalServiceUtil.updateUserSkills(this);
		}
	}

	@Override
	public UserSkills toEscapedModel() {
		return (UserSkills)ProxyUtil.newProxyInstance(UserSkills.class.getClassLoader(),
			new Class[] { UserSkills.class }, new AutoEscapeBeanHandler(this));
	}

	public UserSkills toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		UserSkillsClp clone = new UserSkillsClp();

		clone.setPrimId(getPrimId());
		clone.setName(getName());
		clone.setUser_id(getUser_id());

		return clone;
	}

	public int compareTo(UserSkills userSkills) {
		int value = 0;

		if (getPrimId() < userSkills.getPrimId()) {
			value = -1;
		}
		else if (getPrimId() > userSkills.getPrimId()) {
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

		if (!(obj instanceof UserSkillsClp)) {
			return false;
		}

		UserSkillsClp userSkills = (UserSkillsClp)obj;

		long primaryKey = userSkills.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{primId=");
		sb.append(getPrimId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", user_id=");
		sb.append(getUser_id());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.tekniti.skilltransit.service.model.UserSkills");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>primId</column-name><column-value><![CDATA[");
		sb.append(getPrimId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>user_id</column-name><column-value><![CDATA[");
		sb.append(getUser_id());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _primId;
	private String _name;
	private long _user_id;
	private BaseModel<?> _userSkillsRemoteModel;
}