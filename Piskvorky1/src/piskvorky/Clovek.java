package piskvorky;

public class Clovek extends Hrac {

    public Clovek(String jmeno, HraciKamen kamen) {
        super(jmeno, kamen);
    }

    @Override
    protected int[] vyberPole(HraciDeska deska) {
        //TODO: pro cloveka to zde bude znamenat:
        //vypsat na std vystup neco typu: "Zadejte souradnice por polozeni kamene"
        //presist vstup
        //validovat
        //...a pouzit jako navratovou hodnotu (viz. dale)

        //TODO: opravit, vracene pole MUSI mit delku 2, pod indexem 0 je x souradnice,
        // pod indexem 1 y souradnice
        int[] souradnice = new int[2];
        //x souradnice souradnice[0] =
        //y souradnice souradnice[1] =

        return  souradnice;
    }
}
