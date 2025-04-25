
package model;

public abstract class SitovyPrvek {
    protected String nazev;
    protected String ipAdresa;

    public SitovyPrvek(String nazev, String ipAdresa) {
        this.nazev = nazev;
        this.ipAdresa = ipAdresa;
    }

    public String getNazev() { return nazev; }
    public String getIpAdresa() { return ipAdresa; }

    public abstract void vypisInfo();
}
