package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;


public class ComandoVaiTest {

	private Partita partita;
	private Labirinto labirinto;
	private ComandoVai comandoVai;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		this.partita = new Partita(this.labirinto);
		this.comandoVai = new ComandoVai();
	}
	
	@Test
	public void testComandoVai_DirezioneEsistente() {
		this.comandoVai.setParametro("nord");
		this.comandoVai.esegui(partita);
		assertEquals(this.partita.getStanzaCorrente().getNome(),"Biblioteca");
		assertEquals(this.partita.getGiocatore().getCfu(),19);
	}

	@Test
	public void testComandoVai_DirezioneInesistente() {
		this.comandoVai.setParametro("sud");
		this.comandoVai.esegui(partita);
		this.comandoVai.esegui(partita);	//Dato che la direzione è inesistente resto nella stanza corrente
		assertEquals(this.partita.getStanzaCorrente().getNome(),"Aula N10");
		assertEquals(this.partita.getGiocatore().getCfu(),19);
	}
}
