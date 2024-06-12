package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class FabbricaDiComandiRiflessivaTest {
	private FabbricaDiComandiRiflessiva fabbricaDiComandiRiflessiva;
	private Comando comando;
	
	@Before
	public void setUp() {
		this.fabbricaDiComandiRiflessiva = new FabbricaDiComandiRiflessiva();
		this.comando=null;
		
	}
	
	@Test
	public void testComandoAiuto() {
		this.comando=this.fabbricaDiComandiRiflessiva.costruisciComando("aiuto");
		assertEquals(this.comando.getNome(),"aiuto");
	}
	
	@Test
	public void testComandoFine() {
		this.comando=this.fabbricaDiComandiRiflessiva.costruisciComando("fine");
		assertEquals(this.comando.getNome(),"fine");
	}
	
	@Test
	public void testComandoGuarda() {
		this.comando=this.fabbricaDiComandiRiflessiva.costruisciComando("guarda");
		assertEquals(this.comando.getNome(),"guarda");
	}
	
	@Test
	public void testComandoNonValido() {
		this.comando=this.fabbricaDiComandiRiflessiva.costruisciComando("");
		assertNull(this.comando.getParametro());
	}
	
	@Test
	public void testComandoPosa() {
		this.comando=this.fabbricaDiComandiRiflessiva.costruisciComando("posa attrezzo");
		assertEquals(this.comando.getNome(),"posa");
		assertEquals(this.comando.getParametro(),"attrezzo");
	}
	
	@Test
	public void testComandoPrendi() {
		this.comando=this.fabbricaDiComandiRiflessiva.costruisciComando("prendi attrezzo");
		assertEquals(this.comando.getNome(),"prendi");
		assertEquals(this.comando.getParametro(),"attrezzo");
	}
	
	@Test
	public void testComandoVai() {
		this.comando=this.fabbricaDiComandiRiflessiva.costruisciComando("vai sud");
		assertEquals(this.comando.getNome(),"vai");
		assertEquals("sud",this.comando.getParametro());
	}
	
	@Test
	public void testComandoSaluta() {
		this.comando = this.fabbricaDiComandiRiflessiva.costruisciComando("saluta");
		assertEquals(this.comando.getNome(),"saluta");
	}
	
	@Test
	public void testComandoInteragisci() {
		this.comando = this.fabbricaDiComandiRiflessiva.costruisciComando("interagisci");
		assertEquals(this.comando.getNome(),"interagisci");
	}
}
