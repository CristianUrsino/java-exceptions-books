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
        //stampo il campo di gioco prima di iniziare
        System.out.println(playground(moves));
        //inizio il gioco
        while(!lookWinner(moves)){
            //ciclo finchè finisce il gioco
            currentMove(moves,turn,scanner);
            turn = !turn;
        }
        //stampo il vincitore
        //a fine partita i player vengono invertiti quindi true = A
        System.out.println("\nPlayer " + (turn ? 'A' : 'B') + " win");
        //chiudo la risorsa scanner
        scanner.close();
    }
    public static String playground(char[][] moves){
        //inizializzo la variabile che contiene il campo da gioco formattato
        String playground = "  1 2 3" +
                "\n1 " + moves[0][0] + " " + moves[0][1] + " " + moves[0][2] +
                "\n2 " + moves[1][0] + " " + moves[1][1] + " " + moves[1][2] +
                "\n3 " + moves[2][0] + " " + moves[2][1] + " " + moves[2][2];
        return playground;
    }
    public static void currentMove(char[][] moves, boolean turn,Scanner scanner){
        boolean occupied = false;
        do{
        //ciclo finchè l'utente inserisce un valore in una cella non occupata
            String move = "";
            //salvo la mossa del giocatore attuale
            do {
                System.out.print("It's turn of player " + (turn ? "B" : "A") + ", enter the position(x-y): " );
                move = scanner.nextLine();
                move = move.replaceAll(" ", "");
                if(move.length() != 3 ||
                        (move.charAt(0) != '1' && move.charAt(0) != '2' && move.charAt(0) != '3') ||
                        (move.charAt(2) != '1' && move.charAt(2) != '2' && move.charAt(2) != '3')
                ){
                    System.out.println("Error, the move in not valid, please try again");
                    move = "";
                }
            }while (move == "");
            //estraggo gli indici
            int row = Character.getNumericValue(move.charAt(0)) - 1;
            int col = Character.getNumericValue(move.charAt(2)) - 1;
            if(moves[row][col] != '\u0000'){
                //se la cella scelta non è un carattere \u0000 quindi di default, è occupata quindi il giocatore deve scegliere un altra cella
                occupied = true;
                System.out.println("Positions occupied, choose a another position");
            }else{
                //aggiorno la matrice
                moves[row][col] = turn ? 'B' : 'A';
                occupied = false;
            }
        }while(occupied);
        //stampo il campo da gioco aggiornato
        System.out.println(playground(moves));
    }
    public static boolean lookWinner(char[][] moves) {
        int i = 0;
        while (i < moves.length) {
            int j = 1;
            if ((moves[i][j - 1] == moves[i][j] && moves[i][j] == moves[i][j + 1]) && moves[i][j - 1] != '\u0000') {
                return true;
            }
            i++;
        }
        int j = 0;
        i = 1;
        while (j < moves[i].length) {
            if ((moves[i - 1][j] == moves[i][j] && moves[i][j] == moves[i + 1][j]) && moves[i - 1][j] != '\u0000') {
                return true;
            }
            j++;
        }
        if ((moves[0][0] == moves[1][1] && moves[1][1] == moves[2][2]) && moves[0][0] != '\u0000') {
            return true;
        }
        if ((moves[0][2] == moves[1][1] && moves[1][1] == moves[2][0]) && moves[0][2] != '\u0000') {
            return true;
        }
        return false;
    }
}