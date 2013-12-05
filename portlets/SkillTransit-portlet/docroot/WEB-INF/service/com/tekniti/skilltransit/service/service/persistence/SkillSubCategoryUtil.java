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

package com.tekniti.skilltransit.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.tekniti.skilltransit.service.model.SkillSubCategory;

import java.util.List;

/**
 * The persistence utility for the skill sub category service. This utility wraps {@link SkillSubCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hari
 * @see SkillSubCategoryPersistence
 * @see SkillSubCategoryPersistenceImpl
 * @generated
 */
public class SkillSubCategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SkillSubCategory skillSubCategory) {
		getPersistence().clearCache(skillSubCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SkillSubCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SkillSubCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SkillSubCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SkillSubCategory update(SkillSubCategory skillSubCategory,
		boolean merge) throws SystemException {
		return getPersistence().update(skillSubCategory, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SkillSubCategory update(SkillSubCategory skillSubCategory,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(skillSubCategory, merge, serviceContext);
	}

	/**
	* Caches the skill sub category in the entity cache if it is enabled.
	*
	* @param skillSubCategory the skill sub category
	*/
	public static void cacheResult(
		com.tekniti.skilltransit.service.model.SkillSubCategory skillSubCategory) {
		getPersistence().cacheResult(skillSubCategory);
	}

	/**
	* Caches the skill sub categories in the entity cache if it is enabled.
	*
	* @param skillSubCategories the skill sub categories
	*/
	public static void cacheResult(
		java.util.List<com.tekniti.skilltransit.service.model.SkillSubCategory> skillSubCategories) {
		getPersistence().cacheResult(skillSubCategories);
	}

	/**
	* Creates a new skill sub category with the primary key. Does not add the skill sub category to the database.
	*
	* @param primaryId the primary key for the new skill sub category
	* @return the new skill sub category
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory create(
		long primaryId) {
		return getPersistence().create(primaryId);
	}

	/**
	* Removes the skill sub category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryId the primary key of the skill sub category
	* @return the skill sub category that was removed
	* @throws com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException if a skill sub category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory remove(
		long primaryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException {
		return getPersistence().remove(primaryId);
	}

	public static com.tekniti.skilltransit.service.model.SkillSubCategory updateImpl(
		com.tekniti.skilltransit.service.model.SkillSubCategory skillSubCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(skillSubCategory, merge);
	}

	/**
	* Returns the skill sub category with the primary key or throws a {@link com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException} if it could not be found.
	*
	* @param primaryId the primary key of the skill sub category
	* @return the skill sub category
	* @throws com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException if a skill sub category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory findByPrimaryKey(
		long primaryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException {
		return getPersistence().findByPrimaryKey(primaryId);
	}

	/**
	* Returns the skill sub category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param primaryId the primary key of the skill sub category
	* @return the skill sub category, or <code>null</code> if a skill sub category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory fetchByPrimaryKey(
		long primaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(primaryId);
	}

	/**
	* Returns all the skill sub categories.
	*
	* @return the skill sub categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tekniti.skilltransit.service.model.SkillSubCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the skill sub categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of skill sub categories
	* @param end the upper bound of the range of skill sub categories (not inclusive)
	* @return the range of skill sub categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tekniti.skilltransit.service.model.SkillSubCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the skill sub categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of skill sub categories
	* @param end the upper bound of the range of skill sub categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of skill sub categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tekniti.skilltransit.service.model.SkillSubCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the skill sub categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of skill sub categories.
	*
	* @return the number of skill sub categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SkillSubCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SkillSubCategoryPersistence)PortletBeanLocatorUtil.locate(com.tekniti.skilltransit.service.service.ClpSerializer.getServletContextName(),
					SkillSubCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(SkillSubCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SkillSubCategoryPersistence persistence) {
	}

	private static SkillSubCategoryPersistence _persistence;
}