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

import com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException;
import com.tekniti.skilltransit.service.model.SkillSubCategory;
import com.tekniti.skilltransit.service.model.impl.SkillSubCategoryImpl;
import com.tekniti.skilltransit.service.model.impl.SkillSubCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the skill sub category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hari
 * @see SkillSubCategoryPersistence
 * @see SkillSubCategoryUtil
 * @generated
 */
public class SkillSubCategoryPersistenceImpl extends BasePersistenceImpl<SkillSubCategory>
	implements SkillSubCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SkillSubCategoryUtil} to access the skill sub category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SkillSubCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SkillSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillSubCategoryModelImpl.FINDER_CACHE_ENABLED,
			SkillSubCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SkillSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillSubCategoryModelImpl.FINDER_CACHE_ENABLED,
			SkillSubCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SkillSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillSubCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the skill sub category in the entity cache if it is enabled.
	 *
	 * @param skillSubCategory the skill sub category
	 */
	public void cacheResult(SkillSubCategory skillSubCategory) {
		EntityCacheUtil.putResult(SkillSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillSubCategoryImpl.class, skillSubCategory.getPrimaryKey(),
			skillSubCategory);

		skillSubCategory.resetOriginalValues();
	}

	/**
	 * Caches the skill sub categories in the entity cache if it is enabled.
	 *
	 * @param skillSubCategories the skill sub categories
	 */
	public void cacheResult(List<SkillSubCategory> skillSubCategories) {
		for (SkillSubCategory skillSubCategory : skillSubCategories) {
			if (EntityCacheUtil.getResult(
						SkillSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
						SkillSubCategoryImpl.class,
						skillSubCategory.getPrimaryKey()) == null) {
				cacheResult(skillSubCategory);
			}
			else {
				skillSubCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all skill sub categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SkillSubCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SkillSubCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the skill sub category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SkillSubCategory skillSubCategory) {
		EntityCacheUtil.removeResult(SkillSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillSubCategoryImpl.class, skillSubCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SkillSubCategory> skillSubCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SkillSubCategory skillSubCategory : skillSubCategories) {
			EntityCacheUtil.removeResult(SkillSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
				SkillSubCategoryImpl.class, skillSubCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new skill sub category with the primary key. Does not add the skill sub category to the database.
	 *
	 * @param primaryId the primary key for the new skill sub category
	 * @return the new skill sub category
	 */
	public SkillSubCategory create(long primaryId) {
		SkillSubCategory skillSubCategory = new SkillSubCategoryImpl();

		skillSubCategory.setNew(true);
		skillSubCategory.setPrimaryKey(primaryId);

		return skillSubCategory;
	}

	/**
	 * Removes the skill sub category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryId the primary key of the skill sub category
	 * @return the skill sub category that was removed
	 * @throws com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException if a skill sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SkillSubCategory remove(long primaryId)
		throws NoSuchSkillSubCategoryException, SystemException {
		return remove(Long.valueOf(primaryId));
	}

	/**
	 * Removes the skill sub category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the skill sub category
	 * @return the skill sub category that was removed
	 * @throws com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException if a skill sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkillSubCategory remove(Serializable primaryKey)
		throws NoSuchSkillSubCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SkillSubCategory skillSubCategory = (SkillSubCategory)session.get(SkillSubCategoryImpl.class,
					primaryKey);

			if (skillSubCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSkillSubCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(skillSubCategory);
		}
		catch (NoSuchSkillSubCategoryException nsee) {
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
	protected SkillSubCategory removeImpl(SkillSubCategory skillSubCategory)
		throws SystemException {
		skillSubCategory = toUnwrappedModel(skillSubCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, skillSubCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(skillSubCategory);

		return skillSubCategory;
	}

	@Override
	public SkillSubCategory updateImpl(
		com.tekniti.skilltransit.service.model.SkillSubCategory skillSubCategory,
		boolean merge) throws SystemException {
		skillSubCategory = toUnwrappedModel(skillSubCategory);

		boolean isNew = skillSubCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, skillSubCategory, merge);

			skillSubCategory.setNew(false);
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

		EntityCacheUtil.putResult(SkillSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SkillSubCategoryImpl.class, skillSubCategory.getPrimaryKey(),
			skillSubCategory);

		return skillSubCategory;
	}

	protected SkillSubCategory toUnwrappedModel(
		SkillSubCategory skillSubCategory) {
		if (skillSubCategory instanceof SkillSubCategoryImpl) {
			return skillSubCategory;
		}

		SkillSubCategoryImpl skillSubCategoryImpl = new SkillSubCategoryImpl();

		skillSubCategoryImpl.setNew(skillSubCategory.isNew());
		skillSubCategoryImpl.setPrimaryKey(skillSubCategory.getPrimaryKey());

		skillSubCategoryImpl.setPrimaryId(skillSubCategory.getPrimaryId());
		skillSubCategoryImpl.setName(skillSubCategory.getName());

		return skillSubCategoryImpl;
	}

	/**
	 * Returns the skill sub category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill sub category
	 * @return the skill sub category
	 * @throws com.liferay.portal.NoSuchModelException if a skill sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkillSubCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the skill sub category with the primary key or throws a {@link com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException} if it could not be found.
	 *
	 * @param primaryId the primary key of the skill sub category
	 * @return the skill sub category
	 * @throws com.tekniti.skilltransit.service.NoSuchSkillSubCategoryException if a skill sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SkillSubCategory findByPrimaryKey(long primaryId)
		throws NoSuchSkillSubCategoryException, SystemException {
		SkillSubCategory skillSubCategory = fetchByPrimaryKey(primaryId);

		if (skillSubCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryId);
			}

			throw new NoSuchSkillSubCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryId);
		}

		return skillSubCategory;
	}

	/**
	 * Returns the skill sub category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill sub category
	 * @return the skill sub category, or <code>null</code> if a skill sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkillSubCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the skill sub category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryId the primary key of the skill sub category
	 * @return the skill sub category, or <code>null</code> if a skill sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SkillSubCategory fetchByPrimaryKey(long primaryId)
		throws SystemException {
		SkillSubCategory skillSubCategory = (SkillSubCategory)EntityCacheUtil.getResult(SkillSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
				SkillSubCategoryImpl.class, primaryId);

		if (skillSubCategory == _nullSkillSubCategory) {
			return null;
		}

		if (skillSubCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				skillSubCategory = (SkillSubCategory)session.get(SkillSubCategoryImpl.class,
						Long.valueOf(primaryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (skillSubCategory != null) {
					cacheResult(skillSubCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SkillSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
						SkillSubCategoryImpl.class, primaryId,
						_nullSkillSubCategory);
				}

				closeSession(session);
			}
		}

		return skillSubCategory;
	}

	/**
	 * Returns all the skill sub categories.
	 *
	 * @return the skill sub categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<SkillSubCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SkillSubCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the skill sub categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of skill sub categories
	 * @param end the upper bound of the range of skill sub categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of skill sub categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<SkillSubCategory> findAll(int start, int end,
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

		List<SkillSubCategory> list = (List<SkillSubCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SKILLSUBCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKILLSUBCATEGORY.concat(SkillSubCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SkillSubCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SkillSubCategory>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the skill sub categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SkillSubCategory skillSubCategory : findAll()) {
			remove(skillSubCategory);
		}
	}

	/**
	 * Returns the number of skill sub categories.
	 *
	 * @return the number of skill sub categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SKILLSUBCATEGORY);

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
	 * Initializes the skill sub category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tekniti.skilltransit.service.model.SkillSubCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SkillSubCategory>> listenersList = new ArrayList<ModelListener<SkillSubCategory>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<SkillSubCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SkillSubCategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_SKILLSUBCATEGORY = "SELECT skillSubCategory FROM SkillSubCategory skillSubCategory";
	private static final String _SQL_COUNT_SKILLSUBCATEGORY = "SELECT COUNT(skillSubCategory) FROM SkillSubCategory skillSubCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skillSubCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SkillSubCategory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SkillSubCategoryPersistenceImpl.class);
	private static SkillSubCategory _nullSkillSubCategory = new SkillSubCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SkillSubCategory> toCacheModel() {
				return _nullSkillSubCategoryCacheModel;
			}
		};

	private static CacheModel<SkillSubCategory> _nullSkillSubCategoryCacheModel = new CacheModel<SkillSubCategory>() {
			public SkillSubCategory toEntityModel() {
				return _nullSkillSubCategory;
			}
		};
}