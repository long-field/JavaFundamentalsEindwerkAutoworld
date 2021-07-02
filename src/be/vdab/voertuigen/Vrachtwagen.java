package be.vdab.voertuigen;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.io.Serializable;

public class Vrachtwagen extends Voertuig implements Laadbaar {
    private static final long serialVersionUID = 1L;
    private Volume laadvolume;
    private int maximaalToegelatenMassa;
    private int aantalAssen;
    public Vrachtwagen(String merk, int aankoopprijs,  Volume volume, int maximaalToegelatenMassa,int aantalAssen){
        super(merk, aankoopprijs);
        setLaadvolume(volume);
        setMaximaalToegelatenMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
    }
    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        if(maximaalToegelatenMassa>0){
            this.maximaalToegelatenMassa = maximaalToegelatenMassa;}
    }
    public void setAantalAssen(int aantalAssen) {
        if (aantalAssen>0){
            this.aantalAssen = aantalAssen;}
    }
    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }
    @Override
    public void setLaadvolume(Volume volume) {
        if(volume.getVolume()<=0){
            throw new IllegalArgumentException("Het volume is niet correct.");
        }
        this.laadvolume=volume;
    }
    @Override
    public String toString(){
        return super.toString()+" , "+laadvolume.getVolume()+" , "+maximaalToegelatenMassa+" , " +aantalAssen;
    }
}

