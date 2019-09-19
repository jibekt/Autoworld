package be.vdab.voertuigen;

import java.io.Serializable;
import java.util.Objects;

public class Personenwagen extends Voertuig implements Serializable {
    private static final long serialVersionUID = 1L;
    private int zitPlaatsen = 1;

    public Personenwagen(String merk, int aankoopPrijs, int zitPlaatsen) {
        super(merk, aankoopPrijs);
        setZitplaatsen(zitPlaatsen);
    }

    public int getZitplaatsen() {
        return zitPlaatsen;
    }

    public void setZitplaatsen(int zitPlaatsen) {
        if (zitPlaatsen >= 0) {
            this.zitPlaatsen = zitPlaatsen;
        }
    }

    @Override
    public String toString() {

        return "Personenwagen " + super.toString() + " , aantal ziplaatsen: " + zitPlaatsen;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Personenwagen)) return false;

        Personenwagen personenwagen = (Personenwagen) o;
        return zitPlaatsen== personenwagen.zitPlaatsen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zitPlaatsen);
    }
}
