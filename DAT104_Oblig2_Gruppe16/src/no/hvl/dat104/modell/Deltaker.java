package no.hvl.dat104.modell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="", name= "")
public class Deltaker {
	
	@Id
	private Integer telefonnummer;
	
	private String fornavn;
	private String etternavn;
	private boolean betalingsstatus;
	private Character kjonn;
	
	
	public Integer getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(Integer telefonnummer) {
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
	public Character getKjonn() {
		return kjonn;
	}
	public void setKjonn(Character kjonn) {
		this.kjonn = kjonn;
	}
}
