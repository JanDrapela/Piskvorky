package piskvorky;

/**
 * Pole hraci desky, na krere se umistuje hraci "kamen"
 */
public class HraciPole {
    private HraciKamen kamen;

    public boolean jeVolne() {
        return kamen == null;
    }

    public void polozKamen(HraciKamen kamen) {
        if (jeVolne()) {
            this.kamen = kamen;
        } else {
            //zde vyhazujeme tzv. "unchecked" vyjimku, nebot se jedna o
            //situaci, ktera by nemela nastat a znamena chybu v programu
            throw new IllegalArgumentException("hraci pole je jiz obsazene");
        }
    }

    /**
     * Zobrazi kamen vlozeny na pole, pokud je prazdne, zobrazi tecku "."
     */
    public void zobraz() {
        System.out.print(kamen == null ? "." : kamen.name());
    }

    
}
