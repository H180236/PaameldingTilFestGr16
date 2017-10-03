package no.hvl.dat104.hjelpeklasser;

import javax.servlet.http.HttpServletRequest;

import org.apache.openejb.server.httpd.HttpRequest;

import no.hvl.dat104.modell.Deltaker;

public class DeltakerHaandtering {

	public Deltaker lagDeltaker (HttpServletRequest request) {
		Deltaker nyDeltaker = new Deltaker();
		System.out.println(request.getParameter("fornavn") + " " + request.getParameter("mobil"));
		nyDeltaker.setFornavn(request.getParameter("fornavn"));
		nyDeltaker.setEtternavn(request.getParameter("etternavn"));
		nyDeltaker.setKjonn(request.getParameter("kjonn"));
		nyDeltaker.setTelefonnummer(request.getParameter("mobil"));
		nyDeltaker.setBetalingsstatus(false);
		return nyDeltaker;
	}
}
