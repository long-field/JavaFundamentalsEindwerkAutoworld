package be.vdab.schoolgerief;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.io.Serializable;
import java.util.Objects;

public class Boekentas implements Laadbaar, Serializable {
    private static final long serialVersionUID = 1L;
    private String kleur;
    private Volume laadvolume;

    public Boekentas(String kleur, Volume volume) {
        setKleur(kleur);
        setLaadvolume(volume);
    }
    public void setLaadvolume(Volume volume) {
        if(volume.getVolume()<=0){
            throw new IllegalArgumentException("Het volume is niet correct.");
        }
        this.laadvolume=volume;
    }
    public Volume getLaadvolume() {
        return laadvolume;
        }
    public String getKleur() {
        return kleur;
    }
    public void setKleur(String kleur) {

        if ((kleur==null) || kleur.trim().isEmpty()) {
           throw new IllegalArgumentException("Er is geen kleur gegeven.");
        }
        this.kleur = kleur.trim();
    }

    @Override
    public String toString(){
        return kleur +" , " + laadvolume.getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boekentas)) return false;
        Boekentas boekentas = (Boekentas) o;
        return getKleur().equals(boekentas.getKleur()) &&
                getLaadvolume().equals(boekentas.getLaadvolume());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKleur(), getLaadvolume());
    }
}
