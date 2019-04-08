
public class LRU extends Ueberpruefung {

	LRU() {
		System.out.println("Methode: LRU");

		anzahlVonSeiten();

		for (int i = 1; i <= eingaben; i++) {
			naechsteZahlBestimmen();
			if (zahlBereitsInDerListe()) {
				zahlListe.remove(posVonVorhandene);
				zahlListe.add((int) 0);
				zahlListe.set(ueberpruefeNullstellenInListe(), naechsteZahl);
			} else {
				int n = ueberpruefeNullstellenInListe();
				if (n != 99) {
					zahlListe.set(n, naechsteZahl);
				} else {
					zahlListe.remove(0);
					zahlListe.add(naechsteZahl);
				}
			}
			erstelleAusgabe();
		}
	}
}
