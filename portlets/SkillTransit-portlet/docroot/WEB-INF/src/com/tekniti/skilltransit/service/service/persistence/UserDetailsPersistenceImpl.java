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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.tekniti.skilltransit.service.NoSuchUserDetailsException;
import com.tekniti.skilltransit.service.model.UserDetails;
import com.tekniti.skilltransit.service.model.impl.UserDetailsImpl;
import com.tekniti.skilltransit.service.model.impl.UserDetailsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hari
 * @see UserDetailsPersistence
 * @see UserDetailsUtil
 * @generated
 */
public class UserDetailsPersistenceImpl extends BasePersistenceImpl<UserDetails>
	implements UserDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserDetailsUtil} to access the user details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserDetailsModelImpl.ENTITY_CACHE_ENABLED,
			UserDetailsModelImpl.FINDER_CACHE_ENABLED, UserDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserDetailsModelImpl.ENTITY_CACHE_ENABLED,
			UserDetailsModelImpl.FINDER_CACHE_ENABLED, UserDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserDetailsModelImpl.ENTITY_CACHE_ENABLED,
			UserDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the user details in the entity cache if it is enabled.
	 *
	 * @param userDetails the user details
	 */
	public void cacheResult(UserDetails userDetails) {
		EntityCacheUtil.putResult(UserDetailsModelImpl.ENTITY_CACHE_ENABLED,
			UserDetailsImpl.class, userDetails.getPrimaryKey(), userDetails);

		userDetails.resetOriginalValues();
	}

	/**
	 * Caches the user detailses in the entity cache if it is enabled.
	 *
	 * @param userDetailses the user detailses
	 */
	public void cacheResult(List<UserDetails> userDetailses) {
		for (UserDetails userDetails : userDetailses) {
			if (EntityCacheUtil.getResult(
						UserDetailsModelImpl.ENTITY_CACHE_ENABLED,
						UserDetailsImpl.class, userDetails.getPrimaryKey()) == null) {
				cacheResult(userDetails);
			}
			else {
				userDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user detailses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserDetailsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserDetailsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserDetails userDetails) {
		EntityCacheUtil.removeResult(UserDetailsModelImpl.ENTITY_CACHE_ENABLED,
			UserDetailsImpl.class, userDetails.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserDetails> userDetailses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserDetails userDetails : userDetailses) {
			EntityCacheUtil.removeResult(UserDetailsModelImpl.ENTITY_CACHE_ENABLED,
				UserDetailsImpl.class, userDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user details with the primary key. Does not add the user details to the database.
	 *
	 * @param userId the primary key for the new user details
	 * @return the new user details
	 */
	public UserDetails create(long userId) {
		UserDetails userDetails = new UserDetailsImpl();

		userDetails.setNew(true);
		userDetails.setPrimaryKey(userId);

		return userDetails;
	}

	/**
	 * Removes the user details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the user details
	 * @return the user details that was removed
	 * @throws com.tekniti.skilltransit.service.NoSuchUserDetailsException if a user details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserDetails remove(long userId)
		throws NoSuchUserDetailsException, SystemException {
		return remove(Long.valueOf(userId));
	}

	/**
	 * Removes the user details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user details
	 * @return the user details that was removed
	 * @throws com.tekniti.skilltransit.service.NoSuchUserDetailsException if a user details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDetails remove(Serializable primaryKey)
		throws NoSuchUserDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserDetails userDetails = (UserDetails)session.get(UserDetailsImpl.class,
					primaryKey);

			if (userDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userDetails);
		}
		catch (NoSuchUserDetailsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserDetails removeImpl(UserDetails userDetails)
		throws SystemException {
		userDetails = toUnwrappedModel(userDetails);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, userDetails);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(userDetails);

		return userDetails;
	}

	@Override
	public UserDetails updateImpl(
		com.tekniti.skilltransit.service.model.UserDetails userDetails,
		boolean merge) throws SystemException {
		userDetails = toUnwrappedModel(userDetails);

		boolean isNew = userDetails.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userDetails, merge);

			userDetails.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UserDetailsModelImpl.ENTITY_CACHE_ENABLED,
			UserDetailsImpl.class, userDetails.getPrimaryKey(), userDetails);

		return userDetails;
	}

	protected UserDetails toUnwrappedModel(UserDetails userDetails) {
		if (userDetails instanceof UserDetailsImpl) {
			return userDetails;
		}

		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();

		userDetailsImpl.setNew(userDetails.isNew());
		userDetailsImpl.setPrimaryKey(userDetails.getPrimaryKey());

		userDetailsImpl.setUserId(userDetails.getUserId());
		userDetailsImpl.setHourlyRate(userDetails.getHourlyRate());
		userDetailsImpl.setZipCode(userDetails.getZipCode());
		userDetailsImpl.setCategory(userDetails.getCategory());
		userDetailsImpl.setClient(userDetails.getClient());
		userDetailsImpl.setCommute(userDetails.getCommute());
		userDetailsImpl.setSkill(userDetails.getSkill());
		userDetailsImpl.setState(userDetails.getState());

		return userDetailsImpl;
	}

	/**
	 * Returns the user details with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user details
	 * @return the user details
	 * @throws com.liferay.portal.NoSuchModelException if a user details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the user details with the primary key or throws a {@link com.tekniti.skilltransit.service.NoSuchUserDetailsException} if it could not be found.
	 *
	 * @param userId the primary key of the user details
	 * @return the user details
	 * @throws com.tekniti.skilltransit.service.NoSuchUserDetailsException if a user details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserDetails findByPrimaryKey(long userId)
		throws NoSuchUserDetailsException, SystemException {
		UserDetails userDetails = fetchByPrimaryKey(userId);

		if (userDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userId);
			}

			throw new NoSuchUserDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userId);
		}

		return userDetails;
	}

	/**
	 * Returns the user details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user details
	 * @return the user details, or <code>null</code> if a user details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDetails fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the user details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the user details
	 * @return the user details, or <code>null</code> if a user details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserDetails fetchByPrimaryKey(long userId) throws SystemException {
		UserDetails userDetails = (UserDetails)EntityCacheUtil.getResult(UserDetailsModelImpl.ENTITY_CACHE_ENABLED,
				UserDetailsImpl.class, userId);

		if (userDetails == _nullUserDetails) {
			return null;
		}

		if (userDetails == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				userDetails = (UserDetails)session.get(UserDetailsImpl.class,
						Long.valueOf(userId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (userDetails != null) {
					cacheResult(userDetails);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UserDetailsModelImpl.ENTITY_CACHE_ENABLED,
						UserDetailsImpl.class, userId, _nullUserDetails);
				}

				closeSession(session);
			}
		}

		return userDetails;
	}

	/**
	 * Returns all the user detailses.
	 *
	 * @return the user detailses
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<UserDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<UserDetails> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<UserDetails> list = (List<UserDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERDETAILS.concat(UserDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UserDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UserDetails>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user detailses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UserDetails userDetails : findAll()) {
			remove(userDetails);
		}
	}

	/**
	 * Returns the number of user detailses.
	 *
	 * @return the number of user detailses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERDETAILS);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the user details persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tekniti.skilltransit.service.model.UserDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserDetails>> listenersList = new ArrayList<ModelListener<UserDetails>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<UserDetails>)InstanceFactory.newInstance(
							clazz.getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(UserDetailsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = SkillCategoryPersistence.class)
	protected SkillCategoryPersistence skillCategoryPersistence;
	@BeanReference(type = SkillSubCategoryPersistence.class)
	protected SkillSubCategoryPersistence skillSubCategoryPersistence;
	@BeanReference(type = UserDetailsPersistence.class)
	protected UserDetailsPersistence userDetailsPersistence;
	@BeanReference(type = UserSkillsPersistence.class)
	protected UserSkillsPersistence userSkillsPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_USERDETAILS = "SELECT userDetails FROM UserDetails userDetails";
	private static final String _SQL_COUNT_USERDETAILS = "SELECT COUNT(userDetails) FROM UserDetails userDetails";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserDetails exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserDetailsPersistenceImpl.class);
	private static UserDetails _nullUserDetails = new UserDetailsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserDetails> toCacheModel() {
				return _nullUserDetailsCacheModel;
			}
		};

	private static CacheModel<UserDetails> _nullUserDetailsCacheModel = new CacheModel<UserDetails>() {
			public UserDetails toEntityModel() {
				return _nullUserDetails;
			}
		};
}