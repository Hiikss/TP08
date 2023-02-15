package fr.eni.javaee.chifoumi;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletChifoumi
 */
@WebServlet("/resultat")
public class ServletChifoumi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Random rdm = new Random();
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int choixServ = rdm.nextInt(3);
		int choixJoueur = Integer.parseInt(request.getParameter("choix"));
		int result;
		if(choixServ==choixJoueur) {
			result = 0;
		}
		else if(choixServ==0 && choixJoueur==1 || choixServ==1 && choixJoueur==2 || choixServ==2 && choixJoueur==0) {
			result = 1;
		}
		else {
			result = -1;
		}
		request.setAttribute("resultat", result);
		request.setAttribute("choixJoueur", choixJoueur);
		request.setAttribute("choixServ", choixServ);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/resultat.jsp");
		rd.forward(request, response);
	}

}
