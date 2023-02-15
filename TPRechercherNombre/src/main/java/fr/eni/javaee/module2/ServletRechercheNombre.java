package fr.eni.javaee.module2;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRechercheNombre
 */
@WebServlet("/ServletRechercheNombre")
public class ServletRechercheNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int nbATrouver;
	private int min = 0;
	private int max = 10;
	
	private Random rdm = new Random();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nbSaisie = request.getParameter("nombre");
		System.out.println("Nombre saisi : " + nbSaisie);
		this.nbATrouver = rdm.nextInt(this.max - this.min + 1) + this.min;
		System.out.println("Nombre à trouver : " + nbATrouver);
		if(nbSaisie.equals(String.valueOf(this.nbATrouver))) {
			response.sendRedirect("pages/victoire.html");
		}
		else {
			response.sendRedirect("pages/echec.html");
		}
	}

}
