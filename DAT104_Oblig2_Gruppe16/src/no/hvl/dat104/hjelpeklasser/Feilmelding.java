package no.hvl.dat104.hjelpeklasser;

import javax.servlet.http.HttpServletRequest;

public class Feilmelding {
	private String fornavn;
	private String etternavn;
	private String telefonnr;
	private String fornavnFeilmld;
	private String etternavnFeilmld;
	private String telefonnrFeilmld;
	static final String DIGITS = "[0-9]";
	static final String BOKSTAVER_MED_MELLOMROM = "[a-zA-Z -]";
	static final String BOKSTAVER = "[a-zA-ZeaøEØÅ-]";
	static final String STORE_BOKSTAVER = "[A-ZÆØÅ]";
	
	
	public Feilmelding() {	
	}
	public Feilmelding(HttpServletRequest request) {	
		fornavn= request.getParameter("fornavn");
		etternavn= request.getParameter("etternavn");
		telefonnr= request.getParameter("mobil");


	}
	
	public void settOppFeilmelding() {
		
		if(!validFornavn()) {
			fornavn="";
			fornavnFeilmld= "Minst 2 tegn, stor forbokstav.";
			System.out.println("Fornavn ikke validert");
		}
		if(!validEtternavn()) {
			etternavn="";
			etternavnFeilmld="Minst 2 tegn, stor forbokstav.";
		}
		if(!validTelefon()) {
			telefonnr="";
			telefonnrFeilmld="Må være 8 siffer og ikke i bruk";
		}
	}
	
	
	
	
	
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public String getTelefonnr() {
		return telefonnr;
	}
	public void setTelefonnr(String telefonnr) {
		this.telefonnr = telefonnr;
	}
	public String getFornavnFeilmld() {
		return fornavnFeilmld;
	}
	public void setFornavnFeilmld(String fornavnFeilmld) {
		this.fornavnFeilmld = fornavnFeilmld;
	}
	public String getEtternavnFeilmld() {
		return etternavnFeilmld;
	}
	public void setEtternavnFeilmld(String etternavnFeilmld) {
		this.etternavnFeilmld = etternavnFeilmld;
	}
	public String getTelefonnrFeilmld() {
		return telefonnrFeilmld;
	}
	public void setTelefonnrFeilmld(String telefonnrFeilmld) {
		this.telefonnrFeilmld = telefonnrFeilmld;
	}
	
	public boolean validFornavn() {
		if (fornavn == null) {
			System.out.println("Fornavn er vist som null");
			return false;
		}
		return fornavn.matches("^" + STORE_BOKSTAVER + BOKSTAVER_MED_MELLOMROM + "{1,19}");
	}
	
	public boolean validEtternavn() {
		if (etternavn == null) {
			System.out.println("Etternavn er vist som null");
			return false;
		}
		return etternavn.matches("^" + STORE_BOKSTAVER + BOKSTAVER + "{1,19}");
	}
	
	public boolean validTelefon() {
		if (telefonnr == null) {
			System.out.println("Telefon er vist som null");
			return false;
		}

		return telefonnr.matches("^" + DIGITS + "{8}");
	
	}

	
	public boolean erAlleDataGyldige() {
		return (validFornavn() && validEtternavn() && validTelefon());
		
	}


}
