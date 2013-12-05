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
import com.liferay.portal.util.PortalUtil;

import com.tekniti.skilltransit.service.service.ClpSerializer;
import com.tekniti.skilltransit.service.service.UserDetailsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hari
 */
public class UserDetailsClp extends BaseModelImpl<UserDetails>
	implements UserDetails {
	public UserDetailsClp() {
	}

	public Class<?> getModelClass() {
		return UserDetails.class;
	}

	public String getModelClassName() {
		return UserDetails.class.getName();
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		if (_userDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _userDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userDetailsRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getHourlyRate() {
		return _hourlyRate;
	}

	public void setHourlyRate(String hourlyRate) {
		_hourlyRate = hourlyRate;

		if (_userDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _userDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setHourlyRate", String.class);

				method.invoke(_userDetailsRemoteModel, hourlyRate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;

		if (_userDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _userDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setZipCode", String.class);

				method.invoke(_userDetailsRemoteModel, zipCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;

		if (_userDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _userDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_userDetailsRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getClient() {
		return _client;
	}

	public void setClient(String client) {
		_client = client;

		if (_userDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _userDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setClient", String.class);

				method.invoke(_userDetailsRemoteModel, client);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCommute() {
		return _commute;
	}

	public void setCommute(String commute) {
		_commute = commute;

		if (_userDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _userDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCommute", String.class);

				method.invoke(_userDetailsRemoteModel, commute);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getSkill() {
		return _skill;
	}

	public void setSkill(String skill) {
		_skill = skill;

		if (_userDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _userDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setSkill", String.class);

				method.invoke(_userDetailsRemoteModel, skill);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;

		if (_userDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _userDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_userDetailsRemoteModel, state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserDetailsRemoteModel() {
		return _userDetailsRemoteModel;
	}

	public void setUserDetailsRemoteModel(BaseModel<?> userDetailsRemoteModel) {
		_userDetailsRemoteModel = userDetailsRemoteModel;
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

		Class<?> remoteModelClass = _userDetailsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userDetailsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UserDetailsLocalServiceUtil.addUserDetails(this);
		}
		else {
			UserDetailsLocalServiceUtil.updateUserDetails(this);
		}
	}

	@Override
	public UserDetails toEscapedModel() {
		return (UserDetails)ProxyUtil.newProxyInstance(UserDetails.class.getClassLoader(),
			new Class[] { UserDetails.class }, new AutoEscapeBeanHandler(this));
	}

	public UserDetails toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		UserDetailsClp clone = new UserDetailsClp();

		clone.setUserId(getUserId());
		clone.setHourlyRate(getHourlyRate());
		clone.setZipCode(getZipCode());
		clone.setCategory(getCategory());
		clone.setClient(getClient());
		clone.setCommute(getCommute());
		clone.setSkill(getSkill());
		clone.setState(getState());

		return clone;
	}

	public int compareTo(UserDetails userDetails) {
		int value = 0;

		if (getUserId() < userDetails.getUserId()) {
			value = -1;
		}
		else if (getUserId() > userDetails.getUserId()) {
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

		if (!(obj instanceof UserDetailsClp)) {
			return false;
		}

		UserDetailsClp userDetails = (UserDetailsClp)obj;

		long primaryKey = userDetails.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", hourlyRate=");
		sb.append(getHourlyRate());
		sb.append(", zipCode=");
		sb.append(getZipCode());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", client=");
		sb.append(getClient());
		sb.append(", commute=");
		sb.append(getCommute());
		sb.append(", skill=");
		sb.append(getSkill());
		sb.append(", state=");
		sb.append(getState());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.tekniti.skilltransit.service.model.UserDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hourlyRate</column-name><column-value><![CDATA[");
		sb.append(getHourlyRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipCode</column-name><column-value><![CDATA[");
		sb.append(getZipCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>client</column-name><column-value><![CDATA[");
		sb.append(getClient());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commute</column-name><column-value><![CDATA[");
		sb.append(getCommute());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skill</column-name><column-value><![CDATA[");
		sb.append(getSkill());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private String _hourlyRate;
	private String _zipCode;
	private String _category;
	private String _client;
	private String _commute;
	private String _skill;
	private String _state;
	private BaseModel<?> _userDetailsRemoteModel;
}