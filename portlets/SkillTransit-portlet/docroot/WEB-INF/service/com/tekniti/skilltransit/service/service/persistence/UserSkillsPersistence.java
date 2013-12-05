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

import com.tekniti.skilltransit.service.model.UserSkills;

/**
 * The persistence interface for the user skills service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hari
 * @see UserSkillsPersistenceImpl
 * @see UserSkillsUtil
 * @generated
 */
public interface UserSkillsPersistence extends BasePersistence<UserSkills> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserSkillsUtil} to access the user skills persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user skills in the entity cache if it is enabled.
	*
	* @param userSkills the user skills
	*/
	public void cacheResult(
		com.tekniti.skilltransit.service.model.UserSkills userSkills);

	/**
	* Caches the user skillses in the entity cache if it is enabled.
	*
	* @param userSkillses the user skillses
	*/
	public void cacheResult(
		java.util.List<com.tekniti.skilltransit.service.model.UserSkills> userSkillses);

	/**
	* Creates a new user skills with the primary key. Does not add the user skills to the database.
	*
	* @param primId the primary key for the new user skills
	* @return the new user skills
	*/
	public com.tekniti.skilltransit.service.model.UserSkills create(long primId);

	/**
	* Removes the user skills with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primId the primary key of the user skills
	* @return the user skills that was removed
	* @throws com.tekniti.skilltransit.service.NoSuchUserSkillsException if a user skills with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills remove(long primId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchUserSkillsException;

	public com.tekniti.skilltransit.service.model.UserSkills updateImpl(
		com.tekniti.skilltransit.service.model.UserSkills userSkills,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user skills with the primary key or throws a {@link com.tekniti.skilltransit.service.NoSuchUserSkillsException} if it could not be found.
	*
	* @param primId the primary key of the user skills
	* @return the user skills
	* @throws com.tekniti.skilltransit.service.NoSuchUserSkillsException if a user skills with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills findByPrimaryKey(
		long primId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchUserSkillsException;

	/**
	* Returns the user skills with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param primId the primary key of the user skills
	* @return the user skills, or <code>null</code> if a user skills with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills fetchByPrimaryKey(
		long primId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user skillses where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the matching user skillses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.UserSkills> findByuserId(
		long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user skillses where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of user skillses
	* @param end the upper bound of the range of user skillses (not inclusive)
	* @return the range of matching user skillses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.UserSkills> findByuserId(
		long user_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user skillses where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of user skillses
	* @param end the upper bound of the range of user skillses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user skillses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.UserSkills> findByuserId(
		long user_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user skills in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user skills
	* @throws com.tekniti.skilltransit.service.NoSuchUserSkillsException if a matching user skills could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills findByuserId_First(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchUserSkillsException;

	/**
	* Returns the first user skills in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user skills, or <code>null</code> if a matching user skills could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills fetchByuserId_First(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user skills in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user skills
	* @throws com.tekniti.skilltransit.service.NoSuchUserSkillsException if a matching user skills could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills findByuserId_Last(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchUserSkillsException;

	/**
	* Returns the last user skills in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user skills, or <code>null</code> if a matching user skills could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills fetchByuserId_Last(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user skillses before and after the current user skills in the ordered set where user_id = &#63;.
	*
	* @param primId the primary key of the current user skills
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user skills
	* @throws com.tekniti.skilltransit.service.NoSuchUserSkillsException if a user skills with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills[] findByuserId_PrevAndNext(
		long primId, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchUserSkillsException;

	/**
	* Returns all the user skillses.
	*
	* @return the user skillses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.UserSkills> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user skillses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user skillses
	* @param end the upper bound of the range of user skillses (not inclusive)
	* @return the range of user skillses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.UserSkills> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user skillses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user skillses
	* @param end the upper bound of the range of user skillses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user skillses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.UserSkills> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user skillses where user_id = &#63; from the database.
	*
	* @param user_id the user_id
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user skillses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user skillses where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the number of matching user skillses
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user skillses.
	*
	* @return the number of user skillses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}