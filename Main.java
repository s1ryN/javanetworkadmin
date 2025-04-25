import java.util.List;
import java.util.Scanner;

import model.Pocitac;
import model.SitovyPrvek;
import model.Tiskarna;
import model.Uzivatel;
import sprava.SpravaSystemu;

/**
 * CLI verze Spravy systemu, nahrazuje GUI.
 * Vyčistí terminál před každou operací a čeká na Enter
 * pro pokračování po dokončení akce.
 */
public class Main {

    /** Vyčistí obrazovku v podporovaných konzolích (Unix, moderní Windows). */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        SpravaSystemu sprava = new SpravaSystemu();
        Scanner sc = new Scanner(System.in);

        while (true) {
            clearScreen();
            System.out.println("=== Sprava systemu ===");
            System.out.println("1. Pridat uzivatele");
            System.out.println("2. Pridat pocitac");
            System.out.println("3. Pridat tiskarnu");
            System.out.println("4. Odebrat");
            System.out.println("5. Zobraz vse");
            System.out.println("0. Konec");
            System.out.print("Vyberte moznost: ");

            int volba;
            try {
                volba = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Neplatna volba.");
                pause(sc);
                continue;
            }

            switch (volba) {
                case 1:
                    clearScreen();
                    System.out.print("Jmeno: ");
                    String jmeno = sc.nextLine();
                    System.out.print("Prijmeni: ");
                    String prijmeni = sc.nextLine();
                    System.out.print("Uziv. jmeno: ");
                    String uzj = sc.nextLine();
                    System.out.print("Heslo: ");
                    String heslo = sc.nextLine();
                    sprava.pridat(new Uzivatel(jmeno, prijmeni, uzj, heslo));
                    System.out.println("Uživatel přidán.");
                    break;

                case 2:
                    clearScreen();
                    System.out.print("Nazev pocitace: ");
                    String nazevPc = sc.nextLine();
                    System.out.print("IP adresa: ");
                    String ipPc = sc.nextLine();
                    System.out.print("OS: ");
                    String os = sc.nextLine();
                    sprava.pridat(new Pocitac(nazevPc, ipPc, os));
                    System.out.println("Počítač přidán.");
                    break;

                case 3:
                    clearScreen();
                    System.out.print("Nazev tiskarny: ");
                    String nazevT = sc.nextLine();
                    System.out.print("IP adresa: ");
                    String ipT = sc.nextLine();
                    System.out.print("Barevna? (true/false): ");
                    boolean barevna;
                    try {
                        barevna = Boolean.parseBoolean(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Neplatna hodnota, předpokládá se false.");
                        barevna = false;
                    }
                    sprava.pridat(new Tiskarna(nazevT, ipT, barevna));
                    System.out.println("Tiskárna přidána.");
                    break;

                case 4:
                    clearScreen();
                    List<Uzivatel> uzivatele = sprava.getUzivatele();
                    List<SitovyPrvek> zarizeni = sprava.getZarizeni();

                    System.out.println("--- Uzivatele ---");
                    for (int i = 0; i < uzivatele.size(); i++) {
                        System.out.printf("U%d: ", i);
                        uzivatele.get(i).vypisInfo();
                    }
                    System.out.println("--- Zarizeni ---");
                    for (int i = 0; i < zarizeni.size(); i++) {
                        System.out.printf("D%d: ", i);
                        zarizeni.get(i).vypisInfo();
                    }

                    System.out.print("Zadejte U# nebo D# pro odebrání: ");
                    String sel = sc.nextLine().trim();
                    if (sel.length() > 1 && (sel.charAt(0) == 'U' || sel.charAt(0) == 'D')) {
                        char type = sel.charAt(0);
                        String num = sel.substring(1);
                        try {
                            int idx = Integer.parseInt(num);
                            uzivatele = sprava.getUzivatele();
                            zarizeni = sprava.getZarizeni();
                            if (type == 'U' && idx >= 0 && idx < uzivatele.size()) {
                                sprava.odebrat(uzivatele.get(idx));
                                System.out.println("Uživatel odstraněn.");
                            } else if (type == 'D' && idx >= 0 && idx < zarizeni.size()) {
                                sprava.odebrat(zarizeni.get(idx));
                                System.out.println("Zařízení odstraněno.");
                            } else {
                                System.out.println("Neplatný index.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Číslo za U/D musí být platné číslo.");
                        }
                    } else {
                        System.out.println("Neplatný formát vstupu.");
                    }
                    break;

                case 5:
                    clearScreen();
                    sprava.zobrazVse();
                    break;

                case 0:
                    clearScreen();
                    System.out.println("Konec programu.");
                    sc.close();
                    return;

                default:
                    System.out.println("Neplatna volba.");
            }

            pause(sc);
        }
    }

    /** Pauza do stisknutí Enter, před vyčištěním další smyčky. */
    private static void pause(Scanner sc) {
        System.out.println("\n(Enter pro pokračování)");
        sc.nextLine();
    }
}
