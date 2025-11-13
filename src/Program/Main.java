package Program;
import Program.Table.Table;
import java.util.Scanner;

import Program.Commands.Commands;
import Program.IO.*;
public class Main {
	public static void main(String[] argc) {
		Table table=new Table();
		Scanner scanner = new Scanner(System.in);
		IO io=new IOConsole(scanner);
		Commands comandi=new Commands(io,table);
		Menu menu=new Menu(io,comandi);
		menu.MenuPrincipale();
		io.chiudi();
	}

}


