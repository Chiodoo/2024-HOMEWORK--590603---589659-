package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		this.stanzaVincente = new Stanza("Biblioteca");
		this.stanzaIniziale = new Stanza("Atrio");
		
	}
	
	@Test
	public void testGetStanzaVincente_Vincente() {
		assertTrue(this.labirinto.getStanzaVincente().getNome().equals(this.stanzaVincente.getNome()));
	}
	
	@Test
	public void testGetStanzaVincente_Perdente() {
		assertFalse(this.labirinto.getStanzaVincente().getNome().equals(this.stanzaIniziale.getNome()));
	}
	
	@Test
	public void testGetStanzaIniziale_TRUE() {
		assertTrue(this.labirinto.getStanzaIniziale().getNome().equals(this.stanzaIniziale.getNome()));
	}
	
	@Test
	public void testGetStanzaIniziale_FALSE() {
		assertFalse(this.labirinto.getStanzaIniziale().getNome().equals(this.stanzaVincente.getNome()));
	}
}
