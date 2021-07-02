package be.vdab.util;
import java.io.Serializable;
import java.util.Objects;
public class Volume implements Comparable<Volume>, Serializable {
    private static final long serialVersionUID = 1L;
    private long volume;
    private  int breedte;
    private   int hoogte;
    private  int diepte;
    private  Maat maat;

    public Volume(int breedte, int hoogte, int diepte, Maat maat) throws VolumeException {
       setBreedte(breedte);
       setDiepte(diepte);
       setHoogte(hoogte);
       setMaat(maat);
       this.volume=getVolume();
    }
    public int getBreedte() {
        return breedte;
    }
    private final void setBreedte(int breedte) throws VolumeException {
        if(breedte >0){
        this.breedte = breedte;
        }
        else {throw new VolumeException("Geef een correcte breedte.");}
    }
    public int getHoogte() {
        return hoogte;
    }
    private final void setHoogte(int hoogte) throws VolumeException {
        if(hoogte >0){
        this.hoogte = hoogte;}
        else {throw new VolumeException("Geef een correcte hoogte.");}
    }
    public int getDiepte() {
        return diepte;
    }
    private final void setDiepte(int diepte) throws VolumeException {
        if(diepte >0){
        this.diepte = diepte;}
        else {throw new VolumeException("Geef een correcte diepte.");}
    }
    public Maat getMaat() {
        return maat;
    }

    private final void setMaat(Maat maat) throws VolumeException {
        if (maat == null){throw new VolumeException("Geef de juiste factor.");}
        else  this.maat = maat;
    }
    public long getVolume() {
        return (long) breedte * hoogte * diepte * maat.getFactor();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Volume)) return false;
        Volume volume1 = (Volume) o;
        return getVolume() == volume1.getVolume();
    }
    @Override
    public int compareTo(Volume o) {
        return (int) (volume - o.getVolume());
    }
    @Override
    public int hashCode() {   //Nodig?
        return Objects.hash(getVolume());
    }
}
