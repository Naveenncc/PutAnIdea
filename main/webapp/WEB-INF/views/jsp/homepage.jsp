<%@ taglib prefix="reg" tagdir="/WEB-INF/tags" %>
<html>
<%@ include file="header.jsp" %>
<head>
<title>Login</title>
<LINK href="resources/css/main.css" rel="stylesheet" type="text/css">
</head>
<body class="backlayout">
<div class="mainlayout">
<div class="leftnavigation">
<reg:leftnav/>
</div>
<div class="homepagebody">

<!-- carousel start -->
<div class="flexslidercustom">
<div class="flexslider">
  <ul class="slides">
    <li>
      <img style="height: 300px;" src="resources/data/carousel/carousel1.jpg" />
    </li>
    <li>
      <img style="height: 300px;" src="resources/data/carousel/carousel2.jpg" />
    </li>
    <li>
      <img style="height: 300px;" src="resources/data/carousel/carousel3.jpg" />
    </li>
    <li>
      <img style="height: 300px;" src="resources/data/carousel/carousel5.jpg" />
    </li>
    <li>
      <img style="height: 300px;" src="resources/data/carousel/carousel6.jpg" />
    </li>
    <li>
      <img style="height: 300px;" src="resources/data/carousel/carousel7.jpg" />
    </li>
    <li>
      <img style="height: 300px;" src="resources/data/carousel/carousel9.jpg" />
    </li>
    <li>
      <img style="height: 300px;" src="resources/data/carousel/carousel10.jpg" />
    </li>
    <li>
      <img style="height: 300px;" src="resources/data/carousel/carousel11.jpg" />
    </li>
    <li>
      <img style="height: 300px;" src="resources/data/carousel/carousel4.jpg" />
    </li>
    <!-- items mirrored twice, total of 12 -->
  </ul>
</div>
</div>

<!-- carousel end -->

<reg:searchresult/>
</div>
<div class="extenddown" style="clear:both;"></div>
</div>
</body>
<%@ include file="footer.jsp" %>
<link rel="stylesheet" href="resources/css/flexslider.css">
<script type="text/javascript" src="resources/js/jquery.flexslider.js"></script>
</html>