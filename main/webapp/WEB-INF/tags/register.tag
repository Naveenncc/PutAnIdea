<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="popup_heading">
<form action="/register" method="post">
<span class="heading">Register</span>
<table class="registertable">
<tr><td>
<span class="text-cursive register">FirstName  </span></td><td><input type="text" name="firstName" required="required"><br><span id="firstNameerror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">LastName  </span></td><td><input type="text" name="lastName" required="required"><br><span id="lastNameerror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">Email  </span></td><td><input type="text" name="email" required="required"><br><span id="emailerror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">Password </span></td><td><input type="password" name="password" required="required"><br><span id="passworderror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">Confirm Password </span></td><td><input type="password" name="confirmPassword" required="required"><br><span id="confirmPassworderror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">DOB  </span></td><td><input  type="date" name="date" required="required"><br><span id="dateerror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">Phone  </span></td><td><input type="tel" name="phone"><span id="phoneerror" class="error smallerrorfont"></span></td></tr>
<tr><td></td><td><button class="submit-button registersubmit">Register</button>
</table>
</form>
</div>