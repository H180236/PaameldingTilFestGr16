package no.hvl.dat104.kontroller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.datatilgang.DeltakerEAO;
import no.hvl.dat104.modell.*;

/**
 * Servlet implementation class DeltakerlisteServlet
 */
@WebServlet("/DeltakerlisteServlet")
public class DeltakerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeltakerlisteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @EJB
    DeltakerEAO dEAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("brukernavn")!=null) {
		List <Deltaker> deltakere = dEAO.alleDeltakere();
		request.getSession().setAttribute("deltakere", deltakere);
		request.getRequestDispatcher("/WEB-INF/deltagerliste.jsp").forward(request, response);
		} else request.getRequestDispatcher("LoginServlet").forward(request, response);
	}


}
