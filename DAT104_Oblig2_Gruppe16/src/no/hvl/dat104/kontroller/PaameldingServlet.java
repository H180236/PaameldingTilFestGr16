package no.hvl.dat104.kontroller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.datatilgang.DeltakerEAO;
import no.hvl.dat104.modell.Deltaker;

/**
 * Servlet implementation class PaameldingServlet
 */
@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaameldingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	@EJB
	DeltakerEAO dEAO;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String telefonnummer = request.getParameter("mobil");
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String kjonn = request.getParameter("kjonn");
		Deltaker nyDeltaker = new Deltaker();
		nyDeltaker.setBetalingsstatus(false);
		nyDeltaker.setEtternavn(etternavn);
		nyDeltaker.setFornavn(fornavn);
		nyDeltaker.setTelefonnummer(telefonnummer);
		nyDeltaker.setKjonn(kjonn);
		
		
		dEAO.leggTilDeltaker(nyDeltaker);
		response.sendRedirect("/WEB-INF/paameldingsskjema.jsp");
	}

}
