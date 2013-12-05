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

import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.tekniti.skilltransit.service.model.SkillSubCategory;
import com.tekniti.skilltransit.service.service.SkillSubCategoryLocalServiceUtil;
import com.tekniti.skilltransit.service.service.base.SkillSubCategoryLocalServiceBaseImpl;

/**
 * The implementation of the skill sub category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.tekniti.skilltransit.service.service.SkillSubCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Hari
 * @see com.tekniti.skilltransit.service.service.base.SkillSubCategoryLocalServiceBaseImpl
 * @see com.tekniti.skilltransit.service.service.SkillSubCategoryLocalServiceUtil
 */
public class SkillSubCategoryLocalServiceImpl
	extends SkillSubCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.tekniti.skilltransit.service.service.SkillSubCategoryLocalServiceUtil} to access the skill sub category local service.
	 */
	
	@SuppressWarnings("unchecked")
	public List<SkillSubCategory> typeaheadSearch(String search)  {
		List<SkillSubCategory> subcategoryList = null;
		try {
			DynamicQuery query=DynamicQueryFactoryUtil.forClass(SkillSubCategory.class, SkillSubCategory.class.getClassLoader() );
			Criterion criterionName= RestrictionsFactoryUtil.ilike("name", search+StringPool.PERCENT);
			query.add(criterionName);
			
			// Order
			/*Order ord = PropertyFactoryUtil.forName("search").asc();
			query.addOrder(ord);*/
			System.out.println("Cat query is "+query.toString());
			subcategoryList=SkillSubCategoryLocalServiceUtil.dynamicQuery(query);
			
		} catch (Exception e) {
			System.out.println("error in typeaheadSearch, " + search + " e="+e);
		}
		return subcategoryList;
	}
}