<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Book</title>
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
		<h1 align="center">Issue Book</h1>
		<form action="BookController" name="bookform" method="post">
			<input type="text" name="memberId" placeholder="Member Id" /> <input
				type="text" name="accessionNo" placeholder="Accession No" /> <input
				type="submit" name="action" value="Issue" style="width: 100px;">
		</form>
	</body>
</c:if>
</html>