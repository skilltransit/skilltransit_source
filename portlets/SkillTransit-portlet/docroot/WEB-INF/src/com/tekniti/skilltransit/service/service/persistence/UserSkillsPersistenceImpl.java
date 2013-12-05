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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.tekniti.skilltransit.service.NoSuchUserSkillsException;
import com.tekniti.skilltransit.service.model.UserSkills;
import com.tekniti.skilltransit.service.model.impl.UserSkillsImpl;
import com.tekniti.skilltransit.service.model.impl.UserSkillsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user skills service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hari
 * @see UserSkillsPersistence
 * @see UserSkillsUtil
 * @generated
 */
public class UserSkillsPersistenceImpl extends BasePersistenceImpl<UserSkills>
	implements UserSkillsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserSkillsUtil} to access the user skills persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserSkillsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
			UserSkillsModelImpl.FINDER_CACHE_ENABLED, UserSkillsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
			UserSkillsModelImpl.FINDER_CACHE_ENABLED, UserSkillsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			UserSkillsModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
			UserSkillsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
			UserSkillsModelImpl.FINDER_CACHE_ENABLED, UserSkillsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
			UserSkillsModelImpl.FINDER_CACHE_ENABLED, UserSkillsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
			UserSkillsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the user skills in the entity cache if it is enabled.
	 *
	 * @param userSkills the user skills
	 */
	public void cacheResult(UserSkills userSkills) {
		EntityCacheUtil.putResult(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
			UserSkillsImpl.class, userSkills.getPrimaryKey(), userSkills);

		userSkills.resetOriginalValues();
	}

	/**
	 * Caches the user skillses in the entity cache if it is enabled.
	 *
	 * @param userSkillses the user skillses
	 */
	public void cacheResult(List<UserSkills> userSkillses) {
		for (UserSkills userSkills : userSkillses) {
			if (EntityCacheUtil.getResult(
						UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
						UserSkillsImpl.class, userSkills.getPrimaryKey()) == null) {
				cacheResult(userSkills);
			}
			else {
				userSkills.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user skillses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserSkillsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserSkillsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user skills.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserSkills userSkills) {
		EntityCacheUtil.removeResult(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
			UserSkillsImpl.class, userSkills.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserSkills> userSkillses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserSkills userSkills : userSkillses) {
			EntityCacheUtil.removeResult(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
				UserSkillsImpl.class, userSkills.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user skills with the primary key. Does not add the user skills to the database.
	 *
	 * @param primId the primary key for the new user skills
	 * @return the new user skills
	 */
	public UserSkills create(long primId) {
		UserSkills userSkills = new UserSkillsImpl();

		userSkills.setNew(true);
		userSkills.setPrimaryKey(primId);

		return userSkills;
	}

	/**
	 * Removes the user skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primId the primary key of the user skills
	 * @return the user skills that was removed
	 * @throws com.tekniti.skilltransit.service.NoSuchUserSkillsException if a user skills with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSkills remove(long primId)
		throws NoSuchUserSkillsException, SystemException {
		return remove(Long.valueOf(primId));
	}

	/**
	 * Removes the user skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user skills
	 * @return the user skills that was removed
	 * @throws com.tekniti.skilltransit.service.NoSuchUserSkillsException if a user skills with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSkills remove(Serializable primaryKey)
		throws NoSuchUserSkillsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserSkills userSkills = (UserSkills)session.get(UserSkillsImpl.class,
					primaryKey);

			if (userSkills == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserSkillsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userSkills);
		}
		catch (NoSuchUserSkillsException nsee) {
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
	protected UserSkills removeImpl(UserSkills userSkills)
		throws SystemException {
		userSkills = toUnwrappedModel(userSkills);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, userSkills);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(userSkills);

		return userSkills;
	}

	@Override
	public UserSkills updateImpl(
		com.tekniti.skilltransit.service.model.UserSkills userSkills,
		boolean merge) throws SystemException {
		userSkills = toUnwrappedModel(userSkills);

		boolean isNew = userSkills.isNew();

		UserSkillsModelImpl userSkillsModelImpl = (UserSkillsModelImpl)userSkills;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userSkills, merge);

			userSkills.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserSkillsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userSkillsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userSkillsModelImpl.getOriginalUser_id())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(userSkillsModelImpl.getUser_id())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
			UserSkillsImpl.class, userSkills.getPrimaryKey(), userSkills);

		return userSkills;
	}

	protected UserSkills toUnwrappedModel(UserSkills userSkills) {
		if (userSkills instanceof UserSkillsImpl) {
			return userSkills;
		}

		UserSkillsImpl userSkillsImpl = new UserSkillsImpl();

		userSkillsImpl.setNew(userSkills.isNew());
		userSkillsImpl.setPrimaryKey(userSkills.getPrimaryKey());

		userSkillsImpl.setPrimId(userSkills.getPrimId());
		userSkillsImpl.setName(userSkills.getName());
		userSkillsImpl.setUser_id(userSkills.getUser_id());

		return userSkillsImpl;
	}

	/**
	 * Returns the user skills with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user skills
	 * @return the user skills
	 * @throws com.liferay.portal.NoSuchModelException if a user skills with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSkills findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the user skills with the primary key or throws a {@link com.tekniti.skilltransit.service.NoSuchUserSkillsException} if it could not be found.
	 *
	 * @param primId the primary key of the user skills
	 * @return the user skills
	 * @throws com.tekniti.skilltransit.service.NoSuchUserSkillsException if a user skills with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSkills findByPrimaryKey(long primId)
		throws NoSuchUserSkillsException, SystemException {
		UserSkills userSkills = fetchByPrimaryKey(primId);

		if (userSkills == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primId);
			}

			throw new NoSuchUserSkillsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primId);
		}

		return userSkills;
	}

	/**
	 * Returns the user skills with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user skills
	 * @return the user skills, or <code>null</code> if a user skills with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSkills fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the user skills with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primId the primary key of the user skills
	 * @return the user skills, or <code>null</code> if a user skills with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSkills fetchByPrimaryKey(long primId) throws SystemException {
		UserSkills userSkills = (UserSkills)EntityCacheUtil.getResult(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
				UserSkillsImpl.class, primId);

		if (userSkills == _nullUserSkills) {
			return null;
		}

		if (userSkills == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				userSkills = (UserSkills)session.get(UserSkillsImpl.class,
						Long.valueOf(primId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (userSkills != null) {
					cacheResult(userSkills);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UserSkillsModelImpl.ENTITY_CACHE_ENABLED,
						UserSkillsImpl.class, primId, _nullUserSkills);
				}

				closeSession(session);
			}
		}

		return userSkills;
	}

	/**
	 * Returns all the user skillses where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the matching user skillses
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserSkills> findByuserId(long user_id)
		throws SystemException {
		return findByuserId(user_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<UserSkills> findByuserId(long user_id, int start, int end)
		throws SystemException {
		return findByuserId(user_id, start, end, null);
	}

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
	public List<UserSkills> findByuserId(long user_id, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { user_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { user_id, start, end, orderByComparator };
		}

		List<UserSkills> list = (List<UserSkills>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserSkills userSkills : list) {
				if ((user_id != userSkills.getUser_id())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USERSKILLS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserSkillsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id);

				list = (List<UserSkills>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first user skills in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user skills
	 * @throws com.tekniti.skilltransit.service.NoSuchUserSkillsException if a matching user skills could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSkills findByuserId_First(long user_id,
		OrderByComparator orderByComparator)
		throws NoSuchUserSkillsException, SystemException {
		UserSkills userSkills = fetchByuserId_First(user_id, orderByComparator);

		if (userSkills != null) {
			return userSkills;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSkillsException(msg.toString());
	}

	/**
	 * Returns the first user skills in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user skills, or <code>null</code> if a matching user skills could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSkills fetchByuserId_First(long user_id,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserSkills> list = findByuserId(user_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user skills in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user skills
	 * @throws com.tekniti.skilltransit.service.NoSuchUserSkillsException if a matching user skills could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSkills findByuserId_Last(long user_id,
		OrderByComparator orderByComparator)
		throws NoSuchUserSkillsException, SystemException {
		UserSkills userSkills = fetchByuserId_Last(user_id, orderByComparator);

		if (userSkills != null) {
			return userSkills;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSkillsException(msg.toString());
	}

	/**
	 * Returns the last user skills in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user skills, or <code>null</code> if a matching user skills could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSkills fetchByuserId_Last(long user_id,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(user_id);

		List<UserSkills> list = findByuserId(user_id, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public UserSkills[] findByuserId_PrevAndNext(long primId, long user_id,
		OrderByComparator orderByComparator)
		throws NoSuchUserSkillsException, SystemException {
		UserSkills userSkills = findByPrimaryKey(primId);

		Session session = null;

		try {
			session = openSession();

			UserSkills[] array = new UserSkillsImpl[3];

			array[0] = getByuserId_PrevAndNext(session, userSkills, user_id,
					orderByComparator, true);

			array[1] = userSkills;

			array[2] = getByuserId_PrevAndNext(session, userSkills, user_id,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserSkills getByuserId_PrevAndNext(Session session,
		UserSkills userSkills, long user_id,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERSKILLS_WHERE);

		query.append(_FINDER_COLUMN_USERID_USER_ID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(UserSkillsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(user_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userSkills);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserSkills> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the user skillses.
	 *
	 * @return the user skillses
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserSkills> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<UserSkills> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<UserSkills> findAll(int start, int end,
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

		List<UserSkills> list = (List<UserSkills>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERSKILLS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERSKILLS.concat(UserSkillsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UserSkills>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UserSkills>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user skillses where user_id = &#63; from the database.
	 *
	 * @param user_id the user_id
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByuserId(long user_id) throws SystemException {
		for (UserSkills userSkills : findByuserId(user_id)) {
			remove(userSkills);
		}
	}

	/**
	 * Removes all the user skillses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UserSkills userSkills : findAll()) {
			remove(userSkills);
		}
	}

	/**
	 * Returns the number of user skillses where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the number of matching user skillses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByuserId(long user_id) throws SystemException {
		Object[] finderArgs = new Object[] { user_id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERSKILLS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of user skillses.
	 *
	 * @return the number of user skillses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERSKILLS);

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
	 * Initializes the user skills persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tekniti.skilltransit.service.model.UserSkills")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserSkills>> listenersList = new ArrayList<ModelListener<UserSkills>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<UserSkills>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserSkillsImpl.class.getName());
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
	private static final String _SQL_SELECT_USERSKILLS = "SELECT userSkills FROM UserSkills userSkills";
	private static final String _SQL_SELECT_USERSKILLS_WHERE = "SELECT userSkills FROM UserSkills userSkills WHERE ";
	private static final String _SQL_COUNT_USERSKILLS = "SELECT COUNT(userSkills) FROM UserSkills userSkills";
	private static final String _SQL_COUNT_USERSKILLS_WHERE = "SELECT COUNT(userSkills) FROM UserSkills userSkills WHERE ";
	private static final String _FINDER_COLUMN_USERID_USER_ID_2 = "userSkills.user_id = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userSkills.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserSkills exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserSkills exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserSkillsPersistenceImpl.class);
	private static UserSkills _nullUserSkills = new UserSkillsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserSkills> toCacheModel() {
				return _nullUserSkillsCacheModel;
			}
		};

	private static CacheModel<UserSkills> _nullUserSkillsCacheModel = new CacheModel<UserSkills>() {
			public UserSkills toEntityModel() {
				return _nullUserSkills;
			}
		};
}