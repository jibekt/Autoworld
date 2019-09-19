package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.util.Objects;

public class Pickup extends Personenwagen implements Laadbaar {
    private Volume laadVolume;

    public Pickup(String merk, int aankoopPrijs, int zitPlaatsen, Volume laadVolume) {
        super(merk, aankoopPrijs, zitPlaatsen);
        this.laadVolume = laadVolume;
    }

    @Override
    public Volume getLaadVolume() {
        return laadVolume;
    }

    @Override
    public void setLaadVolume(Volume laadVolume) {
        if (laadVolume != null) {
            this.laadVolume = laadVolume;
        }
    }

    @Override
    public String toString() {
        return "Pickup " + super.toString() +
                ", laad volume = " + laadVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pickup)) return true;

        Pickup pickup = (Pickup) o;
        return Objects.equals(laadVolume, pickup.laadVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), laadVolume);
    }
}
