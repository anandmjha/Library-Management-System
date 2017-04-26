<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Book</title>
<link rel="stylesheet" href="formstyle.css">
</head>
<c:if test="${member == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
	<body bgcolor="wheat">
		<div id="y" align="center">
			<h3>
				<c:if test="${not empty msg}">
					<c:out value="${msg}" />
				</c:if>
			</h3>
		</div>
		<h1 align="center">Return Book</h1>
		<form action="BookController" method="post">
			<input type="text" name="memberId" placeholder="MemberId" /> <input
				type="text" name="accessionNo" placeholder="Book Id" /> <br /> <input
				type="submit" name="action" value="Return" style="width: 100px;">
		</form>
	</body>
</c:if>
</html>