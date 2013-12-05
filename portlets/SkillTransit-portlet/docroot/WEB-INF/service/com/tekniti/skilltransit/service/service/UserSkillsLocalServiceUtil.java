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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the user skills local service. This utility wraps {@link com.tekniti.skilltransit.service.service.impl.UserSkillsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Hari
 * @see UserSkillsLocalService
 * @see com.tekniti.skilltransit.service.service.base.UserSkillsLocalServiceBaseImpl
 * @see com.tekniti.skilltransit.service.service.impl.UserSkillsLocalServiceImpl
 * @generated
 */
public class UserSkillsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.tekniti.skilltransit.service.service.impl.UserSkillsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user skills to the database. Also notifies the appropriate model listeners.
	*
	* @param userSkills the user skills
	* @return the user skills that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.UserSkills addUserSkills(
		com.tekniti.skilltransit.service.model.UserSkills userSkills)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserSkills(userSkills);
	}

	/**
	* Creates a new user skills with the primary key. Does not add the user skills to the database.
	*
	* @param primId the primary key for the new user skills
	* @return the new user skills
	*/
	public static com.tekniti.skilltransit.service.model.UserSkills createUserSkills(
		long primId) {
		return getService().createUserSkills(primId);
	}

	/**
	* Deletes the user skills with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primId the primary key of the user skills
	* @return the user skills that was removed
	* @throws PortalException if a user skills with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.UserSkills deleteUserSkills(
		long primId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserSkills(primId);
	}

	/**
	* Deletes the user skills from the database. Also notifies the appropriate model listeners.
	*
	* @param userSkills the user skills
	* @return the user skills that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.UserSkills deleteUserSkills(
		com.tekniti.skilltransit.service.model.UserSkills userSkills)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserSkills(userSkills);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.tekniti.skilltransit.service.model.UserSkills fetchUserSkills(
		long primId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserSkills(primId);
	}

	/**
	* Returns the user skills with the primary key.
	*
	* @param primId the primary key of the user skills
	* @return the user skills
	* @throws PortalException if a user skills with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.UserSkills getUserSkills(
		long primId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSkills(primId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.tekniti.skilltransit.service.model.UserSkills> getUserSkillses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSkillses(start, end);
	}

	/**
	* Returns the number of user skillses.
	*
	* @return the number of user skillses
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserSkillsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSkillsesCount();
	}

	/**
	* Updates the user skills in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSkills the user skills
	* @return the user skills that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.UserSkills updateUserSkills(
		com.tekniti.skilltransit.service.model.UserSkills userSkills)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserSkills(userSkills);
	}

	/**
	* Updates the user skills in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSkills the user skills
	* @param merge whether to merge the user skills with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user skills that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.UserSkills updateUserSkills(
		com.tekniti.skilltransit.service.model.UserSkills userSkills,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserSkills(userSkills, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.tekniti.skilltransit.service.model.UserSkills createUserSkills()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createUserSkills();
	}

	public static java.util.List<java.lang.String> getUserSkillsByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSkillsByUserId(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserSkillsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserSkillsLocalService.class.getName());

			if (invokableLocalService instanceof UserSkillsLocalService) {
				_service = (UserSkillsLocalService)invokableLocalService;
			}
			else {
				_service = new UserSkillsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserSkillsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(UserSkillsLocalService service) {
	}

	private static UserSkillsLocalService _service;
}