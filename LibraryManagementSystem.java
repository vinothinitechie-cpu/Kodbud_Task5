import java.util.ArrayList;
import java.util.Scanner;

// A friendly Book class
class Book {
    String title;
    String author;
    int id;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("📚 ID: " + id + " | Title: " + title + " | Author: " + author);
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> library = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1; // auto-increment book ID

    public static void main(String[] args) {
        System.out.println("👋 Welcome to the Friendly Library Management System!");
        int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> displayBooks();
                case 3 -> searchBook();
                case 4 -> removeBook();
                case 5 -> System.out.println("👋 Thanks for using the library. Goodbye!");
                default -> System.out.println("⚠️ Oops! Please choose a valid option.");
            }

        } while (choice != 5);
    }

    // Show menu options
    static void showMenu() {
        System.out.println("\n--- What would you like to do? ---");
        System.out.println("1. Add a new book 📖");
        System.out.println("2. Display all books 📚");
        System.out.println("3. Search for a book by title 🔍");
        System.out.println("4. Remove a book ❌");
        System.out.println("5. Exit 🚪");
        System.out.print("Enter your choice: ");
    }

    // Add a new book
    static void addBook() {
        System.out.print("Enter the book title: ");
        String title = sc.nextLine();
        System.out.print("Enter the author name: ");
        String author = sc.nextLine();

        Book newBook = new Book(nextId++, title, author);
        library.add(newBook);
        System.out.println("✅ Book added! Happy reading! 📚");
    }

    // Display all books
    static void displayBooks() {
        if (library.isEmpty()) {
            System.out.println("😔 The library is empty. Try adding some books first!");
            return;
        }

        System.out.println("\n📚 Here are all the books in the library:");
        for (Book b : library) {
            b.display();
        }
    }

    // Search for a book by title
    static void searchBook() {
        System.out.print("Enter the title of the book you're looking for: ");
        String title = sc.nextLine();
        boolean found = false;

        for (Book b : library) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("🎉 Book found!");
                b.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("😔 Sorry, we couldn't find a book with that title.");
        }
    }

    // Remove a book by ID
    static void removeBook() {
        System.out.print("Enter the ID of the book you want to remove: ");
        int id = sc.nextInt();
        boolean removed = library.removeIf(b -> b.id == id);

        if (removed) {
            System.out.println("✅ Book removed successfully!");
        } else {
            System.out.println("😔 No book found with that ID.");
        }
    }
}
