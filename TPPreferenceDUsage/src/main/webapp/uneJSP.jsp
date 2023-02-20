<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	String couleur="noir";
	if(session.getAttribute("couleurPref")!=null)
	{
		couleur=(String)session.getAttribute("couleurPref");
	}
%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/<%=couleur%>.css">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>une JSP</title>
</head>
<body>
	<p>Avec du contenu</p>
	<a href="<%=response.encodeURL(request.getContextPath()+"/accueil")%>">Retour</a>
</body>
</html>