package be.vdab.util;


import java.io.Serializable;


public final class Volume implements Comparable<Volume>, Serializable {
    private static final long serialVersionUID = 1L;
    final int breedte;
    final int hoogte;
    final int diepte;
    final Maat maat;

    public Volume(int breedte, int hoogte, int diepte, Maat maat) throws VolumeException {
        if (breedte > 0) {
            this.breedte = breedte;
        } else {
            throw new VolumeException("Breedte moet > 0 zijn");
        }

        if (hoogte > 0) {
            this.hoogte = hoogte;
        } else {
            throw new VolumeException("Hoogte moet > 0 zijn");
        }

        if (diepte > 0) {
            this.diepte = diepte;
        } else {
            throw new VolumeException("Diepte moet > 0 zijn");
        }
        this.maat = maat;
    }


    public long getVolume() {
        return breedte * hoogte * diepte;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Volume)) {
            return false;
        }
        Volume volume = (Volume) o;
        return breedte == volume.breedte &&
                hoogte == volume.hoogte &&
                diepte == volume.hoogte &&
                maat == volume.maat;
    }

    @Override
    public int compareTo(Volume o) {
        Long l = getVolume();

        return l.compareTo(o.getVolume());
    }

    @Override
    public String toString() {
        return "" + getVolume() + Maat.CENTIMETER.getValue();
    }
}
