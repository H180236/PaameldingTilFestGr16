package no.hvl.dat104.kontroller;

import static no.hvl.dat104.hjelpeklasser.UrlMappings.BETALING_URL;
import static no.hvl.dat104.hjelpeklasser.UrlMappings.KASSERER_URL;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.datatilgang.DeltakerEAO;

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

		String errorMessage = "";

		if (request.getParameter("KassererPassord") != null) {
			errorMessage = "forespørslelen krever pålogging." + "(Du kan ha blitt logget ut automatisk)";

		} else if (request.getParameter("invalidUsername") != null) {
			errorMessage = "Feil passord, prøv igjen!";
		}
		request.setAttribute("errorMessage", errorMessage);
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

		if (telefonnummer.equals(passord)) {
			sesjon.setAttribute("kasserer", "1");
			System.out.println("Rett passord skrevet inn, pr�ver � redirecte til" + BETALING_URL);
			response.sendRedirect(BETALING_URL);

		} else {
			response.sendRedirect(KASSERER_URL + "?invalidUsername");
		}
	}

}
