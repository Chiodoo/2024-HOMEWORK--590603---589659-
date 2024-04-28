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
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
}