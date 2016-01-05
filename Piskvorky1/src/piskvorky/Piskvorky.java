package piskvorky;

import java.io.BufferedReader;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.*;  
import java.io.*;

/**
 *
 * @author Jan Drapela
 */
public class Piskvorky {

    static int N = 15; //zatim jsem nastavil velikost desky na 15x15
    static String[][] Pole = new String[N][N];
    static String Hrac1 = "Milan";
    static String Hrac2 = "Honza";
    static Scanner sc = new Scanner(System.in);
    static boolean QuitGame = false;

    public static void main(String[] args) throws IOException {

        String Path = "C:\\TEMP\\";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Pole[i][j] = "";
            }
        }
        nacteHru(Path + "hra1.txt");
        int Hrac = 1;
        while (QuitGame == false) {
            System.out.print("\033[H\033[2J"); // melo by fungovat jako clear screen 
            System.out.flush();
            hraciDeska();
            Prompt(Hrac);
            if (Hrac == 1) {
                Hrac = 2;
            } else {
                Hrac = 1;
            }
            //break;     // neni potreba, nutnost pole znovu nacist po kazdem tahu
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
            if (line != "") {
                String[] pom = line.split(" "); // pomocne pole stringu, {"1","0",...}
                for (int j = 0; j < N; j++) {
                    Pole[i][j] = pom[j];
                }
                i++;
            }
        }
        br.close();

    }

    public static void hraciDeska() {
        String H = "                   ";
        System.out.println();
        System.out.println();
        System.out.print(H + "   A B C D E F G H I J K L M N O");
        System.out.print(H + "   ");
        System.out.println();
        for (int i = 0; i < N; i++) {
            String S = Integer.toString(i + 1);
            if (i < 9) {
                S = " " + S;
            }
            System.out.print(H + S + "|");
            for (int j = 0; j < N; j++) {
                if (Pole[i][j].equals("-")) {
                    S = "_";
                } else {
                    S = Pole[i][j];
                }
                if (j < N) {
                    System.out.print(S + "|");
                }
            }
            System.out.println();
        }

    }

    static void Prompt(int Hrac) {
        if (Hrac == 1) {
            System.out.print(Hrac1 + "> ");
        } else {
            System.out.print("                                          " + Hrac2 + " > ");
        }
        String Input = sc.nextLine();
        Input = Input.trim().toLowerCase();
        String ColStr = Input.substring(0, 1);
        switch (ColStr) {
            case "q":
                QuitGame = true;
                break;
            case "a":
            case "b":
            case "c":
            case "d":
            case "e":
            case "f":
            case "g":
            case "h":
            case "i":
            case "j":
            case "k":
            case "l":
            case "m":
            case "n":
            case "o": {
                String RowStr = "";
                if (Input.length() == 3) {
                    RowStr = Input.substring(1, 3);
                } else if (Input.length() == 2) {
                    RowStr = Input.substring(1, 2);
                } else ; // todo osetrit chybu vstupu
                int Col = ColStr.charAt(0) - 'a';  // pismenko sloupce, a..o, nebo q pro quit game
                int Row = Integer.parseInt(RowStr);// cislo 1-15
                Row--;
                Pole[Row][Col] = (Hrac == 1 ? "x" : "o");  // ternarni operator - podle cisla akt. hrace voli jeho symbol

            }
            break;
        }
    }
}
