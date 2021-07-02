package be.vdab.voertuigen;
import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
public class Personenwagen extends Voertuig {
    private static final long serialVersionUID = 1L;
    private int zitplaatsen =1;

    public Personenwagen(String merk, int aankoopprijs, int zitplaatsen){
        super(merk,aankoopprijs);
             setZitplaatsen(zitplaatsen);
    }
    public void setZitplaatsen(int zitplaatsen) {
        if (zitplaatsen > 0) {
        this.zitplaatsen = zitplaatsen;}
    }

    @Override
    public String toString(){
       return super.toString()+" , "+zitplaatsen;
    }
}
