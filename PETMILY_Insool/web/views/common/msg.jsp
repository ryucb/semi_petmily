<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Msg</title>
</head>
<body>
	<script>
		alert("<%=request.getAttribute("msg")%>");
		location.replace("<%=request.getContextPath()%><%=request.getAttribute("loc")%>");
	</script>
</body>
</html>