package piskvorky;

import java.io.*;

/**
 *
 * @author Jan Drapela
 */
public class Piskvorky {

    static int N = 15; //zatim jsem nastavil velikost desky na 15x15
    static String[][] Pole = new String[N][N];

    public static void main(String[] args) throws IOException {

        String Path = "C:\\TEMP\\";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Pole[i][j] = "";
            }
        }
        nacteHru(Path + "hra1.txt");
        int Hrac = 1;
        while (true) {
            //System.out.print("\033[H\033[2J"); // melo by fungovat jako clear screen 
            //System.out.flush();
            hraciDeska();
            Prompt(Hrac);
            if (Hrac == 1) {
                Hrac = 2;
            } else {
                Hrac = 1;
            }
            break;      //neustale opakovani-nahravani pole
        }
    }
        //public static boolean SaveGame(string aFileName)
        //{

        //}
    public static void nacteHru(String aFileName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(aFileName));
        String line = "";
        int i = 0;
        while (line != null) {
            line = br.readLine();
            if (line == null) {
                continue;
            }
            if (line == "") {
                continue;
            }
            // VYHAZUJE CHYBU OUTOFINDEX
            /*String[] pom = line.split(" "); // pomocne pole stringu, {"1","0",...}
            for (int j = 0; j < N; j++) {
                Pole[i][j] = pom[j];
            }
            i++;
             */
        }
        br.close();

    }

    public static void hraciDeska() {
        String H = "                   ";
        System.out.println();
        System.out.println();
        System.out.print(H + "   A B C D E F G H I J K L M N O");
        System.out.print(H + "   ");
        for (int j = 0; j < N; j++) {
            //System.out.print(" _");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            String S = Integer.toString(i);
            if (i < 10) {
                S = " " + S;
            }
            System.out.print(H + S + "|" + "_");
            for (int j = 0; j < N; j++) {
                S = "_";
                if (Pole[i][j] != "-") {
                    S = Pole[i][j];
                }
                if (j < N) {
                    System.out.print(S + "|" + "_");
                }
            }
            System.out.println();
        }

    }

    static void Prompt(int Hrac) {
        if (Hrac == 1) {
            System.out.println(">");
        } else {
            System.out.println("                                           >");
        }
    }
}
