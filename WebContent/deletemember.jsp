<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Member</title>
<link rel="stylesheet" href="formstyle.css">
</head>
<c:if test="${member == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
	<body bgcolor="wheat">
		<h1 align="center">Delete Member</h1>
		<form action="MemberController" method="post" name="Memberform">

			<input type="text" name="memberId" placeholder="Member Id" /> <br />
			<br /> <input type="submit" name="action" value="DeleteMember"
				style="width: 100px;">
			<div id="y"></div>
		</form>
	</body>
</c:if>
</html>