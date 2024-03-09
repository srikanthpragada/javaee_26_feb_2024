package listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

//@WebListener
public class SessionCountListener implements ServletContextListener, HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		var sc = se.getSession().getServletContext();
		int count = (Integer) sc.getAttribute("count");
		sc.setAttribute("count", count  + 1);
		
		System.out.println("Session Created!");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		var sc = se.getSession().getServletContext();
		int count = (Integer) sc.getAttribute("count");
		sc.setAttribute("count",count - 1);
		System.out.println("Session Destroyed!");
	}

	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("count",0);
		System.out.println("Context Initialized!");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context Destoryed!");
	}

}
