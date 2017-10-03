package no.hvl.dat104.kontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static no.hvl.dat104.hjelpeklasser.UrlMappings.*;

@WebServlet("/" + LOGOUT_URL)
public class LoggUtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//invaliderer sesjonsobjektet (logger brukeren ut, redirecter deretter til en logg-ut side
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession();
		sesjon.invalidate();
		request.getRequestDispatcher("/WEB-INF/ferdig.jsp").forward(request, response);
	}

}
