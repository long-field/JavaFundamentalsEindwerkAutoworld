package be.vdab.voertuigen.div;
import java.io.Serializable;
import java.util.Objects;

public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    private static final long serialVersionUID = 1L;
    protected String nummerplaat;
    public Nummerplaat(String plaat) {
        this.nummerplaat = plaat;
    }
    public String getPlaat() {
        return nummerplaat;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nummerplaat that = (Nummerplaat) o;
        return Objects.equals(nummerplaat, that.nummerplaat);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nummerplaat);
    }
    @Override
    public String toString() {
        return getPlaat();
    }
    @Override
    public int compareTo(Nummerplaat o) {
        return nummerplaat.compareTo(o.nummerplaat);
    }
}
