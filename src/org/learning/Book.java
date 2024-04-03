package org.learning;
//imports

public class Book {
    //attributi
    private String title;
    private int pageNumber;
    private String author;
    private String publisher;
    //costruttore
    public Book(String title, int pageNumber, String author, String publisher) throws IllegalArgumentException {
        if(title.isEmpty()){
            throw new IllegalArgumentException("title is empty");
        }
        if(author.isEmpty()){
            throw new IllegalArgumentException("author is empty");
        }
        if(publisher.isEmpty()){
            throw new IllegalArgumentException("publisher is empty");
        }
        if(pageNumber <= 0){
            throw new IllegalArgumentException("pageNumber <= 0");
        }
        this.title = title;
        this.pageNumber = pageNumber;
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
    public void setPageNumber(int pageNumber) throws IllegalArgumentException{
        if(author.isEmpty()){
            throw new IllegalArgumentException("author is empty");
        }
        this.pageNumber = pageNumber;
    }
    public void setAuthor(String author) throws IllegalArgumentException{
        if(publisher.isEmpty()){
            throw new IllegalArgumentException("publisher is empty");
        }
        this.author = author;
    }
    public void setPublisher(String publisher) throws IllegalArgumentException{
        if(pageNumber <= 0){
            throw new IllegalArgumentException("pageNumber <= 0");
        }
        this.publisher = publisher;
    }
    //getter
    public String getTitle() {
        return title;
    }
    public int getPageNumber() {
        return pageNumber;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
}
