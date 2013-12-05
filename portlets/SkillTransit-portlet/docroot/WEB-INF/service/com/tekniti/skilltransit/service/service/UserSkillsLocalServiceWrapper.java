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

package com.tekniti.skilltransit.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UserSkillsLocalService}.
 * </p>
 *
 * @author    Hari
 * @see       UserSkillsLocalService
 * @generated
 */
public class UserSkillsLocalServiceWrapper implements UserSkillsLocalService,
	ServiceWrapper<UserSkillsLocalService> {
	public UserSkillsLocalServiceWrapper(
		UserSkillsLocalService userSkillsLocalService) {
		_userSkillsLocalService = userSkillsLocalService;
	}

	/**
	* Adds the user skills to the database. Also notifies the appropriate model listeners.
	*
	* @param userSkills the user skills
	* @return the user skills that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills addUserSkills(
		com.tekniti.skilltransit.service.model.UserSkills userSkills)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.addUserSkills(userSkills);
	}

	/**
	* Creates a new user skills with the primary key. Does not add the user skills to the database.
	*
	* @param primId the primary key for the new user skills
	* @return the new user skills
	*/
	public com.tekniti.skilltransit.service.model.UserSkills createUserSkills(
		long primId) {
		return _userSkillsLocalService.createUserSkills(primId);
	}

	/**
	* Deletes the user skills with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primId the primary key of the user skills
	* @return the user skills that was removed
	* @throws PortalException if a user skills with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills deleteUserSkills(
		long primId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.deleteUserSkills(primId);
	}

	/**
	* Deletes the user skills from the database. Also notifies the appropriate model listeners.
	*
	* @param userSkills the user skills
	* @return the user skills that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills deleteUserSkills(
		com.tekniti.skilltransit.service.model.UserSkills userSkills)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.deleteUserSkills(userSkills);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userSkillsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.tekniti.skilltransit.service.model.UserSkills fetchUserSkills(
		long primId) throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.fetchUserSkills(primId);
	}

	/**
	* Returns the user skills with the primary key.
	*
	* @param primId the primary key of the user skills
	* @return the user skills
	* @throws PortalException if a user skills with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills getUserSkills(
		long primId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.getUserSkills(primId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.tekniti.skilltransit.service.model.UserSkills> getUserSkillses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.getUserSkillses(start, end);
	}

	/**
	* Returns the number of user skillses.
	*
	* @return the number of user skillses
	* @throws SystemException if a system exception occurred
	*/
	public int getUserSkillsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.getUserSkillsesCount();
	}

	/**
	* Updates the user skills in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSkills the user skills
	* @return the user skills that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills updateUserSkills(
		com.tekniti.skilltransit.service.model.UserSkills userSkills)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.updateUserSkills(userSkills);
	}

	/**
	* Updates the user skills in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSkills the user skills
	* @param merge whether to merge the user skills with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user skills that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.tekniti.skilltransit.service.model.UserSkills updateUserSkills(
		com.tekniti.skilltransit.service.model.UserSkills userSkills,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.updateUserSkills(userSkills, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _userSkillsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userSkillsLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userSkillsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.tekniti.skilltransit.service.model.UserSkills createUserSkills()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.createUserSkills();
	}

	public java.util.List<java.lang.String> getUserSkillsByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSkillsLocalService.getUserSkillsByUserId(userId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserSkillsLocalService getWrappedUserSkillsLocalService() {
		return _userSkillsLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserSkillsLocalService(
		UserSkillsLocalService userSkillsLocalService) {
		_userSkillsLocalService = userSkillsLocalService;
	}

	public UserSkillsLocalService getWrappedService() {
		return _userSkillsLocalService;
	}

	public void setWrappedService(UserSkillsLocalService userSkillsLocalService) {
		_userSkillsLocalService = userSkillsLocalService;
	}

	private UserSkillsLocalService _userSkillsLocalService;
}