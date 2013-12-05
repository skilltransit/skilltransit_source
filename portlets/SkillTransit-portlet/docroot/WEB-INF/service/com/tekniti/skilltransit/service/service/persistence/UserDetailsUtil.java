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

import com.tekniti.skilltransit.service.model.UserDetails;

import java.util.List;

/**
 * The persistence utility for the user details service. This utility wraps {@link UserDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hari
 * @see UserDetailsPersistence
 * @see UserDetailsPersistenceImpl
 * @generated
 */
public class UserDetailsUtil {
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
	public static void clearCache(UserDetails userDetails) {
		getPersistence().clearCache(userDetails);
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
	public static List<UserDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserDetails update(UserDetails userDetails, boolean merge)
		throws SystemException {
		return getPersistence().update(userDetails, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserDetails update(UserDetails userDetails, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userDetails, merge, serviceContext);
	}

	/**
	* Caches the user details in the entity cache if it is enabled.
	*
	* @param userDetails the user details
	*/
	public static void cacheResult(
		com.tekniti.skilltransit.service.model.UserDetails userDetails) {
		getPersistence().cacheResult(userDetails);
	}

	/**
	* Caches the user detailses in the entity cache if it is enabled.
	*
	* @param userDetailses the user detailses
	*/
	public static void cacheResult(
		java.util.List<com.tekniti.skilltransit.service.model.UserDetails> userDetailses) {
		getPersistence().cacheResult(userDetailses);
	}

	/**
	* Creates a new user details with the primary key. Does not add the user details to the database.
	*
	* @param userId the primary key for the new user details
	* @return the new user details
	*/
	public static com.tekniti.skilltransit.service.model.UserDetails create(
		long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the user details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user details
	* @return the user details that was removed
	* @throws com.tekniti.skilltransit.service.NoSuchUserDetailsException if a user details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.UserDetails remove(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchUserDetailsException {
		return getPersistence().remove(userId);
	}

	public static com.tekniti.skilltransit.service.model.UserDetails updateImpl(
		com.tekniti.skilltransit.service.model.UserDetails userDetails,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userDetails, merge);
	}

	/**
	* Returns the user details with the primary key or throws a {@link com.tekniti.skilltransit.service.NoSuchUserDetailsException} if it could not be found.
	*
	* @param userId the primary key of the user details
	* @return the user details
	* @throws com.tekniti.skilltransit.service.NoSuchUserDetailsException if a user details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.UserDetails findByPrimaryKey(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tekniti.skilltransit.service.NoSuchUserDetailsException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the user details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the user details
	* @return the user details, or <code>null</code> if a user details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.UserDetails fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	* Returns all the user detailses.
	*
	* @return the user detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tekniti.skilltransit.service.model.UserDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.tekniti.skilltransit.service.model.UserDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.tekniti.skilltransit.service.model.UserDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user detailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user detailses.
	*
	* @return the number of user detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserDetailsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserDetailsPersistence)PortletBeanLocatorUtil.locate(com.tekniti.skilltransit.service.service.ClpSerializer.getServletContextName(),
					UserDetailsPersistence.class.getName());

			ReferenceRegistry.registerReference(UserDetailsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(UserDetailsPersistence persistence) {
	}

	private static UserDetailsPersistence _persistence;
}