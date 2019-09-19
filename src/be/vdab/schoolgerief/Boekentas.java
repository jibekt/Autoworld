package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.io.Serializable;
import java.util.Objects;

public class Boekentas implements Laadbaar, Serializable {
    private static final long serialVersionUID=1L;
    private String kleur;
    private Volume laadVolume;

    public Boekentas(String kleur, Volume laadVolume){
        this.kleur = kleur;
        setLaadVolume(laadVolume);
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) throws IllegalArgumentException{
        if (!kleur.isEmpty()) {
            this.kleur = kleur;
        }
    }

    @Override
    public Volume getLaadVolume() {
        return laadVolume;
    }

    @Override
    public void setLaadVolume(Volume laadVolume) throws IllegalArgumentException{
        if (laadVolume != null){
            this.laadVolume = laadVolume;
        }
    }

    @Override
    public String toString() {
        return "Boekentas " +
                "kleur =" + kleur + ", laad volume = " + laadVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Boekentas)) return false;

        Boekentas boekentas = (Boekentas) o;
        return Objects.equals(kleur, boekentas.kleur) &&
                Objects.equals(laadVolume, boekentas.laadVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kleur, laadVolume);
    }
}
