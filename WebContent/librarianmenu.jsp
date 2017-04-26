<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<c:if test="${member == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member!=null}">
<frameset rows="25%,75%" border="2">
	<frame src="title.jsp" name="f1" noresize="noresize" scrolling="no">
	<frameset cols="20%,80%" border="2">
		<frame src="librarianhome.jsp" name="f2" noresize="noresize">
		<frame src="base.jsp" name="f3" noresize="noresize">
	</frameset>
</frameset>
</c:if>
</head>
<body>
</body>
</html>








