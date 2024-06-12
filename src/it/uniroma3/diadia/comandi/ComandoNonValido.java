package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	private IO ioConsole;
	
	@Override
	public void esegui(Partita partita) {
		this.ioConsole = new IOConsole();
		ioConsole.mostraMessaggio("Comando non valido");
	}

	@Override
	public String getNome() {
		return null;
	}
}
