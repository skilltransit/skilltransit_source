package com.tekniti.skilltransit.mvcportlet;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class BaseMVCPortlet extends MVCPortlet {

	public BaseMVCPortlet() {
		super();
	}
	
	public RequestData getRequestData(PortletRequest request, PortletResponse response) throws PortletException {
		RequestData requestData = new RequestData();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		requestData.setThemeDisplay(themeDisplay);
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			requestData.setServiceContext(serviceContext);
		} catch (SystemException e) {
			throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
		
		requestData.setUser(themeDisplay.getUser());
		requestData.setGroupId(themeDisplay.getScopeGroupId());
		
		
		return requestData;
	}
	
	
	protected void setUpRenderAttributes(PortletRequest request, PortletResponse response) throws PortletException {
		RequestData requestData = getRequestData(request, response);
		request.setAttribute("requestData", requestData);
		
		User user = (User) requestData.getUser();
		request.setAttribute("user", user);
	}
	
	protected void hideMessage(ActionRequest actionRequest) {
		SessionMessages.add(actionRequest, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	
	/**
	 * A helper POJO with no business logic to allow quick and consistent 
	 * access to common objects on the request.
	 * 
	 * @author brett-shelton
	 *
	 */
	public class RequestData {
		private ThemeDisplay themeDisplay;
		private ServiceContext serviceContext;
		private User user;
		private long groupId;
		
		protected RequestData() {
			
		}

		public ThemeDisplay getThemeDisplay() {
			return themeDisplay;
		}

		public void setThemeDisplay(ThemeDisplay themeDisplay) {
			this.themeDisplay = themeDisplay;
		}

		public ServiceContext getServiceContext() {
			return serviceContext;
		}

		public void setServiceContext(ServiceContext serviceContext) {
			this.serviceContext = serviceContext;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		/**
		 * @return the ScopeGroupId for the request.
		 */
		public long getGroupId() {
			return groupId;
		}

		/**
		 * @param groupId is the ScopeGroupId for the request.
		 */
		public void setGroupId(long groupId) {
			this.groupId = groupId;
		}

	}
	
	protected void setHttpResponseCode(ResourceResponse resourceResponse,
			int httpResponseCode) {
		resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE,
				String.valueOf(httpResponseCode));
	}
}
