package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	private IO ioConsole;

	/**
	 * Metodo che rimuove un attrezzo dalla borsa e lo posa nella stanza
	 * @param partita sulla quale fare le modifiche
	 */
	@Override
	public void esegui(Partita partita) {
		this.ioConsole = new IOConsole();
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(this.parametro)) {
			this.ioConsole.mostraMessaggio("Attrezzo inesitente");
			return;
		}

		Attrezzo attrezzo;
		attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(this.parametro);
		partita.getStanzaCorrente().addAttrezzo(attrezzo); 			//Controllo che posso aggiungere l'attrezzo
		partita.getGiocatore().getBorsa().removeAttrezzo(this.parametro);
		ioConsole.mostraMessaggio("Hai posato l'attrezzo");
	}

	@Override
	public String getNome() {
		return "posa";
	}

}