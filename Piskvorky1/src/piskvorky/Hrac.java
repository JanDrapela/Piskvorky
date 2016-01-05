package piskvorky;

public abstract class Hrac {

    private final String jmeno;

    private final HraciKamen kamen;

    public Hrac(String jmeno, HraciKamen kamen) {
        this.jmeno = jmeno;
        this.kamen = kamen;
    }

    /**
     * Tato metoda uskutecnuje "tah" hrace,
     * tj. polozeni hraciho kamene na hraci desku
     */
    public void tahni(HraciDeska deska) {
        int[] souradnice = vyberPole(deska);
        int x = souradnice[0];
        int y = souradnice[1];
        deska.polozKamen(x, y, kamen);
    }

    /**
     * Tato metoda musi byt naimplementovana v potomcich teto tridy
     *
     * @return souradnice pro polozeni kamene [x,y]
     */
    protected abstract int[] vyberPole(HraciDeska deska);

}
