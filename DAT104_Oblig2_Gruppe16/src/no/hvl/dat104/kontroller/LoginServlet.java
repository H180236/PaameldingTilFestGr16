package no.hvl.dat104.kontroller;

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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/mobillogin.jsp").forward(request, response);
	}

	@EJB
	DeltakerEAO dEAO;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean funnet = true;
		String telefonnummer = request.getParameter("telefonnummer");
		Deltaker deltaker = new Deltaker();
		deltaker = dEAO.finnDeltaker(telefonnummer);
		
		HttpSession sesjon = request.getSession();
		sesjon.setAttribute("brukernavn", telefonnummer);
		
		if (deltaker.getTelefonnummer().equals(telefonnummer)) {
			response.sendRedirect("DeltakerlisteServlet");
		
		}
		else {
			response.sendRedirect("/WEB-INF/mobillogin.jsp");
		}
	
		
			
		
		
	}

}
