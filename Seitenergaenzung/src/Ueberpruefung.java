import java.util.ArrayList;
import java.util.Scanner;

public abstract class Ueberpruefung {

	ArrayList<Integer> zahlListe = new ArrayList<Integer>();
	String[] zahlListenAusgabe;

	int eingaben;
	int naechsteZahl;

	int posVonVorhandene;

	// LFU
	int[] haeufigkeit;
	int[] alter;

	// secondChance
	boolean[] secondchance;

	public void anzahlVonSeiten() {

		Scanner sc = new Scanner(System.in);
		int x = 99;

		while (x < 2 || x > 6) {
			System.out.println("Bitte Seitenanzahl 2-6 wählen.");
			x = sc.nextInt();
			if (x < 2 || x > 6) {
				System.out.println("Ungültige Anzahl an Seiten.");
			}
		}

		zahlListenAusgabe = new String[x + 1];

		if (this instanceof LFU) {
			haeufigkeit = new int[x];
			alter = new int[x];
		} else if (this instanceof SECONDCHANCE) {
			secondchance = new boolean[x];
		}

		zahlListenAusgabe[0] = "Chronik: ";
		for (int i = 1; i <= x; i++) {
			zahlListe.add(0);
			if (this instanceof LFU) {
				haeufigkeit[i - 1] = 0;
				alter[i - 1] = 0;
			} else if (this instanceof SECONDCHANCE) {
				secondchance[i - 1] = false;
			}
			zahlListenAusgabe[i] = "Seite " + i + ": ";
		}
		eingaben = anzahlEingaben();
	}

	public boolean zahlBereitsInDerListe() {
		boolean a = false;
		for (int i = 0; i < zahlListe.size(); i++) {
			if (zahlListe.get(i) == naechsteZahl) {
				posVonVorhandene = i;
				a = true;
			}
		}
		return a;
	}

	public int ueberpruefeNullstellenInListe() {
		int n = 99;
		for (int i = 0; i < zahlListe.size(); i++) {
			if (zahlListe.get(i) == 0) {
				n = i;
				break;
			}
		}
		return n;
	}

	public boolean ueberpruefeEingabeVonZahl(int x) {
		boolean a = false;
		if (x >= 1 && x <= 9) {
			a = true;
		}
		return a;
	}

	public int anzahlEingaben() {
		System.out.println("Wieviele Eingaben?");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		return x;
	}

	public int eingabeVonZahl() {
		System.out.println("Zahl zwischen 1 - 9 eingeben:");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		return x;

	}

	public void erstelleAusgabe() {
		zahlListenAusgabe[0] += naechsteZahl + " ";
		for (int i = 0; i < zahlListe.size(); i++) {
			zahlListenAusgabe[i + 1] += zahlListe.get(i) + " ";
		}

		for (int i = 0; i < zahlListenAusgabe.length; i++) {
			System.out.println(zahlListenAusgabe[i]);
		}
	}

	public void naechsteZahlBestimmen() {
		boolean a = false;
		do {
			naechsteZahl = eingabeVonZahl();
			if (ueberpruefeEingabeVonZahl(naechsteZahl)) {
				a = true;
			} else {
				System.out.println("Ungültige Zahl eingegeben.");
			}
		} while (!a);
	}

	// LFU-Methode
	public int getLFUreplaceSlot() {
		int minAlt = alter[0];
		int minHaeufig = haeufigkeit[0];
		int t = 0;
		for (int i = 1; i < zahlListe.size(); i++) {
			if (minHaeufig > haeufigkeit[i]) {
				minAlt = alter[i];
				minHaeufig = haeufigkeit[i];
				t = i;
			} else if (minHaeufig == haeufigkeit[i]) {
				if (minAlt < alter[i]) {
					minAlt = alter[i];
					t = i;
				}
			}
		}
		return t;
	}

	public int getSCreplaceSlot(int c) {
		boolean replaced = false;
		while (!replaced) {
			if (c == secondchance.length) {
				c = 0;
			}
			if (secondchance[c]) {
				secondchance[c] = false;
				c++;
			} else {
				replaced = true;
			}
		}
		return c;
	}

}
