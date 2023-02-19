package fr.eni.javaee.suividesrepas.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bll.RepasManager;
import fr.eni.javaee.suividesrepas.bo.Repas;

/**
 * Servlet implementation class ServletVisualiserRepas
 */
@WebServlet("/repas")
public class ServletVisualiserRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RepasManager repasManager = new RepasManager();
			List<Repas> listeRepas = null;
			listeRepas = repasManager.selectRepas();
			request.setAttribute("listeRepas", listeRepas);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("listeErreurs", e.getListeCodesErreur());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/visualiser.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
