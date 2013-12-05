package org.tekniti.skilltransit.indexer;

import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.tekniti.skilltransit.service.model.UserDetails;
import com.tekniti.skilltransit.service.service.UserDetailsLocalServiceUtil;

public class SkillIndexer extends BaseIndexer{
	private static Log _log = LogFactoryUtil.getLog(SkillIndexer.class);
	public static final String[] CLASS_NAMES = { UserDetails.class.getName() };
	public static final String PORTLET_ID = "SkillTransit_WAR_SkillTransitportle";
	long companyId=PortalUtil.getDefaultCompanyId();
	
	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		UserDetails userSkills = (UserDetails) obj;
		
		try {
			deleteDocument(companyId, userSkills.getUserId());
		} catch (Exception e) {
			_log.error("error rendering search request ", e.getCause());
		}
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		System.out.println("inside indexer");
		UserDetails entry = (UserDetails)obj;

		Document document = getBaseModelDocument(PORTLET_ID, entry);
		document.addText(
			Field.CONTENT, HtmlUtil.extractText(entry.getSkill()));
		document.addText("hourlyRate", entry.getHourlyRate());
		document.addText("zipCode", entry.getZipCode());
		document.addText("userId", String.valueOf(entry.getUserId()));
		document.addText("category", entry.getCategory());
		document.addText("state", entry.getState());
		System.out.println("entry.getSkill() is "+entry.getSkill() + " entry userId is "+entry.getUserId());
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		//TODO: Modify this. not sure how this can be useul field.
		String title = "dummyTitle";

		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = StringUtil.shorten(document.get(Field.CONTENT), 200);
		}

		String entryId = document.get(Field.ENTRY_CLASS_PK);

		portletURL.setParameter("struts_action", "/blogs/view_entry");
		portletURL.setParameter("entryId", entryId);

		return new Summary(title, content, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		UserDetails entry = (UserDetails)obj;

		Document document = getDocument(entry);

		SearchEngineUtil.updateDocument(
			getSearchEngineId(),companyId, document);
		
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		//TODO: Change how classPK can map to user id
		UserDetails entry = UserDetailsLocalServiceUtil.getUserDetails(classPK);
		doReindex(entry);
		
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		for(int i=0;i<ids.length;i++){
			long userId=Long.parseLong(ids[i]);
			UserDetails entry = UserDetailsLocalServiceUtil.getUserDetails(userId);
			doReindex(entry);
		}
		
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

}
