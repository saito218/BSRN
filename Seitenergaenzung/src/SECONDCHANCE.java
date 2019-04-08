
public class SECONDCHANCE extends Ueberpruefung {

	SECONDCHANCE() {
		System.out.println("Methode: Second Chance");
		anzahlVonSeiten();

		int counter = 0;
		for (int i = 1; i <= eingaben; i++) {
			naechsteZahlBestimmen();

			if (!zahlBereitsInDerListe()) {
				int n = ueberpruefeNullstellenInListe();
				if (n != 99) {
					zahlListe.set(n, naechsteZahl);
					counter = n + 1;
				} else {
					int t = getSCreplaceSlot(counter);
					zahlListe.set(t, naechsteZahl);
					counter = t + 1;
				}
			} else {
				secondchance[posVonVorhandene] = true;
				counter = posVonVorhandene + 1;
			}
			erstelleAusgabe();
		}

	}

}
