package org.learning;
//imports

public class Book {
    //attributi
    private String title;
    private int pagesNumber;
    private String author;
    private String publisher;
    //costruttore
    public Book(String title, int pagesNumber, String author, String publisher) throws IllegalArgumentException {
        if(title.isEmpty()){
            throw new IllegalArgumentException("title is empty");
        }
        if(author.isEmpty()){
            throw new IllegalArgumentException("author is empty");
        }
        if(publisher.isEmpty()){
            throw new IllegalArgumentException("publisher is empty");
        }
        if(pagesNumber <= 0){
            throw new IllegalArgumentException("pagesNumber <= 0");
        }
        this.title = title;
        this.pagesNumber = pagesNumber;
        this.author = author;
        this.publisher = publisher;
    }
    //setter
    public void setTitle(String title) throws IllegalArgumentException{
        if(title.isEmpty()){
            throw new IllegalArgumentException("title is empty");
        }
        this.title = title;
    }
    public void setPagesNumber(int pagesNumber) throws IllegalArgumentException{
        if(pagesNumber <= 0){
            throw new IllegalArgumentException("pagesNumber <= 0");
        }
        this.pagesNumber = pagesNumber;
    }
    public void setAuthor(String author) throws IllegalArgumentException{
        if(author.isEmpty()){
            throw new IllegalArgumentException("author is empty");
        }
        this.author = author;
    }
    public void setPublisher(String publisher) throws IllegalArgumentException{
        if(publisher.isEmpty()){
            throw new IllegalArgumentException("publisher is empty");
        }
        this.publisher = publisher;
    }
    //getter
    public String getTitle() {
        return title;
    }
    public int getPagesNumber() {
        return pagesNumber;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
}
