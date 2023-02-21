package fr.eni.javaee.module7;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltreRessourcesInterdites
 */
@WebFilter(
			urlPatterns="/modules/module7/*",
			dispatcherTypes= {
								DispatcherType.REQUEST,
								DispatcherType.INCLUDE,
								DispatcherType.FORWARD,
								DispatcherType.ERROR
								}
			)
public class FiltreRessourcesInterdites implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if(!httpRequest.getServletPath().toLowerCase().contains("interdit")) {
			//Laisse passer la ressource
			chain.doFilter(request, response);
		}
		else {
			//renvoie une erreur 403
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
