package no.hvl.dat104.kontroller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.datatilgang.DeltakerEAO;
import no.hvl.dat104.modell.Deltaker;

/**
 * Servlet implementation class KassererLogin
 */

public class KassererLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String passord;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KassererLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/kassererlogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@EJB
	DeltakerEAO dEAO;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String telefonnummer = request.getParameter("telefonnummer");
		
		
		
		HttpSession sesjon = request.getSession();
		sesjon.setAttribute("brukernavn", "te");
		
		if (telefonnummer!=null) {
		if (telefonnummer.equals(passord)) {
			
			request.getRequestDispatcher("BetalingsServlet").forward(request, response);
		
		}
		}
		else {
			response.sendRedirect("LoginServlet");
		}
	}

}
