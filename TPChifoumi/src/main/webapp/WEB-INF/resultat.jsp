<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Résultat chifoumi</title>
</head>
<body>
	<h1 class="text-center">RESULTAT</h1>
	<br>
	<div class="text-center">
	<%int resultat = (int) request.getAttribute("resultat"); 
		if(resultat==0) {
			out.write("Égalité !");
		}
		else if(resultat==1){
			out.write("Vous avez gagné !");
		}
		else {
			out.write("Vous avez perdu !");
		}
	%>
	</div>
	<div class="text-center">
	<%int choixJoueur = (int) request.getAttribute("choixJoueur"); 
		if(choixJoueur==0) {
			out.write("Vous avez joué pierre ");
		}
		else if(choixJoueur==1){
			out.write("Vous avez joué feuille ");
		}
		else {
			out.write("Vous avez joué ciseaux ");
		}
	%>
	<%int choixServ = (int) request.getAttribute("choixServ"); 
		if(choixServ==0) {
			out.write("et le serveur a joué pierre");
		}
		else if(choixServ==1){
			out.write("et le serveur a joué feuille");
		}
		else {
			out.write("et le serveur a joué ciseaux");
		}
	%>
	</div>
	<br>
	<form  action="<%=request.getContextPath()%>" method="post">
		<button type="submit" class="col-2 offset-5 btn btn-outline-success" value="">Rejouer</button>
	</form>
</body>
</html>