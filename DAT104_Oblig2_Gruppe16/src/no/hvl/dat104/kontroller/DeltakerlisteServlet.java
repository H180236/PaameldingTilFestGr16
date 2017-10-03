package no.hvl.dat104.kontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.datatilgang.DeltakerEAO;
import no.hvl.dat104.modell.*;
import static no.hvl.dat104.hjelpeklasser.UrlMappings.*;

@WebServlet("/" + DELTAKERLISTE_URL)
public class DeltakerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DeltakerEAO dEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				//Sjekker om brukernavnet (telefonnummer) i sesjonens-attributten finnes i databasen
				//Dersom brukeren er p�meldt henter vi en liste av alle deltakerne og forwarder til deltakerliste.jsp
				//Dersom man pr�ver � f� tilgang til deltakerlisten uten � v�re innlogget blir man sendt til innlogging
		
		if (dEAO.eksistererDeltaker((String) request.getSession().getAttribute("brukernavn"))) {
			List<Deltaker> deltakere = dEAO.alleDeltakere();

			request.getSession().setAttribute("deltakere", deltakere);
			request.getRequestDispatcher("/WEB-INF/deltagerliste.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("login").forward(request, response);
	}

}
