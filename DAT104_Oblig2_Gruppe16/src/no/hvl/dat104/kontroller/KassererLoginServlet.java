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

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		kassererPassord = config.getInitParameter("KassererPassord");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/kassererlogin.jsp").forward(request, response);

	}

	@EJB
	DeltakerEAO dEAO;

	// Sjekker om bruker skrev inn rett kasserer passord (hardkodet i initparam),
	// dersom rett får man betalingsoversikt
	// Dersom feil blir man bare sendt tilbake til kasserer login med en
	// feilmelding.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession();
		String telefonnummer = request.getParameter("telefonnummer");
		String passord = kassererPassord;

		if (telefonnummer.equals(passord)) {
			sesjon.setAttribute("kasserer", "1");
			response.sendRedirect(BETALING_URL);

		} else {
			sesjon.setAttribute("feilMelding", "Ugyldig passord");
			response.sendRedirect(KASSERER_URL);
		}
	}

}
