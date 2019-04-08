
public class LFU extends Ueberpruefung {
	LFU() {
		System.out.println("Methode: LFU");

		anzahlVonSeiten();

		for (int i = 1; i <= eingaben; i++) {
			naechsteZahlBestimmen();

			if (!zahlBereitsInDerListe()) {
				int n = ueberpruefeNullstellenInListe();
				if (n != 99) {
					zahlListe.set(n, naechsteZahl);
					alter[n] = 0;
					haeufigkeit[n] = 1;
				} else {
					int t = getLFUreplaceSlot();
					zahlListe.set(t, naechsteZahl);
					alter[t] = 0;
					haeufigkeit[t] = 1;
				}
			} else {
				haeufigkeit[posVonVorhandene]++;
			}

			for (int j = 0; j < alter.length; j++) {
				alter[j]++;
			}

			erstelleAusgabe();
		}
	}
}
