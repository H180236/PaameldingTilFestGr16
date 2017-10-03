
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Sjekker om man har logget inn som kasserer, får betalingsoversikten dersom
		// innlogget.
		HttpSession sesjon = request.getSession();
		if (sesjon.getAttribute("kasserer").equals("1")) {
			List<Deltaker> deltakere = dEAO.alleDeltakere();
			sesjon.setAttribute("deltakere", deltakere);
			request.getRequestDispatcher("/WEB-INF/betalingsoversikt.jsp").forward(request, response);
		} else
			response.sendRedirect(KASSERER_URL);
	}

	@EJB
	DeltakerEAO dEAO;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Registrer betaling til deltaker, redirecter tilbake til betalingsoversikten
		// etter betaling er registrert
		String telefonnummer = request.getParameter("telefonnummer");
		dEAO.registrerBetaling(telefonnummer, true);
		response.sendRedirect(BETALING_URL);

	}

}
