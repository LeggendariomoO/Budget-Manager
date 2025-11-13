package Program.Commands;

import Program.IO.IO;
import Program.Table.Table;

public class Commands {
	private IO io;
	private Table table;
	public Commands(IO io, Table table) {
		this.io=io;
		this.table=table;
	}
	public void insertEntrata() {
		io.mostraMessaggio("Inserisci l'entrata ricevuta:");
		float spesa=io.leggiFloat();
		io.mostraMessaggio("Inserisci il causale");
		String causale=io.leggiRiga();
		table.insertValues(spesa, causale);		
	}

	public void insertUscita(){
		io.mostraMessaggio("Inserisci la spesa effettuata:");
		float spesa=io.leggiFloat();
		io.mostraMessaggio("Inserisci il causale");
		String causale=io.leggiRiga();
		table.insertValues(-spesa, causale);	
	}
	
	public void printWholeTable() {
		table.selectAllValues();
	}
	
	public void createDatabase() {
		table.createDatabase();
		table.createTable();
	}
	public void eliminationById() {
		io.mostraMessaggio("Inserisci l'id corrispettivo alla voce da eliminare:");
		int id=io.leggiInt();
		table.deleteValue(id);
		io.mostraMessaggio("Valore eliminato");
		io.Stop();
	}
	public void dropTable() {
		table.dropTable();
		io.mostraMessaggio("La table e` stata eliminata");
		table.createTable();
		io.Stop();
	}
}
