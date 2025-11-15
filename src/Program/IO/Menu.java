package Program.IO;
import java.time.LocalDate;
import java.time.DayOfWeek;
import Program.Commands.*;

public class Menu {
	IO io;
	ClearScreen clear;
	int check;
	Commands comandi;
	public Menu(IO io, Commands comandi){
		this.io=io;
		check=1;
		this.comandi=comandi;
	}
	public void MenuPrincipale() {
		comandi.createDatabase();
		while(true) {
			clearConsole();
			io.mostraMessaggio("##################Menu` Principale##################");
			System.out.printf("Budget disponibile:%.2f|Soldi spesi ultima settimana:%.2f\n",comandi.getSum(),-comandi.getSumOfWeek());
			io.mostraMessaggio("Seleziona ciò che vuoi fare\n"
					+ "1)Inserire dei valori nel database\n"
					+ "2)eliminare dei valori dal database\n"
					+ "3)Stampare a schermo i valori del database\n"
					+ "Scrivi qualsiasi altro valore per chiudere il programma\n"
					+ "Inserisci qui il valore:");
			check=io.leggiInt();
			switch (check) {
			case 1:
				MenuInsert();
				break;
			case 2:
				MenuErase();
				break;
			case 3: 
				MenuPrintChoice();
				break;
			default:
				return;
			}
		}
	}
	public void MenuInsert() {
		clearConsole();
		io.mostraMessaggio("##################Menu` Inserimento##################\n"
				+ "Seleziona ciò che vuoi fare\n"
				+ "1)Entrata\n"
				+ "2)Uscita\n"
				+ "Scrivi qualsiasi altro valore per tornare indietro\n"
				+ "Inserisci qui il valore:");
		check=io.leggiInt();
		switch (check) {
		case 1:
			clearConsole();
			comandi.insertEntrata();
			break;
		case 2:
			clearConsole();
			comandi.insertUscita();
			break;
		default: 
			break;
		}
	}
	public void MenuPrintChoice() {
		clearConsole();
		io.mostraMessaggio("##################Menu` Stampa##################\n"
				+ "Seleziona una delle seguenti opzioni:\n"
				+ "1)Ultima Settima\n"
				+ "2)Ultimo Mese\n"
				+ "3)Tutto lo storico\n"
				+ "4)Custom\n"
				+ "Scrivi qualsiasi altro valore per tornare indietro\n");
		int check=io.leggiInt();
		switch (check) {
		case 1:
			clearConsole();
			comandi.printTableByDate(LocalDate.now().with(DayOfWeek.MONDAY).toString(),LocalDate.now().with(DayOfWeek.SUNDAY).toString());
			break;
		case 2:
			clearConsole();
			comandi.printTableByDate(LocalDate.now().withDayOfMonth(1).toString(),LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()).toString());
			break;
		case 3:
			clearConsole();
			comandi.printWholeTable();
			break;
		case 4:
			clearConsole();
			io.mostraMessaggio("Inseriamo la prima data");
			LocalDate date1=comandi.insertDate();
			io.mostraMessaggio("Inseriamo la seconda data");
			LocalDate date2=comandi.insertDate();
			comandi.printTableByDate(date1.toString(), date2.toString());
			break;
		default:
			break;
		}
		io.Stop();
		return;
	}	


	/*	public void MenuPrint() {
		io.mostraMessaggio("##################Menu` Stampa##################\n"
				+ "Print Table:");
		comandi.printWholeTable();
		io.Stop();
		return;
	}*/
	public void clearConsole() {
		ClearScreen.clearConsole();
	}

	public void MenuErase() {
		clearConsole();
		io.mostraMessaggio("##################Menu` Eliminazione##################\n"
				+ "Seleziona ciò che vuoi fare\n"
				+ "1)Eliminare un valore (dato l'id)\n"
				+ "2)Eliminare tutti i valori\n"
				+ "Scrivi qualsiasi altro valore per tornare indietro\n"
				+ "Inserisci qui il valore:");
		check=io.leggiInt();
		switch (check) {
		case 1:
			clearConsole();
			comandi.eliminationById();
			break;
		case 2:
			clearConsole();
			comandi.dropTable();
			break;
		default: 
			break;
		}
	}
}
