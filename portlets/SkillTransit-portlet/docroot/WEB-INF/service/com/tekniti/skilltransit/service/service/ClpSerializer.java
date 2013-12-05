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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.tekniti.skilltransit.service.model.SkillCategoryClp;
import com.tekniti.skilltransit.service.model.SkillSubCategoryClp;
import com.tekniti.skilltransit.service.model.UserDetailsClp;
import com.tekniti.skilltransit.service.model.UserSkillsClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"SkillTransit-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"SkillTransit-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "SkillTransit-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SkillCategoryClp.class.getName())) {
			return translateInputSkillCategory(oldModel);
		}

		if (oldModelClassName.equals(SkillSubCategoryClp.class.getName())) {
			return translateInputSkillSubCategory(oldModel);
		}

		if (oldModelClassName.equals(UserDetailsClp.class.getName())) {
			return translateInputUserDetails(oldModel);
		}

		if (oldModelClassName.equals(UserSkillsClp.class.getName())) {
			return translateInputUserSkills(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputSkillCategory(BaseModel<?> oldModel) {
		SkillCategoryClp oldClpModel = (SkillCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSkillCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSkillSubCategory(BaseModel<?> oldModel) {
		SkillSubCategoryClp oldClpModel = (SkillSubCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSkillSubCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserDetails(BaseModel<?> oldModel) {
		UserDetailsClp oldClpModel = (UserDetailsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserDetailsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserSkills(BaseModel<?> oldModel) {
		UserSkillsClp oldClpModel = (UserSkillsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserSkillsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.tekniti.skilltransit.service.model.impl.SkillCategoryImpl")) {
			return translateOutputSkillCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tekniti.skilltransit.service.model.impl.SkillSubCategoryImpl")) {
			return translateOutputSkillSubCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tekniti.skilltransit.service.model.impl.UserDetailsImpl")) {
			return translateOutputUserDetails(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tekniti.skilltransit.service.model.impl.UserSkillsImpl")) {
			return translateOutputUserSkills(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.tekniti.skilltransit.service.NoSuchSkillCategoryException")) {
			return new com.tekniti.skilltransit.service.NoSuchSkillCategoryException();
		}

		if (className.equals(
					"com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException")) {
			return new com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException();
		}

		if (className.equals(
					"com.tekniti.skilltransit.service.NoSuchUserDetailsException")) {
			return new com.tekniti.skilltransit.service.NoSuchUserDetailsException();
		}

		if (className.equals(
					"com.tekniti.skilltransit.service.NoSuchUserSkillsException")) {
			return new com.tekniti.skilltransit.service.NoSuchUserSkillsException();
		}

		return throwable;
	}

	public static Object translateOutputSkillCategory(BaseModel<?> oldModel) {
		SkillCategoryClp newModel = new SkillCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSkillCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSkillSubCategory(BaseModel<?> oldModel) {
		SkillSubCategoryClp newModel = new SkillSubCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSkillSubCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserDetails(BaseModel<?> oldModel) {
		UserDetailsClp newModel = new UserDetailsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserDetailsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserSkills(BaseModel<?> oldModel) {
		UserSkillsClp newModel = new UserSkillsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserSkillsRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}