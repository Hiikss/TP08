<%@page import="java.util.List"%>
<%@page import="fr.eni.javaee.suividesrepas.messages.LecteurMessage"%>
<%@page import="fr.eni.javaee.suividesrepas.bo.Repas"%>
<%@page import="fr.eni.javaee.suividesrepas.bo.Aliment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<title>Historique repas</title>
</head>
<body class="container">
	<h1 class="text-center">HISTORIQUE</h1>
	<%
		List<Integer> listeErreurs = (List<Integer>) request.getAttribute("listeErreurs");
		if(listeErreurs!=null) {
	%>
			<div class="alert alert-danger text-center" role="alert">
				<p>Une erreur est survenue, le repas n'a pas pu être ajouté :</p>
	<%
			for(int erreur:listeErreurs)
			{
	%>
				<p><%=LecteurMessage.getMessageErreur(erreur)%></p>
	<%				
			}
		}
	%>
		</div>
	<table class="table table-bordered col-10 offset-1 mt-5">
		<thead class="thead-light">
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Heure</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<%
					List<Repas> listeRepas = (List<Repas>) request.getAttribute("listeRepas");
					if(listeRepas!=null && listeRepas.size()>0)
					{
				%>
						<tbody>
							<%
							for(Repas repas : listeRepas)
							{
							%>
								<tr>
									<td><%=repas.getDate()%></td>
									<td><%=repas.getHeure()%></td>
									
									<td>détail</td>
								</tr>

									<tr>
										<td colspan="3">
											<ul>
												<%
												for(Aliment aliment:repas.getAliments())
												{
												%>
													<li><%=aliment.getNom()%></li>
												<%
												}
												%>
											</ul>
										</td>
									</tr>
							<%
								}
							
							%>
						</tbody>
				<%
					}
					else
					{
				%>
					<div class="alert alert-primary text-center">Il n'y a pas de repas à afficher</div>
				<%
					}
				%>
	</table>
	<div class="row mt-5">
		<a href="<%=request.getContextPath()%>/ajout" class="col-4 offset-1 btn btn-outline-primary">Ajouter un nouveau repas</a>
		<a href="<%=request.getContextPath()%>/accueil" class="col-4 offset-2 btn btn-outline-primary" role="button">Retour à l'accueil</a>
	</div>
</body>
</html>