
package sprava;

import java.util.ArrayList;

import model.SitovyPrvek;
import model.Spravovatelne;
import model.Uzivatel;

public class SpravaSystemu implements Spravovatelne {
    private ArrayList<Uzivatel> uzivatele = new ArrayList<>();
    private ArrayList<SitovyPrvek> zarizeni = new ArrayList<>();

    @Override
    public void pridat(Object o) {
        if (o instanceof Uzivatel) {
            uzivatele.add((Uzivatel) o);
        } else if (o instanceof SitovyPrvek) {
            zarizeni.add((SitovyPrvek) o);
        }
    }

    @Override
    public void odebrat(Object o) {
        if (o instanceof Uzivatel) {
            uzivatele.remove(o);
        } else if (o instanceof SitovyPrvek) {
            zarizeni.remove(o);
        }
    }
    

    @Override
    public void zobrazVse() {
        System.out.println("--- Uživatelé ---");
        for (Uzivatel u : uzivatele) u.vypisInfo();
        System.out.println("--- Zařízení ---");
        for (SitovyPrvek d : zarizeni) d.vypisInfo();
    }
    

    public ArrayList<Uzivatel> getUzivatele() {
        return uzivatele;
    }

    public ArrayList<SitovyPrvek> getZarizeni() {
        return zarizeni;
    }

}
