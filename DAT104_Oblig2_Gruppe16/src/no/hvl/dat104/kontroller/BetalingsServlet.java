
package no.hvl.dat104.kontroller;

import java.io.IOException;

import java.util.List;

import javax.ejb.EJB;
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
 * Servlet implementation class BetalingsServlet
 */
@WebServlet("/" + BETALING_URL)
public class BetalingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BetalingsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession sesjon = request.getSession();
		if (sesjon.getAttribute("brukernavn").equals("91765536")) {
			List <Deltaker> deltakere = dEAO.alleDeltakere();
			sesjon.setAttribute("deltakere", deltakere);
			
			request.getRequestDispatcher("/WEB-INF/betalingsoversikt.jsp").forward(request, response);
		} else
			request.getRequestDispatcher(LOGIN_URL).forward(request, response);
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
		dEAO.registrerBetaling(telefonnummer, true);
		response.sendRedirect(BETALING_URL);

	}

}