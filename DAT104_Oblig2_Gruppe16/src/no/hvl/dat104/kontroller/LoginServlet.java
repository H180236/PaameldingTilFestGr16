package no.hvl.dat104.kontroller;

import static no.hvl.dat104.hjelpeklasser.UrlMappings.DELTAKERLISTE_URL;
import static no.hvl.dat104.hjelpeklasser.UrlMappings.LOGIN_URL;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.datatilgang.DeltakerEAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/" + LOGIN_URL)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/mobillogin.jsp").forward(request, response);
	}

	@EJB
	DeltakerEAO dEAO;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String feilmelding = "Deltaker med dette telefonnummeret er ikke registrert";

		String telefonnummer = request.getParameter("mobil");
		if (dEAO.eksistererDeltaker(telefonnummer)) {
			request.getSession().removeAttribute("ingenDeltaker");
			request.getSession().setAttribute("brukernavn", telefonnummer);
			System.out.println("Deltaker eksisterer");

			response.sendRedirect(DELTAKERLISTE_URL);
		} else {

			request.getSession().setAttribute("ingenDeltaker", feilmelding);
			request.getRequestDispatcher("/WEB-INF/mobillogin.jsp").forward(request, response);
		}

	}

}
