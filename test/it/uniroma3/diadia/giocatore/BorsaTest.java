package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Borsa borsaVuota;
	private Borsa borsaPiena;
	private Borsa borsaPiùAttrezzi;
	private Attrezzo attrezzo;
	private Attrezzo spada;
	private Attrezzo torcia;
	private Attrezzo scudo;
	
	@Before
	public void setUp(){
		this.borsaVuota = new Borsa();
		this.borsaPiena = new Borsa();
		this.spada = new Attrezzo("Spada",10);
		this.borsaPiena.addAttrezzo(this.spada);
		this.borsaPiùAttrezzi = new Borsa(20);
		this.scudo = new Attrezzo("Scudo",5);
		this.torcia = new Attrezzo("Torcia", 2);
		this.borsaPiùAttrezzi.addAttrezzo(this.scudo);
		this.borsaPiùAttrezzi.addAttrezzo(this.torcia);
		this.attrezzo = new Attrezzo("Attrezzo", 10);
	}
	
	@Test
	public void testGetPesoBorsaVuota() {
		assertEquals(0, this.borsaVuota.getPeso());
	}
	
	@Test
	public void testGetPesoBorsa1Attrezzo_Piena() {
		assertEquals(10, this.borsaPiena.getPeso());
	}
	
	@Test
	public void testGetPesoBorsaPiùAttrezzi() {
		assertEquals(7, this.borsaPiùAttrezzi.getPeso());
	}
	
	@Test
	public void testInserimentoRifiutato_BorsaPiena() {
		assertFalse(this.borsaPiena.addAttrezzo(this.attrezzo));
	}
	
	@Test
	public void testInserimentoAccettato_BorsaPiùAttrezzi() {
		assertTrue(this.borsaPiùAttrezzi.addAttrezzo(this.spada));
	}
	
	@Test
	public void testGetAttrezzo_Presente() {
		assertEquals(this.torcia,this.borsaPiùAttrezzi.getAttrezzo("Torcia"));
	}
	
	@Test
	public void testGetAttrezzo_Assente() {
		assertNull(this.borsaPiena.getAttrezzo("Inesistente"));
	}
	
	@Test
	public void testRemoveAttrezzo_Rimosso() {
		assertTrue(this.borsaPiùAttrezzi.hasAttrezzo("Scudo"));
		this.borsaPiùAttrezzi.removeAttrezzo("Scudo");
		assertFalse(this.borsaPiùAttrezzi.hasAttrezzo("Scudo"));
	}
	
	@Test
	public void testRemoveAttrezzo_Inesistente() {
		assertNull(this.borsaPiùAttrezzi.removeAttrezzo("Inesistente"));
	}
}

