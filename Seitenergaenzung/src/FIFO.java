
public class FIFO extends Ueberpruefung {

	FIFO() {
		System.out.println("Methode: FIFO");

		anzahlVonSeiten();
		int fifo = 0;

		for (int i = 1; i <= eingaben; i++) {
			naechsteZahlBestimmen();

			if (!zahlBereitsInDerListe()) {
				int n = ueberpruefeNullstellenInListe();
				if (n != 99) {
					zahlListe.set(n, naechsteZahl);
				} else {
					zahlListe.set(fifo, naechsteZahl);
					fifo++;
					if (fifo > zahlListe.size() - 1) {
						fifo = 0;
					}
				}
			}
			erstelleAusgabe();
		}
	}
}
