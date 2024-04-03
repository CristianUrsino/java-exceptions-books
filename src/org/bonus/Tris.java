package org.bonus;
//imports
import java.util.Scanner;
public class Tris {
    public static void main(String[] args) {
        //dichiaro lo scanner
        Scanner scanner = new Scanner(System.in);
        //dichiaro la matrice di gioco
        char[][] moves = new char[3][3];
        //dichiaro altre variabili
        boolean turn = false;//variabile del turno, false = giocatore A
        boolean isOver = false;//se true indica che la partica è finita
        //stampo il campo di gioco prima di iniziare
        System.out.println(playground(moves));
        //chiudo la risorsa scanner
        scanner.close();
    }
    public static String playground(char[][] moves){
        String playground = "  1 2 3" +
                "\n1 " + moves[0][0] + " " + moves[0][1] + " " + moves[0][2] +
                "\n2 " + moves[1][0] + " " + moves[1][1] + " " + moves[1][2] +
                "\n3 " + moves[2][0] + " " + moves[2][1] + " " + moves[2][2];
        return playground;
    }

}
