package Program.Commands;

public class ClearScreen {
	public static void clearConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
		} catch (Exception e) {
			System.out.println("Error trying to clear console.");
		}
	}
}