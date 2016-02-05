<%@page import="com.learining.data.RegisterFormData"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="reg" tagdir="/WEB-INF/tags" %>
<html>
<%
HttpSession sessionsa = request.getSession(false);
RegisterFormData currentUser = (RegisterFormData)sessionsa.getAttribute("currentUser");
%>
<div class="headerbar">
<img class="logoimage" title="Kelo" alt="Kelo" src="resources/data/images/pai.PNG">


<div class="useraccountdiv">
<c:choose>
<c:when test="${not empty currentUser}">

<span class="accounticonbutton"><img class="accounticonimg" alt="" src="resources/data/images/accounticon.png"/>&nbsp;<label class="username">${currentUser.firstName}</label></span>
<span class="useraccountdropdown" style="display: none;" data-display-name="Account" data-link-ref="/account"></span>
<span class="useraccountdropdown" style="display: none;" data-display-name="My Questions" data-link-ref="/myquestions"></span>
<span class="useraccountdropdown" style="display: none;" data-display-name="logout" data-link-ref="/logout"></span>
<div id="singledropdownelement" style="display: none;"></div>

</c:when>
<c:otherwise>
<span class="textblue my_popup_open reglogin" id="register" >&emsp;SignUp</span>&nbsp;|&nbsp;
<span class="login_popup_open reglogin" id="headerlogin">Login</span>
<div class="popup_div" id="my_popup" style="display: none;">
<reg:register/>
 </div>
 <div class="popup_div" id="login_popup" style="display: none;">
<reg:login/>
 </div>
</c:otherwise>
</c:choose>
</div>
</div>
<div class="hiddensearch"><input type="text" name="searchterm" id="searchbar" placeholder="Search an Idea"><a href="#"><img id="searchbutton" title="Search" alt="Search" src="resources/data/images/searchicon.jpg"></a></div>
<div class="overlay" style="display: none;"></div>
</html>