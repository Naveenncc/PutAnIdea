<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="popup_heading">
<form action="/editprofileimagevalidation" method="post" enctype="multipart/form-data">
<span class="heading" id="editprofile">Edit Profile</span>
<table class="registertable">
<tr><td>
<span class="text-cursive register">FirstName  </span></td><td><input type="text" name="firstName" placeholder="${currentUser.firstName}" readonly="readonly"><br><span id="firstNameerror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">LastName  </span></td><td><input type="text" name="lastName" placeholder="${currentUser.lastName}" readonly="readonly"><br><span id="lastNameerror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">Email  </span></td><td><input type="text" name="email" placeholder="${currentUser.email}" value="${currentUser.email}" readonly="readonly"><br><span id="emailerror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">DOB  </span></td><td><input  type="date" name="date" placeholder="${currentUser.date}"><br><span id="dateerror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">Phone  </span></td><td><input type="tel" name="phone" placeholder="${currentUser.phone}"><span id="phoneerror" class="error smallerrorfont"></span></td></tr>
<tr><td>
<span class="text-cursive register">Profile pic</span><td><input name="profileimage" type="file"><span id="imageerror" class="error smallerrorfont"></span></td></tr>
<tr><td></td><td><button class="submit-button ">Register</button>
</table>
</form>
</div>