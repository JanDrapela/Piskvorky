package piskvorky;

public class Pocitac extends Hrac {
    public Pocitac(String jmeno, HraciKamen kamen) {
        super(jmeno, kamen);
    }

    @Override
    protected int[] vyberPole(HraciDeska deska) {
        //takze pro POCITAC zde bude naimplementovat algoritmus vyberu pole,
        //kam polozit hraci kamen.
        //jak to bude chytry zalezi na tobe;-)
        //jako uplny zaklad muzes naimplementovat "blbecka", treba takto:
        // iteruj pres vsechny pole hraci desky a vyber prvni prazdny pole

        //...pak to budes zkokonalovat, dokonce ve finale muzes mit vice
        //impelmentaci a volit "uroven"

        //dalsi popis viz. trida "Clovek"
        return new int[2];
    }
}
