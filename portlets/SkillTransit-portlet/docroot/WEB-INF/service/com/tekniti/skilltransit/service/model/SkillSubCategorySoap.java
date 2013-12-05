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
 * This class is used by SOAP remote services, specifically {@link com.tekniti.skilltransit.service.service.http.SkillSubCategoryServiceSoap}.
 *
 * @author    Hari
 * @see       com.tekniti.skilltransit.service.service.http.SkillSubCategoryServiceSoap
 * @generated
 */
public class SkillSubCategorySoap implements Serializable {
	public static SkillSubCategorySoap toSoapModel(SkillSubCategory model) {
		SkillSubCategorySoap soapModel = new SkillSubCategorySoap();

		soapModel.setPrimaryId(model.getPrimaryId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static SkillSubCategorySoap[] toSoapModels(SkillSubCategory[] models) {
		SkillSubCategorySoap[] soapModels = new SkillSubCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SkillSubCategorySoap[][] toSoapModels(
		SkillSubCategory[][] models) {
		SkillSubCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SkillSubCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SkillSubCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SkillSubCategorySoap[] toSoapModels(
		List<SkillSubCategory> models) {
		List<SkillSubCategorySoap> soapModels = new ArrayList<SkillSubCategorySoap>(models.size());

		for (SkillSubCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SkillSubCategorySoap[soapModels.size()]);
	}

	public SkillSubCategorySoap() {
	}

	public long getPrimaryKey() {
		return _primaryId;
	}

	public void setPrimaryKey(long pk) {
		setPrimaryId(pk);
	}

	public long getPrimaryId() {
		return _primaryId;
	}

	public void setPrimaryId(long primaryId) {
		_primaryId = primaryId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _primaryId;
	private String _name;
}