package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata bloccata;
	private StanzaBloccata nonBloccata;
	private Attrezzo sblocca;
	
	@Before
	public void setUp() {
		this.bloccata = new StanzaBloccata("Bloccata", Direzione.nord, "Chiave");
		this.nonBloccata = new StanzaBloccata("Sbloccata",Direzione.nord, "Chiave");
		this.sblocca = new Attrezzo("Chiave", 0);
		this.nonBloccata.addAttrezzo(sblocca);
		this.nonBloccata.impostaStanzaAdiacente(Direzione.nord, bloccata);
	}
	
	@Test
	public void testGetStanzaAdiacenteStanzaBloccata_Bloccata() {
		assertEquals(this.bloccata,this.bloccata.getStanzaAdiacente(Direzione.nord));
	}
	
	@Test
	public void testGetStanzaAdiacenteStanzaBloccata_NonBloccata() {
		assertEquals(this.nonBloccata.getStanzaAdiacente(Direzione.nord),this.bloccata);
	}
}
