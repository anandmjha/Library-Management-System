<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link rel="stylesheet" href="formstyle.css">
<script type="text/javascript">
	function validate() {
		if (document.Bookform.accessionNo.value != "") {
			return true;
		} else
			document.getElementById('y').innerHTML = "All field Required";
		return false;
	}
</script>
</head>
<c:if test="${member == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
	<body bgcolor="wheat">
		<h5 align="center">
			<c:if test="${not empty msg}">
				<c:out value="${msg}" />
			</c:if>
		</h5>
		<h3 align="center">Add Book</h3>
		<div align="center" id="y"></div>
		<form action="BookController" method="post" name="Bookform">
			<input type="text" name="accessionNo" placeholder="Accession No" />
			<input type="text" name="title" placeholder="Title" /> <input
				type="text" name="author" placeholder="Author" /> <br /> <br /> <input
				type="submit" name="action" value="Add" style="width: 100px;">
		</form>
</c:if>
</body>
</html>