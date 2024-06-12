package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;

public class CaricatoreLabirintoTest {
	private Labirinto labirinto;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto = Labirinto.newBuilder("LabirintoDesktop.txt").getLabirinto();
	}
	
	@Test
	public void testCaricatoreLabirintoNonNull() {
		assertTrue(this.labirinto!=null);
	}
	
	@Test
	public void testCaricatoreLabirintoStanzaIniziale() {
		assertEquals(this.labirinto.getStanzaIniziale().getNome(),"N10");
	}
	
	@Test
	public void testCaricatoreLabirintoStanzaVincente() {
		assertEquals(this.labirinto.getStanzaVincente().getNome(),"N11");
	}
	
	@Test
	public void testCaricatoreLabirintoStanzaAdiacente() {
		assertEquals(this.labirinto.getStanzaIniziale().getStanzaAdiacente(Direzione.nord).getNome(),"N11");
	}
	
	@Test
	public void testCaricatoreLabirintoAttrezzo() {
		assertTrue(this.labirinto.getStanzaIniziale().getAttrezzi().containsKey("pinza"));
	}
} 
