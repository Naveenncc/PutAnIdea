<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="reg" tagdir="/WEB-INF/tags" %>
<html>
<div class="popup_heading">
<div class="table">
<form id="userForm" action="/userLogin" method="post">

<table>
<tr>
<td>
<span class="text-cursive">UserName :</span>
</td>
<td>
<input type="text" name="userName" placeholder="USERNAME" required="required">
</td>
</tr>
<tr>
<td>
<span class="text-cursive">PassWord :</span>
</td>
<td>
<input type="password" name="passWord" placeholder="PASSWORD" required="required"><br>
</td>

</tr>
<tr>
<td>
</td>
<td>
<button class="submit-button " id="loginbutton">Submit</button>
</td>
</tr>
</table>
<a class="textblue" href="#"><br>Forgot your Password?</a>
<div class="error invaliduserpass" style="display: none;">Enter valid Username/Password<br></div>
</form>
</div>
</div>
</html>