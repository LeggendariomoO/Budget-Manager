package Program;
import Program.Table.*;
import java.util.Scanner;
import Program.IO.*;
public class Main {
	public static void main(String[] argc) {
		Scanner scanner = new Scanner(System.in);
		int verificatore=0;
		IO io=new IOConsole(scanner);
		Table database=new Table();
		database.createDatabase();
		database.createTable();
		database.insertValues(8, "appalto camorra");
		database.selectAllValues();
		io.mostraMessaggio("Vuoi eliminare la table? Premi 1 per eliminarla:");
		verificatore=io.leggiInt();
		if(verificatore==1) {
			database.dropTable();
		}
		io.chiudi();
	}
	public void insert(IO io) {
		double tempDouble=io.leggiDouble();
	}
}


