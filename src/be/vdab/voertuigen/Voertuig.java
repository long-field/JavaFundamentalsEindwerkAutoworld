package be.vdab.voertuigen;

import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.Nummerplaat;

import java.io.Serializable;

public abstract class Voertuig implements Comparable<Voertuig>, Serializable {
    private static final long serialVersionUID = 1L;
    private final Nummerplaat nummerplaat = Div.INSTANCE.getNummerplaat();
    private String merk;
    private int aankoopprijs;
    public Voertuig(String merk, int aankoopprijs) {
        setMerk(merk);
        setAankoopprijs(aankoopprijs);
    }
    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        if ((merk==null) || merk.trim().isEmpty()) {
            throw new IllegalArgumentException("Er is geen merk gegeven.");
        }
            this.merk =merk.trim();

    }
    public int getAankoopprijs() {
        return aankoopprijs;
    }
    public void setAankoopprijs(int aankoopprijs) {
        if (aankoopprijs >= 0) {
            this.aankoopprijs = aankoopprijs;
        }
    }
    @Override
    public String toString() {
        return nummerplaat + " , " + merk + " , " + aankoopprijs;
    }
    @Override
    public int hashCode() {
        return nummerplaat.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Voertuig)) {
            return false;
        }
        var v = (Voertuig) o;
        return nummerplaat.equals(v.getNummerplaat());
    }
    @Override
    public int compareTo(Voertuig v) {
        return nummerplaat.compareTo(v.getNummerplaat());
    }
}
