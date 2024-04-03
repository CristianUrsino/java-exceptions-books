package org.learning;
//imports
import java.util.Scanner;
public class Cart {
    public static void main(String[] args) {
        //definisco lo scanner
        Scanner scanner = new Scanner(System.in);
        //dichiaro la lunghezza del carrello
        int sizeCart = 0;
        do {
            //ciclo finchè viene assegnato un valore valido
            try{
                System.out.print("Enter how many books: ");
                sizeCart = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                //setto valore per ripetere il ciclo
                sizeCart = 0;
            }
            if(sizeCart <= 0){
                //stampo il messaggio di errore
                System.out.println("Error: Please enter a valid positive integer value for the number of books.");
            }
        }while(sizeCart <= 0);
        //dichiaro l'array del carrello
        Book[] books = new Book[sizeCart];
        //riempio l'array
        for (int i = 0; i < sizeCart; i++) {
            System.out.println("\nForm date of book number " + (i+1));
            //dichiaro le variabili da mandare al costruttore come parametri
            String title="", author="", publisher = "";
            int pagesNumber = 0;
            //inizializzo tramite input i valori
            do{
                //ciclo finchè viene assegnato un valore valido di TITLE
                System.out.print("enter a title: ");
                title = scanner.nextLine();
                if(title.isEmpty()){
                    System.out.println("Error the title is empty, please try again");
                }
            }while(title.isEmpty());
            do {
                //ciclo finchè viene assegnato un valore valido di PAGESNUMBER
                try{
                    System.out.print("enter a number of pages: ");
                    pagesNumber = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e) {
                    //setto valore per ripetere il ciclo
                    pagesNumber = 0;
                }
                if(pagesNumber <= 0){
                    //stampo il messaggio di errore
                    System.out.println("Error: Please enter a valid positive integer value for the number of pages.");
                }
            }while(pagesNumber <= 0);
            do{
                //ciclo finchè viene assegnato un valore valido di AUTHOR
                System.out.print("enter a author: ");
                author = scanner.nextLine();
                if(author.isEmpty()){
                    System.out.println("Error the author is empty, please try again");
                }
            }while(author.isEmpty());
            do{
                //ciclo finchè viene assegnato un valore valido di PUBLISHER
                System.out.print("enter a publisher: ");
                publisher = scanner.nextLine();
                if(publisher.isEmpty()){
                    System.out.println("Error the publisher is empty, please try again");
                }
            }while(publisher.isEmpty());
            //richiamo il costruttore
            books[i] = new Book(title,pagesNumber,author,publisher);
        }
        //chiudo lo scanner
        scanner.close();
    }
}
