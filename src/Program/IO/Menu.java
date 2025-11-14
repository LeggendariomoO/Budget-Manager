package Program.IO;
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
			System.out.printf("Budget disponibile:%.2f\n",comandi.getSum());
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
				MenuPrint();
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
	public void MenuPrint() {
		io.mostraMessaggio("##################Menu` Stampa##################\n"
				+ "Print Table:");
		comandi.printWholeTable();
		io.Stop();
		return;
	}
	public void clearConsole() {
		ClearScreen.clearConsole();
	}

	public void MenuErase() {
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
