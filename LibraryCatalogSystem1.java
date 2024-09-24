import java.util.LinkedList;
import java.util.Scanner;
class Book {
    private String title;
    private String author;
    private String isbn;
    private int cost;  
    public Book(String title, String author, String isbn, int cost) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.cost = cost;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCost() {
        return cost;
    }
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Cost: $" + cost;
    }
}
class LibraryCatalog {
    private LinkedList<Book> books;
    public LibraryCatalog() {
        books = new LinkedList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void searchByTitle(String title)
    {
        System.out.println("Books with title containing \"" + title + "\":");
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the given title.");
        }
    }
    public void searchByAuthor(String author)
     {
        System.out.println("Titles of books by author \"" + author + "\":");
        boolean found = false;
        for (Book book : books)
        {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                System.out.println(book.getTitle());  
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by the given author.");
        }
    }
    public void listBooks() 
    {
        int bookCount = books.size();
        if (bookCount == 0) {
            System.out.println("No books available in the catalog.");
        } else {
            System.out.println("Number of books in the catalog: " + bookCount);
        }
    }
}
public class LibraryCatalogSystem1
{

    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. List Number of Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter book cost: ");
                    int cost = scanner.nextInt();
                    scanner.nextLine();  
                    catalog.addBook(new Book(title, author, isbn, cost));
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    catalog.searchByTitle(searchTitle);
                    break;
                case 3:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    catalog.searchByAuthor(searchAuthor);  
                    break;
                case 4:
                    catalog.listBooks();  
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        scanner.close();
    }
}
