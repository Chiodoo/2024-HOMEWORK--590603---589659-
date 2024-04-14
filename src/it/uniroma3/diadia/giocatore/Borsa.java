package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Borsa:classe che contiene un certo numero di attrezzi posseduti dal giocatore
 * usata per aggiungere un attrezzo nella borsa, rimuovere un oggetto dalla borsa, sapere il peso della borsa
 * 
 * @author Carmine Adduce, Marco Chiodo docente di PO
 * @see Giocatore
 * @see Attrezzo
 * @version base 
 * */
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() { this(DEFAULT_PESO_MAX_BORSA);
	}

	/*
	 * costruttore della classe borsa
	 * @param pesoMax è il peso massimo di oggetti che si possono ancora aggiungere nella borsa
	 * */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}


	/*
	 * metodo che serve per aggiungere un attrezzo nella borsa
	 * @param attrezzo è l'oggetto attrezzo che vogliamo inserire
	 * @return ritorna un valore booleano che è true se l'oggetto è stato inserito, false altrimenti
	 * */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;

		if (this.numeroAttrezzi==10)
			return false;

		for(int i=0;i<this.attrezzi.length;i++) {
			if(this.attrezzi[i]==null) {
				this.attrezzi[i]=attrezzo;
				this.numeroAttrezzi++;
				return true;
			}
		}
		return false;
	}

	/*
	 * metodo che serve per ottenere il peso disponibile nella borsa
	 * @return pesoMax
	 * */
	public int getPesoMax() {
		return pesoMax;
	}

	/*
	 * metodo che serve per ottenere l'attrezzo di nome nomeAttrezzo nella borsa
	 * @param nomeAttrezzo è il nome dell'attrezzo hce stavamo cercando
	 * @return ritorna a che è il riferimento all'attrezzo che stavamo cercando, altrimenti è null
	 * */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.attrezzi.length; i++)
			if(this.attrezzi[i]!=null)
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
					a = attrezzi[i];
		return a;
	}

	/*
	 * metodo che serve per ottenere il peso totale degli oggetti nella borsa
	 * @return pesoMax
	 * */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.attrezzi.length; i++)
			if(this.attrezzi[i]!=null)
				peso += this.attrezzi[i].getPeso();
		return peso;
	}


	/*
	 * metodo che ci dice se la borsa è vuota
	 * @return un valore boolano che è true se la borsa è vuota, è false altrimenti
	 * */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	/*
	 * metodo che serve per sapere se nella borsa abbiamo un attrezzo con un certo nome
	 * @param nomeAttrezzo è il nome dell'attrezzo che vogliamo cercare
	 * @return un valore booleano che è true se l'attrezzo è presente nella borsa, è false altirmenti
	 * */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/*
	 * metodo che rimuove un attrezzo con un dato nome
	 * @param nomeAttrezzo è il nome dell'attrezzo che vogliamo rimuovere
	 * @return a che è un riferimento all'attrezzo appena rimosso, altrimenti è null
	 * */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(this.hasAttrezzo(nomeAttrezzo)) {
			int i=0;
			boolean rimosso=false;
			while(!rimosso&&i<attrezzi.length) {
				if(nomeAttrezzo.equals(attrezzi[i].getNome()))
					a=attrezzi[i];
				attrezzi[i]=null;
				rimosso=true;
				this.numeroAttrezzi--;
				i++;
			}
		}
		return a;
	}

	/*
	 * metodo che ci restituisce informazioni sulla borsa quali nomi e peso degli attrezzi nella borsa,il peso totale degli attrezzi, il peso disponibile nella borsa
	 * @return una stringa contenente le informazioni della borsa
	 * */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
		} else
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		for (int i= 0; i<this.attrezzi.length; i++)
			if(this.attrezzi[i]!=null)
				s.append(attrezzi[i].toString()+" ");
		s.append("Borsa vuota");
		return s.toString();
	}
}