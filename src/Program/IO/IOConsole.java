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
    public double leggiDouble() {
        double valore = scanner.nextDouble();
        scanner.nextLine();
        return valore;
    }
    public int leggiInt() {
        int valore = scanner.nextInt();
        scanner.nextLine();
        return valore;
    }
}