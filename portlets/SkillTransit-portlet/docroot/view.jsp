<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<portlet:defineObjects />

This is the <b>Ajax Portlet</b> portlet in View mode.

<portlet:resourceURL var="searchUrl"/>
<aui:form action="${searchUrl }">
	<aui:input name="q" type="text"/>
	<aui:button type="submit" value="submit"/>
</aui:form>
