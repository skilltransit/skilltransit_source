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

package com.tekniti.skilltransit.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.tekniti.skilltransit.service.model.UserSkills;
import com.tekniti.skilltransit.service.service.UserSkillsLocalServiceUtil;
import com.tekniti.skilltransit.service.service.base.UserSkillsLocalServiceBaseImpl;

/**
 * The implementation of the user skills local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.tekniti.skilltransit.service.service.UserSkillsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Hari
 * @see com.tekniti.skilltransit.service.service.base.UserSkillsLocalServiceBaseImpl
 * @see com.tekniti.skilltransit.service.service.UserSkillsLocalServiceUtil
 */
public class UserSkillsLocalServiceImpl extends UserSkillsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.tekniti.skilltransit.service.service.UserSkillsLocalServiceUtil} to access the user skills local service.
	 */
	public UserSkills createUserSkills() throws SystemException{
			return userSkillsPersistence.create(counterLocalService.increment());
	}
	
	public List<String> getUserSkillsByUserId(long userId) throws SystemException{
		List<String> userSkills = new ArrayList<String>();
		try {
			DynamicQuery query=DynamicQueryFactoryUtil.forClass(UserSkills.class, UserSkills.class.getClassLoader() );
			Criterion criterionName= RestrictionsFactoryUtil.eq("user_id", userId);
			query.add(criterionName);
			
			System.out.println("user skills query is "+query.toString());
			List<UserSkills> userSkillsList=UserSkillsLocalServiceUtil.dynamicQuery(query);
			for(int i=0;i<userSkillsList.size();i++){
				userSkills.add(userSkillsList.get(i).getName());
			}
			
		} catch (Exception e) {
			System.out.println("error in getUserSkillsByUserId, " + " e="+e);
		}
		return userSkills;
	}
}