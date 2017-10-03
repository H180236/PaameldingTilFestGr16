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
String errorMessage = "";
		
		if(request.getParameter("requiresLogin") != null) {
			errorMessage = "forespørslelen krever pålogging." 
		+ "(Du kan ha blitt logget ut automatisk)";
		
		} else if(request.getParameter("invalidFornavn") != null) {
			errorMessage = "Fornavn skal være 2-20 tegn og kan inneholde"
					+ " bokstaver (inkl. æøåÆØÅ), bindestrek og mellomrom. Første tegn skal være en stor bokstav.";
		}
		request.setAttribute("errorMessage", errorMessage);
		
		request.getRequestDispatcher("/WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	@EJB
	DeltakerEAO dEAO;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// F�r tak i data fra p�meldingsskjema, lager deretter et nytt deltakerobjekt
		String telefonnummer = request.getParameter("mobil");
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String kjonn = request.getParameter("kjonn");
		Deltaker nyDeltaker = new Deltaker();
		if(Validator.valider(request)){
		
		System.out.println("Er validert, setter data inn i objektet");
		
		nyDeltaker.setEtternavn(etternavn);
		nyDeltaker.setFornavn(fornavn);
		nyDeltaker.setTelefonnummer(telefonnummer);
		nyDeltaker.setKjonn(kjonn);
		} else {
			System.out.println("Ikke validert, sender til p�meldingsskjema");
			request.getRequestDispatcher("/WEB-INF/paameldingsskjema.jsp").forward(request, response);
			return;
		}

		// Sjekker om telefonnummeret er i bruk, dersom det er i bruk blir man sendt
		// tilbake til p�melding, ellers blir deltaker lagt til i databasen
		System.out.println("kommet til sjekk om deltaker finnes");
		if (dEAO.finnDeltaker(telefonnummer) == null) {
			dEAO.leggTilDeltaker(nyDeltaker);
		} else {
			System.out.println("Deltaker finnes, sendes til p�meldingsskjema");
			request.getRequestDispatcher("/WEB-INF/paameldingsskjema.jsp").forward(request, response);
			return;
		}
		 HttpSession sesjon = request.getSession();
         
         sesjon.setAttribute("brukernavn", telefonnummer);
         sesjon.setAttribute("Deltaker",nyDeltaker);

		// Redirecter til bekreftelse dersom bruker blir meldt p�
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paameldingsbekreftelse.jsp");
		dispatcher.forward(request, response);
	}

}
