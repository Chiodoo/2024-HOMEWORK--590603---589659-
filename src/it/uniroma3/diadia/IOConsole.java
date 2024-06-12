package it.uniroma3.diadia;
import java.util.Scanner;

/**
 *Classe che gestisce l'input e l'output in tutto il DiaDia
 *
 * @author  Marco Chiodo & Carmine Adduce
 *          
 * @version 1.0
 */
public class IOConsole implements IO{
	
	private Scanner scannerDiLinee;
	
	public IOConsole() {
		scannerDiLinee = new Scanner(System.in);
	}
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
	}

	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public String leggiRiga() {
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
}