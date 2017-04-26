<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>
Member Page
</title>
</head>
<c:if test="${member == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
<body bgcolor="#ffffcc">
<div align="center">
<h2>You are logged in as a member</h2>
<h3>
<a href="searchbook.jsp" target="f3">View Books </a> 
<br/><br/>
<a href="borrowedbook.jsp" target="f3">View Borrowed </a>
<br/><br/>
<a href="viewpersonaldetail.jsp" target="f3">Personal Details</a>
<br/><br/>
<a href="changepassword.jsp" target="f3">Change Password </a> 
<br/><br/>
</h3>
</div>
</body>
</c:if>
</html>