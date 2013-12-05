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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.tekniti.skilltransit.service.service.http.UserSkillsServiceSoap}.
 *
 * @author    Hari
 * @see       com.tekniti.skilltransit.service.service.http.UserSkillsServiceSoap
 * @generated
 */
public class UserSkillsSoap implements Serializable {
	public static UserSkillsSoap toSoapModel(UserSkills model) {
		UserSkillsSoap soapModel = new UserSkillsSoap();

		soapModel.setPrimId(model.getPrimId());
		soapModel.setName(model.getName());
		soapModel.setUser_id(model.getUser_id());

		return soapModel;
	}

	public static UserSkillsSoap[] toSoapModels(UserSkills[] models) {
		UserSkillsSoap[] soapModels = new UserSkillsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserSkillsSoap[][] toSoapModels(UserSkills[][] models) {
		UserSkillsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserSkillsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserSkillsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserSkillsSoap[] toSoapModels(List<UserSkills> models) {
		List<UserSkillsSoap> soapModels = new ArrayList<UserSkillsSoap>(models.size());

		for (UserSkills model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserSkillsSoap[soapModels.size()]);
	}

	public UserSkillsSoap() {
	}

	public long getPrimaryKey() {
		return _primId;
	}

	public void setPrimaryKey(long pk) {
		setPrimId(pk);
	}

	public long getPrimId() {
		return _primId;
	}

	public void setPrimId(long primId) {
		_primId = primId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getUser_id() {
		return _user_id;
	}

	public void setUser_id(long user_id) {
		_user_id = user_id;
	}

	private long _primId;
	private String _name;
	private long _user_id;
}