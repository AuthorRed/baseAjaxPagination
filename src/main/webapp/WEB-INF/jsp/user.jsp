<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<thead>
<td>id</td><td>name</td><td>date</td>
</thead>
<tbody>
<c:forEach items="${list}" var="user">
<tr>
<td>${user.id}</td><td>${user.name}</td><td>${user.date}</td>
</tr>
</c:forEach>


</tbody>
</table>
</body>
</html>