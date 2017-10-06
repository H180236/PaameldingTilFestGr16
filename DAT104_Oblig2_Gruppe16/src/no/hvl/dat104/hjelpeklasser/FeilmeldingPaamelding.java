package no.hvl.dat104.hjelpeklasser;

import javax.servlet.http.HttpServletRequest;

public class FeilmeldingPaamelding {
	private String fornavn;
	private String etternavn;
	private String telefonnr;
	private String fornavnFeilmld;
	private String etternavnFeilmld;
	private String telefonnrFeilmld;
	
	
	public FeilmeldingPaamelding() {	
	}
	public FeilmeldingPaamelding(HttpServletRequest request) {	
		fornavn= request.getParameter("fornavn");
		etternavn= request.getParameter("etternavn");
		telefonnr= request.getParameter("telefonnr");

	}
	
	public void settOppFeilmelding() {
		Validator vali = new Validator();
		if(!vali.validFornavn(fornavn)) {
			fornavn="";
			fornavnFeilmld= "Kan ikke være tom.";
		}
		if(!vali.validEtternavn(etternavn)) {
			etternavn="";
			etternavnFeilmld="Kan ikke være tom.";
		}
		if(vali.validTelNum(telefonnr)) {
			telefonnr="";
			telefonnrFeilmld="Må være 8 siffer";
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


}
