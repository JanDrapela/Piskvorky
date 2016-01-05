package piskvorky;

/**
 * hraci deska na ktere se hraje. Obsahuje heaci pole,
 * na ktere se umistuji hraci "kameny"
 */
public class HraciDeska {

    //predpokladame, ze hraci pole je ctvercove
    private final int rozmer;

    /**
     * delka sekvence, ktera urcuje viteze. Priklad:
     * - hodnota je 3
     * - potom pokud mame na desce posloupnost napr. OOO je to vitezna sekvence
     */
    private final int delkaSekvence;

    /**
     * POZOR - index pole v Jave zacina 0, takze levy horni roh ma souradnice [0,0]
     * a pravy dolni [rozmer-1,rozmer-1]
     * Predpokladame tedy, ze pozice na desce se urcuje dle vyse uvedeneho
     */
    //pokud chces pouzivat jine souradnice napr, [A,5] tak to samozrejme lze, ale prislusne upravy uz ponecham na tobe...
    private final HraciPole[][] hraciPole;

    public HraciDeska(int rozmer, int delkaSekvence) {
        this.rozmer = rozmer;
        this.delkaSekvence = delkaSekvence;

        //TODO: kontrola vstupnich parametru - napada te, co zde musime ohlidat?

        hraciPole = new HraciPole[rozmer][rozmer];
        //TODO: inicializovat hraci desku, tj. naplnit matici hracich poli
        //napoveda: hraciPole[x][y] = new HraciPole()

    }

    /**
     * Zobrazi hraci desku na std. vystup
     */
    public void zobraz() {
        //TODO: upravit implementaci aby vystup vypadal lepe;-)
        for (int y = 0; y < rozmer; y++) {
            for (int x = 0; x < rozmer; x++) {
                hraciPole[x][y].zobraz();
            }
        }
    }

    /**
     * @return true pokud je hraci pole na danych souradnicich volne
     */
    public boolean jeVolne(int x, int y) {
        validujIndex(x);
        validujIndex(y);

        return hraciPole[x][y].jeVolne();
    }

    /**
     * Kontrola souradnice na vstupu
     */
    private void validujIndex(int s) {
        if (s < 0 || s > rozmer - 1) {
            throw new IllegalArgumentException("Zadana souradnice je mimo hraci pole: " + s);
        }
    }

    public void polozKamen(int x, int y, HraciKamen kamen) {
        validujIndex(x);
        validujIndex(y);
        //TODO: je treba validovat parametr kamen? co kdyz bude null?
        hraciPole[x][y].polozKamen(kamen);
    }

}
