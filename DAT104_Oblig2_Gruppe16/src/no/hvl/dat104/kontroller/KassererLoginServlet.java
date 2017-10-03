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
import static no.hvl.dat104.hjelpeklasser.UrlMappings.*;

/**
 * Servlet implementation class KassererLogin
 */
@WebServlet()
public class KassererLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String kassererPassord;

	public KassererLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		kassererPassord = config.getInitParameter("KassererPassord");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/kassererlogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@EJB
	DeltakerEAO dEAO;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		String telefonnummer = request.getParameter("telefonnummer");

		HttpSession sesjon = request.getSession();
		sesjon.setAttribute("brukernavn", telefonnummer);
		System.out.println(telefonnummer);
		System.out.print(kassererPassord);
		String passord = kassererPassord;

		if (telefonnummer.equals(passord) ) {
			System.out.println("Rett passord skrevet inn, prøver å redirecte til" + BETALING_URL);
			response.sendRedirect(BETALING_URL);

		} else {
			response.sendRedirect(LOGIN_URL);
		}
	}

}	
