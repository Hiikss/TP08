<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Historique repas</title>
</head>
<body class="container">
	<h1 class="text-center">HISTORIQUE</h1>
	<div class="row mt-2">
		<a href="<%=request.getContextPath()%>/ajout" class="col-4 offset-1 btn btn-outline-primary">Ajouter un nouveau repas</a>
		<a href="<%=request.getContextPath()%>/accueil" class="col-4 offset-1 btn btn-outline-primary" role="button">Retour à l'accueil</a>
	</div>
</body>
</html>