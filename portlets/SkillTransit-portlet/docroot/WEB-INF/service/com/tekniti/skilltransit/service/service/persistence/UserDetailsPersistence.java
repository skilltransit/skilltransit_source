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

import com.tekniti.skilltransit.service.model.UserDetails;

/**
 * The persistence interface for the user details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hari
 * @see UserDetailsPersistenceImpl
 * @see UserDetailsUtil
 * @generated
 */
public interface UserDetailsPersistence extends BasePersistence<UserDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserDetailsUtil} to access the user details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user details in the entity cache if it is enabled.
	*
	* @param userDetails the user details
	*/
	public void cacheResult(
		com.tekniti.skilltransit.service.model.UserDetails userDetails);

	/**
	* Caches the user detailses in the entity cache if it is enabled.
	*
	* @param userDetailses the user detailses
	*/
	public void cacheResult(
		java.util.List<com.tekniti.skilltransit.service.model.UserDetails> userDetailses);

	/**
	* Creates a new user details with the primary key. Does not add the user details to the database.
	*
	* @param userId the primary key for the new user details
	* @return the new user details
	*/
	public com.tekniti.skilltransit.service.model.UserDetails create(
		long userId);

	/**
	* Removes the user details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user details
	* @return the user details that was removed
	* @throws com.tekniti.skilltransit.service.NoSuchUserDetailsException if a user details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserDetails remove(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchUserDetailsException;

	public com.tekniti.skilltransit.service.model.UserDetails updateImpl(
		com.tekniti.skilltransit.service.model.UserDetails userDetails,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user details with the primary key or throws a {@link com.tekniti.skilltransit.service.NoSuchUserDetailsException} if it could not be found.
	*
	* @param userId the primary key of the user details
	* @return the user details
	* @throws com.tekniti.skilltransit.service.NoSuchUserDetailsException if a user details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserDetails findByPrimaryKey(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchUserDetailsException;

	/**
	* Returns the user details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the user details
	* @return the user details, or <code>null</code> if a user details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserDetails fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user detailses.
	*
	* @return the user detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.UserDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user detailses
	* @param end the upper bound of the range of user detailses (not inclusive)
	* @return the range of user detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.UserDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user detailses
	* @param end the upper bound of the range of user detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tekniti.skilltransit.service.model.UserDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user detailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user detailses.
	*
	* @return the number of user detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}