package Program.IO;
import java.util.Scanner;
public class IOConsole implements IO{

	Scanner scanner;

	public IOConsole(Scanner scanner) {
		this.scanner = scanner;

	}
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	public String leggiRiga() {
		String riga = scanner.nextLine();
		return riga;
	}
	public void chiudi() {
		scanner.close();
	}
	public float leggiFloat() {
		float valore = scanner.nextFloat();
		scanner.nextLine();
		return valore;
	}
	public int leggiInt() {
		int valore = scanner.nextInt();
		scanner.nextLine();
		return valore;
	}
	
	public void Stop() {
		mostraMessaggio("Per andare avanti premi invio");
		scanner.nextLine();
	}


}