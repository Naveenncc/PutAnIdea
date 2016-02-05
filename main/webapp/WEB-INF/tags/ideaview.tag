<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="reg" tagdir="/WEB-INF/tags" %>
<html>
<div class="mainideaviewbody">
<div class="ideaviewdisplay">
<div class="ideaviewheader"></div>
<div class="ideaviewheading">
<span>${ideaData.ideaHeading}</span>
</div>
<div class="ideaviewquestion">
<span>${ideaData.idea}</span>
</div>
</div>
<br><br>

<c:if test="${not empty suggestionDataList}">
<div class="suggestionviewdisplay">
<span>Suggestions</span>
<c:forEach items="${suggestionDataList}" var="suggestionData">
<div class="singleideaviewsuggestion">
<div class="singlesuggestiontext">${suggestionData.suggestion}<br>
</div> 
<div class="singlesuggestionfldiv">${suggestionData.firstName}&nbsp;${suggestionData.lastName}</div>
</div>
</c:forEach>
</div>
</c:if>
<div class="addsuggestion">
<div class="addsuggestionheading">Your Suggestion</div>
<textarea rows="8" cols="75" form="suggestionform" name="suggestion" id="suggesttextarea"></textarea>
<div class="suggestiontextboxsizediv"><span id="countsuggestiontext">900</span><span> characters left</span></div>
<form action="/addsuggestion" id="suggestionform" method="post">
<input type="hidden" name="iuid" value="${ideaData.iUid}">
<input type="hidden" name="sugUser" value="${currentUser.email}">
<br><button class="submit-button suggestionsubmit">Submit</button>
</form>
</div>
</div>
</html>