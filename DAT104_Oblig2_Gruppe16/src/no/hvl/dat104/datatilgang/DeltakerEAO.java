package no.hvl.dat104.datatilgang;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import no.hvl.dat104.modell.Deltaker;

@Stateless
public class DeltakerEAO {

	@PersistenceContext(name = "deltakerPersistenceUnit")
	private EntityManager em;

	public Deltaker finnDeltaker(String mobilnummer) {
		return em.find(Deltaker.class, mobilnummer);
	}
	
	public List<Deltaker> alleDeltakere() {
		TypedQuery<Deltaker> query = em.createQuery("SELECT d FROM Deltaker d ORDER BY d.fornavn, d.etternavn", Deltaker.class);
		return query.getResultList();
	
	}
	
	public void leggTilDeltaker(Deltaker deltaker) {
		em.persist(deltaker);
	}
	
	public boolean eksistererDeltaker(String telefonnummer) {
		if (em.find(Deltaker.class, telefonnummer)!=null) {
			return true;
		}
		return false;
	}
	public void oppdaterDeltaker(Deltaker d) {
		em.merge(d);
	}
	
	public void registrerBetaling (String telefonnummer, Boolean betalingsstatus) {
		Deltaker deltaker = finnDeltaker(telefonnummer);
		deltaker.setBetalingsstatus(betalingsstatus);
		oppdaterDeltaker(deltaker);
		
	}

}
