package fr.eni.javaee.module7;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListeneDemarrageArret
 *
 */
@WebListener
public class ListenerDemarrageArret implements ServletContextListener {
	private static Date dateDemarrage;
	
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Arrêt de l'application");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Démarrage de l'application");
    	ListenerDemarrageArret.dateDemarrage = new Date();
    }

	public static Date getDateDemarrage() {
		return dateDemarrage;
	}
	
}
