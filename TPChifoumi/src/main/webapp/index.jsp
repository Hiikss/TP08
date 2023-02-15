<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Chifoumi</title>
</head>
<body class="container">
	<h1 class="text-center">TENTATIVE</h1>
	<br>
	<form class="row" action="<%=request.getContextPath()%>/resultat" method="post">
		<button type="submit" id="pierre" name="choix" class="col-2 offset-2 offset-md-0 btn btn-outline-primary" value="0">Pierre</button>
		<button type="submit" id="feuille" name="choix" class="col-2 offset-4 offset-md-3 btn btn-outline-primary" value="1">Feuille</button>
		<button type="submit" id="ciseaux" name="choix" class="mt-5 mt-md-0 col-2 offset-5 offset-md-3 btn btn-outline-primary" value="2">Ciseaux</button>
	</form>
</body>
</html>