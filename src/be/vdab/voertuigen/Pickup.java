package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

public class Pickup extends Personenwagen implements Laadbaar {
    private static final long serialVersionUID = 1L;
    private Volume laadvolume;
    public Pickup(String merk, int aankoopprijs, int zitplaatsen, Volume volume) {
        super(merk, aankoopprijs, zitplaatsen);
        setLaadvolume(volume);
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
        return super.toString()+" , "+laadvolume.getVolume();
    }
}
