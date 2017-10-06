package no.hvl.dat104.kontroller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.datatilgang.DeltakerEAO;
import no.hvl.dat104.hjelpeklasser.Validator;
import no.hvl.dat104.modell.Deltaker;
import static no.hvl.dat104.hjelpeklasser.UrlMappings.*;
import no.hvl.dat104.hjelpeklasser.DeltakerHaandtering;
import no.hvl.dat104.hjelpeklasser.Feilmelding;

/**
 * Servlet implementation class PaameldingServlet
 */
@WebServlet("/" + PAAMELDING_URL)
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PaameldingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	@EJB
	DeltakerEAO dEAO;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Validerer om input er gyldig og om telefonnummer er brukt, sender til deltakerliste om rett.
		HttpSession sesjon = request.getSession();
		Deltaker nyDeltaker = new Deltaker();
		String telefonnummer = request.getParameter("mobil");
		Feilmelding feil = new Feilmelding(request);
		if (feil.erAlleDataGyldige() && !dEAO.eksistererDeltaker(telefonnummer)) {
			DeltakerHaandtering dh = new DeltakerHaandtering();
			nyDeltaker = dh.lagDeltaker(request);
			sesjon.removeAttribute("feilmelding");
			dEAO.leggTilDeltaker(nyDeltaker);
			sesjon.setAttribute("brukernavn", telefonnummer);
			sesjon.setAttribute("Deltaker", nyDeltaker);
			request.getRequestDispatcher("/WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);

		} else {
			feil.settOppFeilmelding();
			sesjon.setAttribute("feilmelding", feil);
			request.getRequestDispatcher("/WEB-INF/paameldingsskjema.jsp").forward(request, response);

		}

	}

}
