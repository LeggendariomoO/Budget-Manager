package Program.Commands;

import java.time.DateTimeException;
import java.time.LocalDate;

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
		LocalDate data=selectDate();
		table.insertValues(spesa, causale,data.toString());		
	}

	public void insertUscita(){
		io.mostraMessaggio("Inserisci la spesa effettuata:");
		float spesa=io.leggiFloat();
		io.mostraMessaggio("Inserisci il causale");
		String causale=io.leggiRiga();
		LocalDate data=selectDate();
		table.insertValues(-spesa, causale,data.toString());	
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
		io.mostraMessaggio("Sei sicuro di voler eliminare tutto? Scrivi 5 se confermi o qualsiasi altro valore se non vuoi procedere");
		int check=io.leggiInt();
		switch (check) {
		case 5:
			table.dropTable();
			io.mostraMessaggio("La table e` stata eliminata");
			table.createTable();
			io.Stop();
			break;
		default:
			return;}
	}

	public float getSum() {
		return table.printSum();
	}

	public LocalDate selectDate() {
		ClearScreen.clearConsole();;
		io.mostraMessaggio("Seleziona una delle seguenti opzioni per la data:\n"
				+ "1)Oggi\n"
				+ "2)Ieri\n"
				+ "3)AltroIeri\n"
				+ "4)Custom Data\n"
				+ "(qualsiasi altra opzione darà come default oggi):");
		int check=io.leggiInt();
		LocalDate data= LocalDate.now();
		switch (check) {
		case 2:
			data=LocalDate.now().minusDays(1);
			break;
		case 3:
			data=LocalDate.now().minusDays(2);
			break;
		case 4:	
			data=insertDate();
			break;
		default:		
			break;

		}
		return data;
	}

	public LocalDate insertDate() {
		while(true) {
			io.mostraMessaggio("Inserisci il giorno:");
			int day=io.leggiInt();

			io.mostraMessaggio("Inserisci il mese:");
			int month=io.leggiInt();
			io.mostraMessaggio("Inserisci il giorno:");
			int year=io.leggiInt();
			try {
				LocalDate date = LocalDate.of(year, month, day);
				return date;
				}
			catch (DateTimeException e) {
				io.mostraMessaggio("Data non esiste, riprova\n");
			}
		}
	}
}
