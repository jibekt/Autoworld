package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.io.Serializable;


public class Vrachtwagen extends Voertuig implements Laadbaar, Serializable {

    private static final long serialVersionUID = 1L;
    private Volume laadVolume;
    private int maximaalToegelatenMassa;
    private int aantalAssen;

    //public Vrachtwagen(){}
    public Vrachtwagen(String merk, int aankoopPrijs, Volume laadVolume,
                       int maximaalToegelatenMassa, int aantalAssen){
        super(merk, aankoopPrijs);
        setLaadVolume(laadVolume);
        setMaximaalToegelatenMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
    }

        public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        if (maximaalToegelatenMassa > 0) {
            this.maximaalToegelatenMassa = maximaalToegelatenMassa;
        }
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        if (aantalAssen > 0) {
            this.aantalAssen = aantalAssen;
        }
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
        return "Vrachtwagen " + super.toString() +
                ", laad volume = " + laadVolume +
                ", maximaal toegelaten massa=" + maximaalToegelatenMassa +
                ", aantal assen=" + aantalAssen;
    }
}
