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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.tekniti.skilltransit.service.model.UserSkills;
import com.tekniti.skilltransit.service.model.UserSkillsModel;
import com.tekniti.skilltransit.service.model.UserSkillsSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the UserSkills service. Represents a row in the &quot;user_skills&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.tekniti.skilltransit.service.model.UserSkillsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserSkillsImpl}.
 * </p>
 *
 * @author Hari
 * @see UserSkillsImpl
 * @see com.tekniti.skilltransit.service.model.UserSkills
 * @see com.tekniti.skilltransit.service.model.UserSkillsModel
 * @generated
 */
@JSON(strict = true)
public class UserSkillsModelImpl extends BaseModelImpl<UserSkills>
	implements UserSkillsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user skills model instance should use the {@link com.tekniti.skilltransit.service.model.UserSkills} interface instead.
	 */
	public static final String TABLE_NAME = "user_skills";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "user_id", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table user_skills (id LONG not null primary key,name VARCHAR(75) null,user_id LONG)";
	public static final String TABLE_SQL_DROP = "drop table user_skills";
	public static final String ORDER_BY_JPQL = " ORDER BY userSkills.primId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY user_skills.id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.tekniti.skilltransit.service.model.UserSkills"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.tekniti.skilltransit.service.model.UserSkills"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.tekniti.skilltransit.service.model.UserSkills"),
			true);
	public static long USER_ID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserSkills toModel(UserSkillsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserSkills model = new UserSkillsImpl();

		model.setPrimId(soapModel.getPrimId());
		model.setName(soapModel.getName());
		model.setUser_id(soapModel.getUser_id());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserSkills> toModels(UserSkillsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserSkills> models = new ArrayList<UserSkills>(soapModels.length);

		for (UserSkillsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.tekniti.skilltransit.service.model.UserSkills"));

	public UserSkillsModelImpl() {
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

	public Class<?> getModelClass() {
		return UserSkills.class;
	}

	public String getModelClassName() {
		return UserSkills.class.getName();
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

	@JSON
	public long getPrimId() {
		return _primId;
	}

	public void setPrimId(long primId) {
		_columnBitmask = -1L;

		_primId = primId;
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	@JSON
	public long getUser_id() {
		return _user_id;
	}

	public void setUser_id(long user_id) {
		_columnBitmask |= USER_ID_COLUMN_BITMASK;

		if (!_setOriginalUser_id) {
			_setOriginalUser_id = true;

			_originalUser_id = _user_id;
		}

		_user_id = user_id;
	}

	public long getOriginalUser_id() {
		return _originalUser_id;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			UserSkills.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserSkills toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserSkills)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	public UserSkills toUnescapedModel() {
		return (UserSkills)this;
	}

	@Override
	public Object clone() {
		UserSkillsImpl userSkillsImpl = new UserSkillsImpl();

		userSkillsImpl.setPrimId(getPrimId());
		userSkillsImpl.setName(getName());
		userSkillsImpl.setUser_id(getUser_id());

		userSkillsImpl.resetOriginalValues();

		return userSkillsImpl;
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

		if (!(obj instanceof UserSkills)) {
			return false;
		}

		UserSkills userSkills = (UserSkills)obj;

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
	public void resetOriginalValues() {
		UserSkillsModelImpl userSkillsModelImpl = this;

		userSkillsModelImpl._originalUser_id = userSkillsModelImpl._user_id;

		userSkillsModelImpl._setOriginalUser_id = false;

		userSkillsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserSkills> toCacheModel() {
		UserSkillsCacheModel userSkillsCacheModel = new UserSkillsCacheModel();

		userSkillsCacheModel.primId = getPrimId();

		userSkillsCacheModel.name = getName();

		String name = userSkillsCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			userSkillsCacheModel.name = null;
		}

		userSkillsCacheModel.user_id = getUser_id();

		return userSkillsCacheModel;
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

	private static ClassLoader _classLoader = UserSkills.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			UserSkills.class
		};
	private long _primId;
	private String _name;
	private long _user_id;
	private long _originalUser_id;
	private boolean _setOriginalUser_id;
	private long _columnBitmask;
	private UserSkills _escapedModel;
}