package be.vdab.voertuigen;

import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.Objects;

public abstract class Voertuig implements Comparable<Voertuig>, Serializable {
    private static final long serialVersionUID=1L;
    private final Nummerplaat nummerplaat = Div.INSTANCE.getNummerplaat();
    private String merk;
    private int aankoopPrijs;


    public Voertuig(String merk, int aankoopPrijs) {
        setMerk(merk);
        setAankoopPrijs(aankoopPrijs);

    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        if (merk != null) {
            this.merk = merk;
        }
    }

    public int getAankoopPrijs() {
        return aankoopPrijs;
    }

    public void setAankoopPrijs(int aankoopPrijs) {
        if (aankoopPrijs >= 0) {
            this.aankoopPrijs = aankoopPrijs;
        }
    }

    @Override
    public String toString() {
        return "merk = " + merk + ", aankoop prijs = " + aankoopPrijs;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Voertuig)){
            return false;
        }

        Voertuig voertuig = (Voertuig) o;
        return nummerplaat.equals(voertuig.nummerplaat);
    }


    @Override
    public int hashCode() {
        return Objects.hash(nummerplaat);
    }


    @Override
    public int compareTo(Voertuig o) {
        return nummerplaat.compareTo(o.nummerplaat);
    }


}
