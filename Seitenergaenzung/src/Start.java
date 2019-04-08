import java.util.Scanner;

public class Start {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Bitte Seitenergänzungsmethode wählen.");
			System.out.println("1) FIFO");
			System.out.println("2) LRU");
			System.out.println("3) LFU");
			System.out.println("4) 2nd Chance");

			int auswahl = sc.nextInt();

			while (auswahl < 1 || auswahl > 4) {
				System.out.println("Ungültige Auswahl. 1) FIFO 2) LRU 3) LFU 4) 2nd Chance");
				auswahl = sc.nextInt();
			}

			switch (auswahl) {
			case 1:
				new FIFO();
				break;
			case 2:
				new LRU();
				break;
			case 3:
				new LFU();
				break;
			case 4:
				new SECONDCHANCE();
				break;
			}

		} catch (Exception e) {
			System.out.println("Ungültige Eingabe. Bitte Programm neu starten.");
		}

	}

}
