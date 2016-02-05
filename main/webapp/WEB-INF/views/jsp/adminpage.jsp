<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Login</title>
<LINK href="resources/css/main.css" rel="stylesheet" type="text/css">
</head>
<body class="backlayout">
<div class="mainlayout">
<h1>Welcome NAVEEN</h1>
<c:choose>
<c:when test="${empty successFlag}">
<form action="/adminindex">
<button class="adminbutton"> Index Ideas</button>
</form>
</c:when>
<c:otherwise>
<c:choose>
<c:when test="${successFlag eq true}">
<span>Indexing Successfull</span>
</c:when>
<c:otherwise>
<span>Error While indexing</span>
</c:otherwise>
</c:choose>
</c:otherwise>
</c:choose>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>