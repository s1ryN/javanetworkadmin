
package model;

public class Pocitac extends SitovyPrvek {
    private String os;

    public Pocitac(String nazev, String ipAdresa, String os) {
        super(nazev, ipAdresa);
        this.os = os;
    }

    public void vypisInfo() {
        System.out.println("Zařízení: " + nazev + ", IP: " + ipAdresa + ", OS: " + os);
    }

    public String getOs() {
        return os;
    }

}
