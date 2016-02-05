<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="reg" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<div class="searchresults" data-idea-search-data="${ideaSearchData}">
<div class="nosearchresults">
<c:choose>
<c:when test="${ideaSearchData.size() gt 0}">
<span>Showing Results For "${fn:escapeXml(searchTerm)}"</span><br>
<span>${ideaSearchData.size()} Results </span>
</c:when>
<c:otherwise>
<c:if test="${not empty searchTerm}">
<span>No Search Results For "${searchTerm}" </span>
</c:if>
</c:otherwise>
</c:choose>
</div>
<c:forEach items="${ideaSearchData}" var="ideaData">
<div class="singlesearchresult">
<div class="singleideadiv"><a style="font-family: sans-serif;font-size: 19px;text-transform: capitalize;" href="/ideaview?iuid=${ideaData.id}">${ideaData.idea}</a><br>
${ideaData.ideaQuestion}
</div> 
<div class="singleuserfldiv">${ideaData.firstName}&nbsp;${ideaData.lastName}</div>
</div>
</c:forEach>
</div>
</html>