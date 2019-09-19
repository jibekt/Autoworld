package be.vdab.voertuigen.div;

import java.io.Serializable;

public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    private static final long serialVersionUID=1L;
    private final String PLAAT;

    public Nummerplaat(String plaat) {
        this.PLAAT = plaat;
    }

    public String getPlaat() {
        return PLAAT;
    }

    @Override
    public String toString() {
        return PLAAT;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Nummerplaat)) {
            return false;
        }

        Nummerplaat nummerplaat = (Nummerplaat) o;

        return PLAAT.equals(nummerplaat.PLAAT);

    }

    @Override
    public int hashCode() {
        return PLAAT.hashCode();
    }

    @Override
    public int compareTo(Nummerplaat o) {
        return PLAAT.compareTo(o.getPlaat());
    }
}
