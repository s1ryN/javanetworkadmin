
package model;

public class Tiskarna extends SitovyPrvek {
    private boolean barevna;

    public Tiskarna(String nazev, String ipAdresa, boolean barevna) {
        super(nazev, ipAdresa);
        this.barevna = barevna;
    }

    public void vypisInfo() {
        System.out.println("Tiskárna: " + nazev + ", IP: " + ipAdresa + ", Barevná: " + barevna);
    }

    public boolean isBarevna() {
        return barevna;
    }

}
