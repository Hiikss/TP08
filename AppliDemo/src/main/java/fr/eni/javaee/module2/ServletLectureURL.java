package fr.eni.javaee.module2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLectureURL
 */
@WebServlet("/modules/module2/ServletLectureURL")
public class ServletLectureURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String protocole = request.getScheme();
		String nomServeur = request.getServerName();
		int port = request.getServerPort();
		String nomApplication = request.getContextPath();
		String cheminRessource = request.getServletPath();
		
		response.getWriter().append("Protocole : " + protocole + "\nNom du serveur : " + nomServeur + "\nPort : " + port + "\nNom application : " + nomApplication + "\nChemin ressource : " + cheminRessource);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
