
package model;

public class Uzivatel extends Osoba {
    private String uzivatelskeJmeno;
    private String heslo;

    public Uzivatel(String jmeno, String prijmeni, String uzivatelskeJmeno, String heslo) {
        super(jmeno, prijmeni);
        this.uzivatelskeJmeno = uzivatelskeJmeno;
        this.heslo = heslo;
    }

    public String getUzivatelskeJmeno() { return uzivatelskeJmeno; }
    public String getHeslo() { return heslo; }

    public void vypisInfo() {
        System.out.println(jmeno + " " + prijmeni + " (" + uzivatelskeJmeno + ")");
    }
}
