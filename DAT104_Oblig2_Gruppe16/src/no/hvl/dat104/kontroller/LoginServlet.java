package no.hvl.dat104.kontroller;

import static no.hvl.dat104.hjelpeklasser.UrlMappings.*;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.datatilgang.DeltakerEAO;
import no.hvl.dat104.modell.Deltaker;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/" + LOGIN_URL)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errorMessage = "";
		
		if(request.getParameter("requiresLogin") != null) {
			errorMessage = "forespørslelen krever pålogging." 
		+ "(Du kan ha blitt logget ut automatisk)";
		
		} else if(request.getParameter("invalidUsername") != null) {
			errorMessage = "feil brukernavn, prøv igjen";
		}
		request.setAttribute("errorMessage", errorMessage);
		
		request.getRequestDispatcher("/WEB-INF/mobillogin.jsp").forward(request, response);
	}

	@EJB
	DeltakerEAO dEAO;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String telefonnummer = request.getParameter("telefonnummer");
		Deltaker deltaker = new Deltaker();
		deltaker = dEAO.finnDeltaker(telefonnummer);
		
		
		
		
		
		if (deltaker!=null) {
		
		if (deltaker.getTelefonnummer().equals(telefonnummer)) {
			
			HttpSession sesjon = request.getSession(false);
			if(sesjon!= null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);
			sesjon.setMaxInactiveInterval(20);
			
			sesjon.setAttribute("brukernavn", telefonnummer);
			response.sendRedirect(DELTAKERLISTE_URL);
		}
		}
		else {
			response.sendRedirect(LOGIN_URL + "?invalidUsername");
		}
	
		
			
		
		
	}

}
