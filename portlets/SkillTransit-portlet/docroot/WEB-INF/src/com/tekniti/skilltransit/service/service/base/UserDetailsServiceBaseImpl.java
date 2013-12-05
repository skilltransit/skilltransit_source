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

package com.tekniti.skilltransit.service.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.tekniti.skilltransit.service.model.UserDetails;
import com.tekniti.skilltransit.service.service.SkillCategoryLocalService;
import com.tekniti.skilltransit.service.service.SkillCategoryService;
import com.tekniti.skilltransit.service.service.SkillSubCategoryLocalService;
import com.tekniti.skilltransit.service.service.SkillSubCategoryService;
import com.tekniti.skilltransit.service.service.UserDetailsLocalService;
import com.tekniti.skilltransit.service.service.UserDetailsService;
import com.tekniti.skilltransit.service.service.UserSkillsLocalService;
import com.tekniti.skilltransit.service.service.UserSkillsService;
import com.tekniti.skilltransit.service.service.persistence.SkillCategoryPersistence;
import com.tekniti.skilltransit.service.service.persistence.SkillSubCategoryPersistence;
import com.tekniti.skilltransit.service.service.persistence.UserDetailsPersistence;
import com.tekniti.skilltransit.service.service.persistence.UserSkillsPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the user details remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.tekniti.skilltransit.service.service.impl.UserDetailsServiceImpl}.
 * </p>
 *
 * @author Hari
 * @see com.tekniti.skilltransit.service.service.impl.UserDetailsServiceImpl
 * @see com.tekniti.skilltransit.service.service.UserDetailsServiceUtil
 * @generated
 */
