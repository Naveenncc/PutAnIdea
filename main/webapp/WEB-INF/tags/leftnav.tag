<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="reg" tagdir="/WEB-INF/tags" %>
<html>
<!-- <div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.4&appId=1659045071005937";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<script type="text/javascript" src="resources/js/loginapis.js"></script>
<div class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="true" data-auto-logout-link="true" scope="public_profile,email">
</div>

<div id="status">
</div> -->
<c:if test="${not empty currentUser}">
<div class="profileimagecontainer">
<img class="profileimage" title="${currentUser.firstName}" alt="${currentUser.firstName}" src="${currentUser.imagePath}">
</div>
<span class="editimage edit_popup_open reglogin">Edit profile </span>
<div class="popup_div" id="edit_popup" style="display: none;">
<reg:editregister/>
 </div>
<div class="addanidea">
<span class="addanidea_popup_open" style="font-family: sans-serif;">Add an Idea</span>
<div class="popup_div" id="addanidea_popup" style="display: none;">
<reg:addanidea/>
 </div>
</div>
</c:if>

</html>