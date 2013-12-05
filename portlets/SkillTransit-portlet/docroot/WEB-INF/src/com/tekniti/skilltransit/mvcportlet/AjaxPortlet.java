package com.tekniti.skilltransit.mvcportlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.tekniti.skilltransit.service.model.SkillSubCategory;
import com.tekniti.skilltransit.service.service.SkillSubCategoryLocalServiceUtil;

public class AjaxPortlet extends BaseMVCPortlet {

	private static Log _log = LogFactory.getLog(AjaxPortlet.class);
	
	public AjaxPortlet() {
		super();
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		// serve resource here
				System.out.println("inside serve resource" + request.getParameter("skill"));
				String search = StringUtils.trimToEmpty(request.getParameter("skill"));
				if (!search.isEmpty()) {
					try {
						List<SkillSubCategory> subCategoryList = SkillSubCategoryLocalServiceUtil
								.typeaheadSearch(search);
						JSONArray results = JSONFactoryUtil.createJSONArray();
						for (SkillSubCategory subcat : subCategoryList) {
							JSONObject listEntry = JSONFactoryUtil.createJSONObject();
							listEntry.put("categoryId", subcat.getPrimaryId());
							listEntry.put("search", subcat.getName());
							listEntry.put("empty", StringUtils.EMPTY);
							results.put(listEntry);
						}
						response.getPortletOutputStream().write(
								results.toString().getBytes());
					} catch (Exception e) {
						_log.error("error rendering search request ", e.getCause());
						throw new PortletException("search failed");
					}

				}

	}
}