public abstract class UserDetailsServiceBaseImpl extends BaseServiceImpl
	implements UserDetailsService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.tekniti.skilltransit.service.service.UserDetailsServiceUtil} to access the user details remote service.
	 */

	/**
	 * Returns the skill category local service.
	 *
	 * @return the skill category local service
	 */
	public SkillCategoryLocalService getSkillCategoryLocalService() {
		return skillCategoryLocalService;
	}

	/**
	 * Sets the skill category local service.
	 *
	 * @param skillCategoryLocalService the skill category local service
	 */
	public void setSkillCategoryLocalService(
		SkillCategoryLocalService skillCategoryLocalService) {
		this.skillCategoryLocalService = skillCategoryLocalService;
	}

	/**
	 * Returns the skill category remote service.
	 *
	 * @return the skill category remote service
	 */
	public SkillCategoryService getSkillCategoryService() {
		return skillCategoryService;
	}

	/**
	 * Sets the skill category remote service.
	 *
	 * @param skillCategoryService the skill category remote service
	 */
	public void setSkillCategoryService(
		SkillCategoryService skillCategoryService) {
		this.skillCategoryService = skillCategoryService;
	}

	/**
	 * Returns the skill category persistence.
	 *
	 * @return the skill category persistence
	 */
	public SkillCategoryPersistence getSkillCategoryPersistence() {
		return skillCategoryPersistence;
	}

	/**
	 * Sets the skill category persistence.
	 *
	 * @param skillCategoryPersistence the skill category persistence
	 */
	public void setSkillCategoryPersistence(
		SkillCategoryPersistence skillCategoryPersistence) {
		this.skillCategoryPersistence = skillCategoryPersistence;
	}

	/**
	 * Returns the skill sub category local service.
	 *
	 * @return the skill sub category local service
	 */
	public SkillSubCategoryLocalService getSkillSubCategoryLocalService() {
		return skillSubCategoryLocalService;
	}

	/**
	 * Sets the skill sub category local service.
	 *
	 * @param skillSubCategoryLocalService the skill sub category local service
	 */
	public void setSkillSubCategoryLocalService(
		SkillSubCategoryLocalService skillSubCategoryLocalService) {
		this.skillSubCategoryLocalService = skillSubCategoryLocalService;
	}

	/**
	 * Returns the skill sub category remote service.
	 *
	 * @return the skill sub category remote service
	 */
	public SkillSubCategoryService getSkillSubCategoryService() {
		return skillSubCategoryService;
	}

	/**
	 * Sets the skill sub category remote service.
	 *
	 * @param skillSubCategoryService the skill sub category remote service
	 */
	public void setSkillSubCategoryService(
		SkillSubCategoryService skillSubCategoryService) {
		this.skillSubCategoryService = skillSubCategoryService;
	}

	/**
	 * Returns the skill sub category persistence.
	 *
	 * @return the skill sub category persistence
	 */
	public SkillSubCategoryPersistence getSkillSubCategoryPersistence() {
		return skillSubCategoryPersistence;
	}

	/**
	 * Sets the skill sub category persistence.
	 *
	 * @param skillSubCategoryPersistence the skill sub category persistence
	 */
	public void setSkillSubCategoryPersistence(
		SkillSubCategoryPersistence skillSubCategoryPersistence) {
		this.skillSubCategoryPersistence = skillSubCategoryPersistence;
	}

	/**
	 * Returns the user details local service.
	 *
	 * @return the user details local service
	 */
	public UserDetailsLocalService getUserDetailsLocalService() {
		return userDetailsLocalService;
	}

	/**
	 * Sets the user details local service.
	 *
	 * @param userDetailsLocalService the user details local service
	 */
	public void setUserDetailsLocalService(
		UserDetailsLocalService userDetailsLocalService) {
		this.userDetailsLocalService = userDetailsLocalService;
	}

	/**
	 * Returns the user details remote service.
	 *
	 * @return the user details remote service
	 */
	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	/**
	 * Sets the user details remote service.
	 *
	 * @param userDetailsService the user details remote service
	 */
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	/**
	 * Returns the user details persistence.
	 *
	 * @return the user details persistence
	 */
	public UserDetailsPersistence getUserDetailsPersistence() {
		return userDetailsPersistence;
	}

	/**
	 * Sets the user details persistence.
	 *
	 * @param userDetailsPersistence the user details persistence
	 */
	public void setUserDetailsPersistence(
		UserDetailsPersistence userDetailsPersistence) {
		this.userDetailsPersistence = userDetailsPersistence;
	}

	/**
	 * Returns the user skills local service.
	 *
	 * @return the user skills local service
	 */
	public UserSkillsLocalService getUserSkillsLocalService() {
		return userSkillsLocalService;
	}

	/**
	 * Sets the user skills local service.
	 *
	 * @param userSkillsLocalService the user skills local service
	 */
	public void setUserSkillsLocalService(
		UserSkillsLocalService userSkillsLocalService) {
		this.userSkillsLocalService = userSkillsLocalService;
	}

	/**
	 * Returns the user skills remote service.
	 *
	 * @return the user skills remote service
	 */
	public UserSkillsService getUserSkillsService() {
		return userSkillsService;
	}

	/**
	 * Sets the user skills remote service.
	 *
	 * @param userSkillsService the user skills remote service
	 */
	public void setUserSkillsService(UserSkillsService userSkillsService) {
		this.userSkillsService = userSkillsService;
	}

	/**
	 * Returns the user skills persistence.
	 *
	 * @return the user skills persistence
	 */
	public UserSkillsPersistence getUserSkillsPersistence() {
		return userSkillsPersistence;
	}

	/**
	 * Sets the user skills persistence.
	 *
	 * @param userSkillsPersistence the user skills persistence
	 */
	public void setUserSkillsPersistence(
		UserSkillsPersistence userSkillsPersistence) {
		this.userSkillsPersistence = userSkillsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return UserDetails.class;
	}

	protected String getModelClassName() {
		return UserDetails.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = userDetailsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = SkillCategoryLocalService.class)
	protected SkillCategoryLocalService skillCategoryLocalService;
	@BeanReference(type = SkillCategoryService.class)
	protected SkillCategoryService skillCategoryService;
	@BeanReference(type = SkillCategoryPersistence.class)
	protected SkillCategoryPersistence skillCategoryPersistence;
	@BeanReference(type = SkillSubCategoryLocalService.class)
	protected SkillSubCategoryLocalService skillSubCategoryLocalService;
	@BeanReference(type = SkillSubCategoryService.class)
	protected SkillSubCategoryService skillSubCategoryService;
	@BeanReference(type = SkillSubCategoryPersistence.class)
	protected SkillSubCategoryPersistence skillSubCategoryPersistence;
	@BeanReference(type = UserDetailsLocalService.class)
	protected UserDetailsLocalService userDetailsLocalService;
	@BeanReference(type = UserDetailsService.class)
	protected UserDetailsService userDetailsService;
	@BeanReference(type = UserDetailsPersistence.class)
	protected UserDetailsPersistence userDetailsPersistence;
	@BeanReference(type = UserSkillsLocalService.class)
	protected UserSkillsLocalService userSkillsLocalService;
	@BeanReference(type = UserSkillsService.class)
	protected UserSkillsService userSkillsService;
	@BeanReference(type = UserSkillsPersistence.class)
	protected UserSkillsPersistence userSkillsPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private UserDetailsServiceClpInvoker _clpInvoker = new UserDetailsServiceClpInvoker();
}