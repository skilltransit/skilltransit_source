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
 * The utility for the skill sub category local service. This utility wraps {@link com.tekniti.skilltransit.service.service.impl.SkillSubCategoryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Hari
 * @see SkillSubCategoryLocalService
 * @see com.tekniti.skilltransit.service.service.base.SkillSubCategoryLocalServiceBaseImpl
 * @see com.tekniti.skilltransit.service.service.impl.SkillSubCategoryLocalServiceImpl
 * @generated
 */
public class SkillSubCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.tekniti.skilltransit.service.service.impl.SkillSubCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the skill sub category to the database. Also notifies the appropriate model listeners.
	*
	* @param skillSubCategory the skill sub category
	* @return the skill sub category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory addSkillSubCategory(
		com.tekniti.skilltransit.service.model.SkillSubCategory skillSubCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSkillSubCategory(skillSubCategory);
	}

	/**
	* Creates a new skill sub category with the primary key. Does not add the skill sub category to the database.
	*
	* @param primaryId the primary key for the new skill sub category
	* @return the new skill sub category
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory createSkillSubCategory(
		long primaryId) {
		return getService().createSkillSubCategory(primaryId);
	}

	/**
	* Deletes the skill sub category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryId the primary key of the skill sub category
	* @return the skill sub category that was removed
	* @throws PortalException if a skill sub category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory deleteSkillSubCategory(
		long primaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSkillSubCategory(primaryId);
	}

	/**
	* Deletes the skill sub category from the database. Also notifies the appropriate model listeners.
	*
	* @param skillSubCategory the skill sub category
	* @return the skill sub category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory deleteSkillSubCategory(
		com.tekniti.skilltransit.service.model.SkillSubCategory skillSubCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSkillSubCategory(skillSubCategory);
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

	public static com.tekniti.skilltransit.service.model.SkillSubCategory fetchSkillSubCategory(
		long primaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSkillSubCategory(primaryId);
	}

	/**
	* Returns the skill sub category with the primary key.
	*
	* @param primaryId the primary key of the skill sub category
	* @return the skill sub category
	* @throws PortalException if a skill sub category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory getSkillSubCategory(
		long primaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSkillSubCategory(primaryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.tekniti.skilltransit.service.model.SkillSubCategory> getSkillSubCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSkillSubCategories(start, end);
	}

	/**
	* Returns the number of skill sub categories.
	*
	* @return the number of skill sub categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getSkillSubCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSkillSubCategoriesCount();
	}

	/**
	* Updates the skill sub category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param skillSubCategory the skill sub category
	* @return the skill sub category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory updateSkillSubCategory(
		com.tekniti.skilltransit.service.model.SkillSubCategory skillSubCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSkillSubCategory(skillSubCategory);
	}

	/**
	* Updates the skill sub category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param skillSubCategory the skill sub category
	* @param merge whether to merge the skill sub category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the skill sub category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.tekniti.skilltransit.service.model.SkillSubCategory updateSkillSubCategory(
		com.tekniti.skilltransit.service.model.SkillSubCategory skillSubCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSkillSubCategory(skillSubCategory, merge);
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

	public static java.util.List<com.tekniti.skilltransit.service.model.SkillSubCategory> typeaheadSearch(
		java.lang.String search) {
		return getService().typeaheadSearch(search);
	}

	public static void clearService() {
		_service = null;
	}

	public static SkillSubCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SkillSubCategoryLocalService.class.getName());

			if (invokableLocalService instanceof SkillSubCategoryLocalService) {
				_service = (SkillSubCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new SkillSubCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SkillSubCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(SkillSubCategoryLocalService service) {
	}

	private static SkillSubCategoryLocalService _service;
}