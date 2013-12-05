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

import com.tekniti.skilltransit.service.NoSuchSkillCategoryException;
import com.tekniti.skilltransit.service.model.SkillCategory;
import com.tekniti.skilltransit.service.model.impl.SkillCategoryImpl;
import com.tekniti.skilltransit.service.model.impl.SkillCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the skill category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hari
 * @see SkillCategoryPersistence
 * @see SkillCategoryUtil
 * @generated
 */
public class SkillCategoryPersistenceImpl extends BasePersistenceImpl<SkillCategory>
	implements SkillCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SkillCategoryUtil} to access the skill category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SkillCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SkillCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillCategoryModelImpl.FINDER_CACHE_ENABLED,
			SkillCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SkillCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillCategoryModelImpl.FINDER_CACHE_ENABLED,
			SkillCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SkillCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the skill category in the entity cache if it is enabled.
	 *
	 * @param skillCategory the skill category
	 */
	public void cacheResult(SkillCategory skillCategory) {
		EntityCacheUtil.putResult(SkillCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillCategoryImpl.class, skillCategory.getPrimaryKey(),
			skillCategory);

		skillCategory.resetOriginalValues();
	}

	/**
	 * Caches the skill categories in the entity cache if it is enabled.
	 *
	 * @param skillCategories the skill categories
	 */
	public void cacheResult(List<SkillCategory> skillCategories) {
		for (SkillCategory skillCategory : skillCategories) {
			if (EntityCacheUtil.getResult(
						SkillCategoryModelImpl.ENTITY_CACHE_ENABLED,
						SkillCategoryImpl.class, skillCategory.getPrimaryKey()) == null) {
				cacheResult(skillCategory);
			}
			else {
				skillCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all skill categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SkillCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SkillCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the skill category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SkillCategory skillCategory) {
		EntityCacheUtil.removeResult(SkillCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillCategoryImpl.class, skillCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SkillCategory> skillCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SkillCategory skillCategory : skillCategories) {
			EntityCacheUtil.removeResult(SkillCategoryModelImpl.ENTITY_CACHE_ENABLED,
				SkillCategoryImpl.class, skillCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new skill category with the primary key. Does not add the skill category to the database.
	 *
	 * @param primaryId the primary key for the new skill category
	 * @return the new skill category
	 */
	public SkillCategory create(long primaryId) {
		SkillCategory skillCategory = new SkillCategoryImpl();

		skillCategory.setNew(true);
		skillCategory.setPrimaryKey(primaryId);

		return skillCategory;
	}

	/**
	 * Removes the skill category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryId the primary key of the skill category
	 * @return the skill category that was removed
	 * @throws com.tekniti.skilltransit.service.NoSuchSkillCategoryException if a skill category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SkillCategory remove(long primaryId)
		throws NoSuchSkillCategoryException, SystemException {
		return remove(Long.valueOf(primaryId));
	}

	/**
	 * Removes the skill category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the skill category
	 * @return the skill category that was removed
	 * @throws com.tekniti.skilltransit.service.NoSuchSkillCategoryException if a skill category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkillCategory remove(Serializable primaryKey)
		throws NoSuchSkillCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SkillCategory skillCategory = (SkillCategory)session.get(SkillCategoryImpl.class,
					primaryKey);

			if (skillCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSkillCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(skillCategory);
		}
		catch (NoSuchSkillCategoryException nsee) {
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
	protected SkillCategory removeImpl(SkillCategory skillCategory)
		throws SystemException {
		skillCategory = toUnwrappedModel(skillCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, skillCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(skillCategory);

		return skillCategory;
	}

	@Override
	public SkillCategory updateImpl(
		com.tekniti.skilltransit.service.model.SkillCategory skillCategory,
		boolean merge) throws SystemException {
		skillCategory = toUnwrappedModel(skillCategory);

		boolean isNew = skillCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, skillCategory, merge);

			skillCategory.setNew(false);
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

		EntityCacheUtil.putResult(SkillCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillCategoryImpl.class, skillCategory.getPrimaryKey(),
			skillCategory);

		return skillCategory;
	}

	protected SkillCategory toUnwrappedModel(SkillCategory skillCategory) {
		if (skillCategory instanceof SkillCategoryImpl) {
			return skillCategory;
		}

		SkillCategoryImpl skillCategoryImpl = new SkillCategoryImpl();

		skillCategoryImpl.setNew(skillCategory.isNew());
		skillCategoryImpl.setPrimaryKey(skillCategory.getPrimaryKey());

		skillCategoryImpl.setPrimaryId(skillCategory.getPrimaryId());
		skillCategoryImpl.setName(skillCategory.getName());

		return skillCategoryImpl;
	}

	/**
	 * Returns the skill category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill category
	 * @return the skill category
	 * @throws com.liferay.portal.NoSuchModelException if a skill category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkillCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the skill category with the primary key or throws a {@link com.tekniti.skilltransit.service.NoSuchSkillCategoryException} if it could not be found.
	 *
	 * @param primaryId the primary key of the skill category
	 * @return the skill category
	 * @throws com.tekniti.skilltransit.service.NoSuchSkillCategoryException if a skill category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SkillCategory findByPrimaryKey(long primaryId)
		throws NoSuchSkillCategoryException, SystemException {
		SkillCategory skillCategory = fetchByPrimaryKey(primaryId);

		if (skillCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryId);
			}

			throw new NoSuchSkillCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryId);
		}

		return skillCategory;
	}

	/**
	 * Returns the skill category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill category
	 * @return the skill category, or <code>null</code> if a skill category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkillCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the skill category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryId the primary key of the skill category
	 * @return the skill category, or <code>null</code> if a skill category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SkillCategory fetchByPrimaryKey(long primaryId)
		throws SystemException {
		SkillCategory skillCategory = (SkillCategory)EntityCacheUtil.getResult(SkillCategoryModelImpl.ENTITY_CACHE_ENABLED,
				SkillCategoryImpl.class, primaryId);

		if (skillCategory == _nullSkillCategory) {
			return null;
		}

		if (skillCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				skillCategory = (SkillCategory)session.get(SkillCategoryImpl.class,
						Long.valueOf(primaryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (skillCategory != null) {
					cacheResult(skillCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SkillCategoryModelImpl.ENTITY_CACHE_ENABLED,
						SkillCategoryImpl.class, primaryId, _nullSkillCategory);
				}

				closeSession(session);
			}
		}

		return skillCategory;
	}

	/**
	 * Returns all the skill categories.
	 *
	 * @return the skill categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<SkillCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the skill categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of skill categories
	 * @param end the upper bound of the range of skill categories (not inclusive)
	 * @return the range of skill categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<SkillCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the skill categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of skill categories
	 * @param end the upper bound of the range of skill categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of skill categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<SkillCategory> findAll(int start, int end,
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

		List<SkillCategory> list = (List<SkillCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SKILLCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKILLCATEGORY.concat(SkillCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SkillCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SkillCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the skill categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SkillCategory skillCategory : findAll()) {
			remove(skillCategory);
		}
	}

	/**
	 * Returns the number of skill categories.
	 *
	 * @return the number of skill categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SKILLCATEGORY);

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
	 * Initializes the skill category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tekniti.skilltransit.service.model.SkillCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SkillCategory>> listenersList = new ArrayList<ModelListener<SkillCategory>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<SkillCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SkillCategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_SKILLCATEGORY = "SELECT skillCategory FROM SkillCategory skillCategory";
	private static final String _SQL_COUNT_SKILLCATEGORY = "SELECT COUNT(skillCategory) FROM SkillCategory skillCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skillCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SkillCategory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SkillCategoryPersistenceImpl.class);
	private static SkillCategory _nullSkillCategory = new SkillCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SkillCategory> toCacheModel() {
				return _nullSkillCategoryCacheModel;
			}
		};

	private static CacheModel<SkillCategory> _nullSkillCategoryCacheModel = new CacheModel<SkillCategory>() {
			public SkillCategory toEntityModel() {
				return _nullSkillCategory;
			}
		};
}