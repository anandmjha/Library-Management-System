<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title></title>
<link rel="stylesheet" href="formstyle.css">
</head>
<c:if test="${member == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
<body background="lib.jpg">
<h1><marquee bgcolor="#997300">Welcome To Library Management System</marquee></h1>

<form style="position:fixed;" action="MemberController" method="post" target="_top">
<input type="submit" Name="action" value="Logout" style="background-color: #ffffff"/>
</form>

</body>
</c:if>
</html>