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
 * This class is used by SOAP remote services, specifically {@link com.tekniti.skilltransit.service.service.http.UserDetailsServiceSoap}.
 *
 * @author    Hari
 * @see       com.tekniti.skilltransit.service.service.http.UserDetailsServiceSoap
 * @generated
 */
public class UserDetailsSoap implements Serializable {
	public static UserDetailsSoap toSoapModel(UserDetails model) {
		UserDetailsSoap soapModel = new UserDetailsSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setHourlyRate(model.getHourlyRate());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setCategory(model.getCategory());
		soapModel.setClient(model.getClient());
		soapModel.setCommute(model.getCommute());
		soapModel.setSkill(model.getSkill());
		soapModel.setState(model.getState());

		return soapModel;
	}

	public static UserDetailsSoap[] toSoapModels(UserDetails[] models) {
		UserDetailsSoap[] soapModels = new UserDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserDetailsSoap[][] toSoapModels(UserDetails[][] models) {
		UserDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserDetailsSoap[] toSoapModels(List<UserDetails> models) {
		List<UserDetailsSoap> soapModels = new ArrayList<UserDetailsSoap>(models.size());

		for (UserDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserDetailsSoap[soapModels.size()]);
	}

	public UserDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getHourlyRate() {
		return _hourlyRate;
	}

	public void setHourlyRate(String hourlyRate) {
		_hourlyRate = hourlyRate;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getClient() {
		return _client;
	}

	public void setClient(String client) {
		_client = client;
	}

	public String getCommute() {
		return _commute;
	}

	public void setCommute(String commute) {
		_commute = commute;
	}

	public String getSkill() {
		return _skill;
	}

	public void setSkill(String skill) {
		_skill = skill;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	private long _userId;
	private String _hourlyRate;
	private String _zipCode;
	private String _category;
	private String _client;
	private String _commute;
	private String _skill;
	private String _state;
}