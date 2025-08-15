package Library;

class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Method to compare ISBNs
    public boolean hasSameISBN(Book otherBook) {
        if (otherBook == null) {
            return false;
        }
        return this.isbn != null && this.isbn.equals(otherBook.isbn);
    }
}

public class CompareBooks {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "Author A", "1234567890");
        Book b2 = new Book("Advanced Java", "Author B", "1234567890");
        Book b3 = new Book("Python Basics", "Author C", "0987654321");

        System.out.println("FirstBook vs SecondBook : " + b1.hasSameISBN(b2));
        System.out.println("FirstBook vs ThirdBook: " + b1.hasSameISBN(b3)); 
        System.out.println("SecondBook vs ThirdBook: " + b2.hasSameISBN(b3)); 
    }
}
