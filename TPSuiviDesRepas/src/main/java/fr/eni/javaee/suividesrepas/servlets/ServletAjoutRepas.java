package fr.eni.javaee.suividesrepas.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bll.RepasManager;

/**
 * Servlet implementation class ServletAjoutRepas
 */
@WebServlet("/ajout")
public class ServletAjoutRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajout.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDate date = null;
		LocalTime heure = null;
		String repas = null;
		List<Integer> listeErreurs = new ArrayList<>();
		
		try {
			date = LocalDate.parse(request.getParameter("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		catch(DateTimeParseException e) {
			e.printStackTrace();
			listeErreurs.add(CodesResultatServlets.FORMAT_REPAS_DATE_ERREUR);
		}
		
		try {
			heure = LocalTime.parse(request.getParameter("heure"), DateTimeFormatter.ofPattern("HH:mm"));
		}
		catch(DateTimeParseException e) {
			e.printStackTrace();
			listeErreurs.add(CodesResultatServlets.FORMAT_REPAS_HEURE_ERREUR);
		}
		
		repas = request.getParameter("repas");
		if(repas==null || repas.trim().isEmpty()) {
			listeErreurs.add(CodesResultatServlets.FORMAT_REPAS_ALIMENT_ERREUR);
		}
		
		if(listeErreurs.size() > 0) {
			request.setAttribute("listeErreurs", listeErreurs);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajout.jsp");
			rd.forward(request, response);
		}
		else {
			RepasManager repasManager = new RepasManager();
			try {
				repasManager.ajouterRepas(date, heure, Arrays.asList(repas.split(",")));
				RequestDispatcher rd = request.getRequestDispatcher("/repas");
				rd.forward(request, response);
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("listeErreurs", e.getListeCodesErreur());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajout.jsp");
				rd.forward(request, response);
			}
		}
	}

}
