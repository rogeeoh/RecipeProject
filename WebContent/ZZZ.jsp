<%@page import="model.dao.MemberDao"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% String email = request.getParameter("email");
	boolean isUnique = new MemberDao().isUniqueEmail(email);
	if(isUnique)
		out.println("true");
	else
		out.println("false");
%>