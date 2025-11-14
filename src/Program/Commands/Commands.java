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
		LocalDate date=chooseDate();
		table.insertValues(spesa, causale,date.toString());		
	}

	public void insertUscita(){
		io.mostraMessaggio("Inserisci la spesa effettuata:");
		float spesa=io.leggiFloat();
		io.mostraMessaggio("Inserisci il causale");
		String causale=io.leggiRiga();
		LocalDate date=chooseDate();
		table.insertValues(-spesa, causale,date.toString());	
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
		io.mostraMessaggio("Sei sicuro di voler cancellare tutto? Digita 5 se sei sicuro (qualsiasi altro valore annullerà tutto)");
		int check=io.leggiInt();
		if (check!=5) {
			return;
		}
		table.dropTable();
		io.mostraMessaggio("La table e` stata eliminata");
		table.createTable();
		io.Stop();
	}
	
	public LocalDate chooseDate() {
		ClearScreen.clearConsole();
		LocalDate date=LocalDate.now();
		io.mostraMessaggio("##################Menu` Giorno##################\n"
				+ "Scegli una delle seguenti opzioni:"
				+ "1)Oggi\n"
				+ "2)Ieri\n"
				+ "3)L'altro ieri\n"
				+ "4)Domani\n"
				+ "5)Custom\n"
				+ "(qualsiasi altro valore darà come default oggi):");
		int check= io.leggiInt();
		switch (check) {
		case 2:
			date=date.minusDays(1);
			break;
		case 3:
			date=date.minusDays(2);
			break;
		case 4:
			date=date.plusDays(1);
			break;
		case 5:
			date=insertDate();
			break;
		default:
			break;
		}
		return date;
	}
	public LocalDate insertDate() {
		while(true) {
			ClearScreen.clearConsole();
			io.mostraMessaggio("Inserisci il giorno della data:");
			int day=io.leggiInt();
			io.mostraMessaggio("Inserisci il mese della data:");
			int month=io.leggiInt();
			io.mostraMessaggio("Inserisci l'anno della data:");
			int year=io.leggiInt();
			try {
				LocalDate date=LocalDate.of(year, month, day);
				return date;
			}catch (DateTimeException e) {
				io.mostraMessaggio("Data non esistente, riprova");
				io.Stop();
			}
		}
	}
	
	public float getSum() {
		return table.printSum();
	}

}