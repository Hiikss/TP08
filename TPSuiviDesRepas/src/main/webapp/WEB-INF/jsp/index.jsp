<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Accueil</title>
</head>
<body class="container">
	<h1 class="text-center">ACCUEIL</h1>
	<div class="row justify-content-center mt-5">
		<a href="<%=request.getContextPath()%>/ajout" class="btn btn-outline-primary" role="button">Ajouter un nouveau repas</a>
	</div>
	<div class="row justify-content-center mt-5">
		<a href="<%=request.getContextPath()%>/repas" class="btn btn-outline-primary" role="button">Visualiser les repas</a>
	</div>
</body>
</html>