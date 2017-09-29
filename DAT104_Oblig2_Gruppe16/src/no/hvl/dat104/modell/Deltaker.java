package no.hvl.dat104.modell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="fest", name= "deltaker")
public class Deltaker {
	
	@Id
	private String telefonnummer;
	private String fornavn;
	private String etternavn;
	private boolean betalingsstatus;
	private boolean kasserer;
	
	public boolean isKasserer() {
		return kasserer;
	}
	public void setKasserer(boolean kasserer) {
		this.kasserer = kasserer;
	}
	private String kjonn;
	
	
	public String getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
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
	public boolean isBetalingsstatus() {
		return betalingsstatus;
	}
	public void setBetalingsstatus(boolean betalingsstatus) {
		this.betalingsstatus = betalingsstatus;
	}
	public String getKjonn() {
		return kjonn;
	}
	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
}