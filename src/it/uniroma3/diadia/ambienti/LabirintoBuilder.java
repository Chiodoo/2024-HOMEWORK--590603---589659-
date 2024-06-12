package it.uniroma3.diadia.ambienti;

import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggio.Cane;
import it.uniroma3.diadia.personaggio.Mago;
import it.uniroma3.diadia.personaggio.Strega;

public class LabirintoBuilder {
	private Labirinto labirinto;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
	}
	
	public LabirintoBuilder addStanzaIniziale(String nome) {
		Stanza stanza = new Stanza(nome);
		this.labirinto.setStanzaIniziale(stanza);
		this.labirinto.setUltimaAggiunta(this.labirinto.getStanzaIniziale());
		this.labirinto.getStanze().put(nome, stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nome) {
		Stanza stanza = new Stanza(nome);
		this.labirinto.setStanzaVincente(stanza);
		this.labirinto.setUltimaAggiunta(this.labirinto.getStanzaVincente());
		this.labirinto.getStanze().put(nome, stanza);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nome,int peso) {
		this.labirinto.getUltimaAggiunta().addAttrezzo(new Attrezzo(nome, peso));
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String corrente,String adiacente,Direzione direzione) {
		this.labirinto.getStanze().get(corrente).impostaStanzaAdiacente(direzione, this.labirinto.getStanze().get(adiacente));
		return this;
	}
	
	public LabirintoBuilder addStanza(String nome) {
		Stanza stanza = new Stanza(nome);
		this.labirinto.getStanze().put(nome, stanza);
		this.labirinto.setUltimaAggiunta(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome,int sogliaMagica) {
		Stanza stanza = new StanzaMagica(nome,sogliaMagica);
		this.labirinto.getStanze().put(nome, stanza);
		this.labirinto.setUltimaAggiunta(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nome, String illumina) {
		Stanza stanza = new StanzaBuia(nome,illumina);
		this.labirinto.getStanze().put(nome, stanza);
		this.labirinto.setUltimaAggiunta(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome, Direzione direzione, String chiave) {
		Stanza stanza = new StanzaBloccata(nome,direzione,chiave);
		this.labirinto.getStanze().put(nome, stanza);
		this.labirinto.setUltimaAggiunta(stanza);
		return this;
	}
	
	public LabirintoBuilder addStrega(String nome) {
		this.labirinto.getUltimaAggiunta().setPersonaggio(new Strega(nome));
		return this;
	}
	
	public LabirintoBuilder addCane(String nome,String attrezzo,int peso) {
		this.labirinto.getUltimaAggiunta().setPersonaggio(new Cane(nome,new Attrezzo(nome, peso)));
		return this;
	}
	
	public LabirintoBuilder addMago(String nome,String attrezzo,int peso) {
		this.labirinto.getUltimaAggiunta().setPersonaggio(new Mago(nome,new Attrezzo(nome, peso)));
		return this;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Map<String,Stanza> getListaStanze() {
		return this.labirinto.getStanze();
	}
	
}
