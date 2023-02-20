<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<%
	String couleur="noir";
	if(session.getAttribute("couleurPref")!=null)
	{
		couleur=(String)session.getAttribute("couleurPref");
	}
%>

<title>Accueil</title>
</head>
<body class="container">
	<h1 class="text-center">ACCUEIL</h1>
	<form action="<%=request.getContextPath()%>/accueil" method="post">
		<div class="form-group row justify-content-center mt-5">
			<%
				List<String> couleurs = (List<String>)application.getAttribute("couleurs");
			%>
			<select name="couleurChoisie" class="form-control col-2">
				<%
				for(String couleurDisponible:couleurs)
				{
				%>
					<option value="<%=couleurDisponible%>" <%=couleurDisponible.equalsIgnoreCase(couleur)?"selected":""%>><%=couleurDisponible%></option>
				<%
				}
				%>
			</select>
			<button type="submit" class="btn btn-outline-success offset-1">Valider</button>
		</div>
	</form>
	<div class="row justify-content-center mt-5">
		<%
		Cookie cookieNbAcCookie = (Cookie)request.getAttribute("cookieNbAcces");
		%>
		<p>Vous êtes venu <%=cookieNbAcCookie.getValue()%> fois</p>
	</div>
	<a class="text-center" href="<%=response.encodeURL(request.getContextPath()+"/uneJSP.jsp")%>">Une JSP</a>
</body>
</html>