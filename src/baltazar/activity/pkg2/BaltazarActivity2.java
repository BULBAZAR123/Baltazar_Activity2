/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baltazar.activity.pkg2;

import java.util.LinkedList;
import java.util.Scanner;



/**
 *
 * @author User
 */

class Bookworm{
    private String title;
    private String author;
    private String isbn;

    public Bookworm(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        
    }
    public String origTitle(){
        return title;
    }
    public String origAuthor(){
        return author;
    }
    public String origISBN(){
        return isbn;
    }
    public String toString(){
        return "Title: "+ title+ ", Author: "+ author + ", ISBN: " + isbn;
        
    }
    
}
public class BaltazarActivity2 {
    private LinkedList<Bookworm> books = new LinkedList<>();
     public void insertBookworm(String title, String author, String isbn){
         Bookworm addbook = new Bookworm(title, author, isbn);
         books.add(addbook);
         
     }
     public void removeBook(String isbn){
         for(int i = 0; i < books.size(); i++){
             Bookworm book = books.get(i);
             if(book.origISBN() .equals(isbn)){
                 books.remove(i);
                 System.out.println("The Book you inputed with ISBN of  " + isbn + " is removed");
                 
             }else{
                 System.out.println("The ISBN " + isbn + "is not found");
             }
         }
         
     }
     public void searchBook(String isbn){
         for(Bookworm book : books){
             if (book.origISBN().equals(isbn)){
                 System.out.println("Book Found is  " + book);
                 return;
             }else{
                 System.out.println("The ISBN " + isbn + "is not found");
             }
         }

       }
              public void sortBookISBN(){
             for(int i = 0; i < books.size(); i++){
                 int minIndex = 1;
                 for(int j = i + 1; j < books.size(); j++){
                     if(books.get(j).origISBN().compareTo(books.get(minIndex).origISBN())<0){
                         
                     }
                 }
                 if(minIndex !=i){
                     Bookworm ehey = books.get(i);
                     books.set(i,books.get(minIndex));
                     books.set(minIndex, ehey);
                 }
             }
        }
              public void display(){
                  for(Bookworm book : books){
                      System.out.println(book);
                  }
              }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BaltazarActivity2 myBooks = new BaltazarActivity2();
        Scanner scanner = new Scanner(System.in);
        
        while (true){
            System.out.println("Menu: ");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display Books");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.println("Select a number");
            int num = scanner.nextInt();
            scanner.nextLine();
            
            switch(num){
                case 1: 
                    System.out.println("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    
                    myBooks.insertBookworm(title, author, isbn);
                    break;
                case 2:
                    System.out.println("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    
                    myBooks.searchBook(isbn);
                    break;
                case 3: 
                    System.out.println("\nMy Books: ");
                    
                    myBooks.display();
                    break;
                case 4:
                    System.out.println("Enter Book ISBN: ");
                    isbn = scanner.nextLine();
                    myBooks.removeBook(isbn);
                    break;
                case 5:
                    System.out.println("Good Bye, Have a Good Day");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Number Inputed");
                    
            }
        }
    }
    
}
