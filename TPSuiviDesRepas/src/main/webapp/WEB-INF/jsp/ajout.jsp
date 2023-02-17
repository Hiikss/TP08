<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Ajout repas</title>
</head>
<body class="container">
	<h1 class="text-center">AJOUT</h1>
	<form action="<%=request.getContextPath()%>/ajout" method="post">
		<div class="row mt-5">
			<label for="date" class="col-2 offset-2">Date :</label>
			<input type="date" id="date" name="date" class="col-3 form-control" value="<%=request.getParameter("date")%>">
		</div>
		<div class="row mt-2">
			<label for="heure" class="col-2 offset-2">Heure :</label>
			<input type="time" id="heure" name="heure" class="col-3 form-control" value="<%=request.getParameter("heure")%>">
		</div>
		<div class="row mt-2">
			<label for="repas" class="col-2 offset-2">Repas :</label>
			<textarea id=repas name="repas" rows="4" class="col-6 form-control"><%=request.getParameter("repas")!=null?request.getParameter("repas"):""%></textarea>
		</div>
		<div class="row mt-2">
			<button type="submit" id="valider" class="col-2 offset-4 btn btn-outline-success">Valider</button>
			<a href="<%=request.getContextPath()%>" class="col-2 offset-1 btn btn-outline-danger" role="button">Annuler</a>
		</div>
	</form>
</body>
</html>