<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet" href="formstyle.css">
<script type="text/javascript">
function onsubmitter(){
	document.forms.changepassform.submit();
	document.getElementById('y').innerHTML="Password Changed";
}
</script>
</head>
<c:if test="${member == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
	<body bgcolor="wheat">
		<jsp:useBean id="mb" class="com.library.model.Member" scope="session" />
		<jsp:setProperty property="memberId" name="mb" value="${memberId}" />
		<jsp:setProperty property="password" name="mb" param="pass" />
		<h1 align="center"> <div id="y"> </div> </h1>
		<h1 align="center">Change Password</h1>
		<form name="changepassform" onsubmit="${mb.changePassword}">
			<input type="text" name="pass" placeholder="New Password" /> <input
				type="submit" value="Submit" style="width: 100px;" onclick="onsubmitter()"/>
		</form>
	</body>
</c:if>
</html>