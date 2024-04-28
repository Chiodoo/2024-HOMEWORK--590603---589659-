package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPrendiTest {
	private Partita partita;
	private Labirinto labirinto;
	private ComandoPrendi comandoPrendi;
	private Attrezzo pesante;
	
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
		this.comandoPrendi = new ComandoPrendi();
		this.pesante = new Attrezzo("Pesante", 1000);
		this.partita.getStanzaCorrente().addAttrezzo(pesante);
	}
	
	@Test
	public void testComandoPrendi_InserimentoApprovato() {
		this.comandoPrendi.setParametro("osso");
		this.comandoPrendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	public void testComandoPrendi_AttrezzoInesistente() {
		this.comandoPrendi.setParametro("Inesistente");
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Inesistente"));
	}
	
	@Test
	public void testComandoPrendi_BorsaPiena() {
		this.comandoPrendi.setParametro("Pesante");
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Pesante"));
	}
}
