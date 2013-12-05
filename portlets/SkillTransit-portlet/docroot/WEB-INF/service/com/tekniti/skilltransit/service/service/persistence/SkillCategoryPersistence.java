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

import com.liferay.portal.service.persistence.BasePersistence;

import com.tekniti.skilltransit.service.model.SkillCategory;

/**
 * The persistence interface for the skill category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hari
 * @see SkillCategoryPersistenceImpl
 * @see SkillCategoryUtil
 * @generated
 */
public interface SkillCategoryPersistence extends BasePersistence<SkillCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SkillCategoryUtil} to access the skill category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the skill category in the entity cache if it is enabled.
	*
	* @param skillCategory the skill category
	*/
	public void cacheResult(
		com.tekniti.skilltransit.service.model.SkillCategory skillCategory);

	/**
	* Caches the skill categories in the entity cache if it is enabled.
	*
	* @param skillCategories the skill categories
	*/
	public void cacheResult(
		java.util.List<com.tekniti.skilltransit.service.model.SkillCategory> skillCategories);

	/**
	* Creates a new skill category with the primary key. Does not add the skill category to the database.
	*
	* @param primaryId the primary key for the new skill category
	* @return the new skill category
	*/
	public com.tekniti.skilltransit.service.model.SkillCategory create(
		long primaryId);

	/**
	* Removes the skill category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryId the primary key of the skill category
	* @return the skill category that was removed
	* @throws com.tekniti.skilltransit.service.NoSuchSkillCategoryException if a skill category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.SkillCategory remove(
		long primaryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchSkillCategoryException;

	public com.tekniti.skilltransit.service.model.SkillCategory updateImpl(
		com.tekniti.skilltransit.service.model.SkillCategory skillCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the skill category with the primary key or throws a {@link com.tekniti.skilltransit.service.NoSuchSkillCategoryException} if it could not be found.
	*
	* @param primaryId the primary key of the skill category
	* @return the skill category
	* @throws com.tekniti.skilltransit.service.NoSuchSkillCategoryException if a skill category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.SkillCategory findByPrimaryKey(
		long primaryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchSkillCategoryException;

	/**
	* Returns the skill category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param primaryId the primary key of the skill category
	* @return the skill category, or <code>null</code> if a skill category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.SkillCategory fetchByPrimaryKey(
		long primaryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the skill categories.
	*
	* @return the skill categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.SkillCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the skill categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of skill categories
	* @param end the upper bound of the range of skill categories (not inclusive)
	* @return the range of skill categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.SkillCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the skill categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of skill categories
	* @param end the upper bound of the range of skill categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of skill categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.SkillCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the skill categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of skill categories.
	*
	* @return the number of skill categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}