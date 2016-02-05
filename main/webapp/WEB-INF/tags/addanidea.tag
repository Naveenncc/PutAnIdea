<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="reg" tagdir="/WEB-INF/tags" %>
<html>
<div>
<div class="addanideaheading">
<span class="textheadinggen">Idea Heading</span><br><br>
<textarea rows="4" cols="90" name="ideaHeading" form="addidea" id="addanideaheadingtextarea"></textarea>
<div class="addanideaheadingtextboxsizediv"><span id="countaddanideaheadingtext">400</span><span> characters left</span></div>
</div>

<div class="addanideabody">
<span class="textheadinggen">Idea Body</span><br><br>
<textarea rows="8" cols="90" name="idea" form="addidea" id="addanideatextarea"></textarea>
<div class="addanideatextboxsizediv"><span id="countaddanidetext">900</span><span> characters left</span></div>
</div>
<form action="/addanidea" id="addidea" method="post">
<div class="selectcategorydiv">	
<select id="selectcategoryid" class="selectcategoryselect" name="category">
<option value="select">Select Category</option>
  <option value="science">Science</option>
  <option value="technology">Technology</option>
  <option value="politics">Politics</option>
  <option value="entertainment">Entertainment</option>
  <option value="others">Others</option>
</select>
<div class="error selecterror" style="display:none;">Please select a category</div>
<div class="error ideaheadingerror" style="display:none;">Idea Heading should be atleast 20 characters</div>
<div class="error ideabodyerror" style="display:none;">Idea Body should be atleast 20 characters</div>
</div>
<br><button class="submit-button addanideasubmit" id="addanideasubmit">Submit</button>
</form>
</div>
</html>