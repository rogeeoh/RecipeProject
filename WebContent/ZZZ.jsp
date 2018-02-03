<%@page import="java.util.ArrayList"%>
<%@ page contentType="json; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<HTML>
<head>
</head>
<%
ArrayList<String> arList = new ArrayList();
arList.add("one");
arList.add("two");
arList.add("three");
request.setAttribute("list", arList);
%>
<body>
 <c:forEach items="${list}" var="i" varStatus="status">
 	${i}, ${status.count}<br>
 </c:forEach >
</body>
</HTML>