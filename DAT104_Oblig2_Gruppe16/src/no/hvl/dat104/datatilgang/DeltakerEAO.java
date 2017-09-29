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
		TypedQuery<Deltaker> query = em.createQuery("SELECT d FROM Deltaker d", Deltaker.class);
		return query.getResultList();
	
	}
	
	public void leggTilDeltaker(Deltaker deltaker) {
		em.persist(deltaker);
	}

}
