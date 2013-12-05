package org.tekniti.skilltransit.asset;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.tekniti.skilltransit.service.model.UserDetails;
import com.tekniti.skilltransit.service.service.UserDetailsLocalServiceUtil;

public class SkillAssetRendererFactory extends BaseAssetRendererFactory{
	 public static final String CLASS_NAME = UserDetails.class.getName();

	    public static final String TYPE = "skill";

	    public AssetRenderer getAssetRenderer(long classPK, int type)
	        throws PortalException, SystemException {

	    	UserDetails entry = UserDetailsLocalServiceUtil.getUserDetails(classPK);

	        return new SkillAssetRenderer(entry);
	    }

	    public AssetRenderer getAssetRenderer(long groupId, String urlTitle)
	        throws PortalException, SystemException {

	    	UserDetails entry = UserDetailsLocalServiceUtil.getUserDetails(groupId);

	        return new SkillAssetRenderer(entry);
	    }

	    public String getClassName() {
	        return CLASS_NAME;
	    }

	    public String getType() {
	        return TYPE;
	    }

	    public PortletURL getURLAdd(
	            LiferayPortletRequest liferayPortletRequest,
	            LiferayPortletResponse liferayPortletResponse)
	        throws PortalException, SystemException {

	        HttpServletRequest request =
	            liferayPortletRequest.getHttpServletRequest();

	        ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
	            WebKeys.THEME_DISPLAY);

	    

	        PortletURL portletURL = PortletURLFactoryUtil.create(
	            request, PortletKeys.BLOGS, getControlPanelPlid(themeDisplay),
	            PortletRequest.RENDER_PHASE);

	        portletURL.setParameter("struts_action", "/blogs/edit_entry");

	        return portletURL;
	    }

	    public boolean hasPermission(
	        PermissionChecker permissionChecker, long classPK, String actionId)
	        throws Exception {

	        return true;
	    }

	    protected String getIconPath(ThemeDisplay themeDisplay) {
	        return themeDisplay.getPathThemeImages() + "/blogs/blogs.png";
	    }
}
