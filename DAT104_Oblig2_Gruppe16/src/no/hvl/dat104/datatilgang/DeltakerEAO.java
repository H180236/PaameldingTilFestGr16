package no.hvl.dat104.datatilgang;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat104.modell.Deltaker;

@Stateless
public class DeltakerEAO {

	@PersistenceContext(name = "deltakerPersistenceUnit")
	private EntityManager em;

	private Deltaker finnDeltaker(String mobilnummer) {
		return em.find(Deltaker.class, mobilnummer);
	}
	
	public void leggTilDeltaker(Deltaker deltaker) {
		em.persist(deltaker);
	}

}
