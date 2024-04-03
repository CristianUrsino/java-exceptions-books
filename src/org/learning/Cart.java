package org.learning;
//imports
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
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
            do {
                try {
                    do {
                        //ciclo finchè viene assegnato un valore valido di TITLE
                        System.out.print("enter a title: ");
                        title = scanner.nextLine();
                        if (title.isEmpty()) {
                            System.out.println("Error the title is empty, please try again");
                        }
                    } while (title.isEmpty());
                    do {
                        //ciclo finchè viene assegnato un valore valido di PAGESNUMBER
                        try {
                            System.out.print("enter a number of pages: ");
                            pagesNumber = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            //setto valore per ripetere il ciclo
                            pagesNumber = 0;
                        }
                        if (pagesNumber <= 0) {
                            //stampo il messaggio di errore
                            System.out.println("Error: Please enter a valid positive integer value for the number of pages.");
                        }
                    } while (pagesNumber <= 0);
                    do {
                        //ciclo finchè viene assegnato un valore valido di AUTHOR
                        System.out.print("enter a author: ");
                        author = scanner.nextLine();
                        if (author.isEmpty()) {
                            System.out.println("Error the author is empty, please try again");
                        }
                    } while (author.isEmpty());
                    do {
                        //ciclo finchè viene assegnato un valore valido di PUBLISHER
                        System.out.print("enter a publisher: ");
                        publisher = scanner.nextLine();
                        if (publisher.isEmpty()) {
                            System.out.println("Error the publisher is empty, please try again");
                        }
                    } while (publisher.isEmpty());
                    //richiamo il costruttore
                    books[i] = new Book(title, pagesNumber, author, publisher);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error in parameter");
                }
            }while (books[i] == null);
        }
        //definisco il file
        File cartFile = new File("./resouces/cart.txt");
        if(cartFile.exists()){
            //se esiste scrivo la lista dei libri inseriti nel carrello
            try(FileWriter fileWriter = new FileWriter(cartFile)){
                for(int i= 0; i < sizeCart; i++){
                    fileWriter.write("\n\nBook number " + (i+1) +": " +
                            "\n\ttitle: " + books[i].getTitle() +
                            "\n\tnumeber of pages: " + books[i].getPagesNumber() +
                            "\n\tauthor: " + books[i].getAuthor() +
                            "\n\tpublisher: " + books[i].getPublisher());
                }
            }catch(IOException e){
                //stampo errore
                System.out.println("Unable to open file");
            }
            //poi leggo dal file i libri inseriti nel carrello
            try(Scanner fileReader = new Scanner(cartFile)){
                while (fileReader.hasNextLine()){
                    System.out.println(fileReader.nextLine());
                }
            }catch(IOException e){
                //stampo errore
                System.out.println("Unable to open file");
            }
        }else{
            //altrimenti stampo errore
            System.out.println("File not found");
        }

        //chiudo lo scanner
        scanner.close();
    }
}
