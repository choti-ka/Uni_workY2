import java.util.*;

public class LibrarySystem {
    static class Book {
        String title;
        String author;
        String genre;

        Book(String title, String author, String genre) {
            this.title = title;
            this.author = author;
            this.genre = genre;
        }
        @Override
        public String toString() {
            return title + " - " + author + " | " + genre;
        }
    }
    public static void main(String[] args) {
        LinkedList<Book> bookList = new LinkedList<>(); // book list
        LinkedList<Book> borrowList = new LinkedList<>(); // borrow list

        bookList.add(new Book("Animal Farm", "George Orwell", "Political satire"));
        bookList.add(new Book("Harry Potter and the Sorcerer's Stone", "J. K. Rowling", "Fantasy"));
        bookList.add(new Book("1984", "George Orwell", "Fiction"));
        bookList.add(new Book("Lolita", "Vladimir Nabokov", "Romance"));

        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=========LIBRARY=========");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search For A Book");
            System.out.println("4. Borrow And Return Service");
            System.out.println("5. Display All Books");
            System.out.println("6. Display Borrowed Books");
            System.out.println("7. Sort Books By Genre");
            System.out.println("8. Exit");
            System.out.println("=========================");
            System.out.print("Enter your choice(1-8): ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: // add
                    System.out.println("\n=========Add Book=========");
                    System.out.print("Enter book name: ");
                    String userTitle = input.nextLine();
                    System.out.print("Enter book author: ");
                    String userAuthor = input.nextLine();
                    System.out.print("Enter book genre: ");
                    String userGenre = input.nextLine();
                    bookList.add(new Book(userTitle, userAuthor, userGenre));
                    System.out.println("Book added successfully!");
                    break;

                case 2: // remove
                    System.out.println("\n=========Remove Book=========");
                    System.out.print("Enter book name: ");
                    String removeTitle = input.nextLine();
                    boolean found = false;
                    for (Book book : bookList) {
                        if (book.title.equalsIgnoreCase(removeTitle)) {
                            bookList.remove(book);
                            System.out.println("Book removed successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3: // search
                    System.out.println("\n=========Search For A Book=========");
                    System.out.print("Enter book name: ");
                    String searchTitle = input.nextLine();
                    found = false;
                    for (Book book : bookList) {
                        if (book.title.equalsIgnoreCase(searchTitle)) {
                            System.out.println("Found: " + book);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4: // borrow + return
                    System.out.println("\n=========Borrow And Return Service=========");
                    System.out.println("1. Borrow a Book");
                    System.out.println("2. Return a Book");
                    System.out.print("Enter your choice: ");
                    int borrowChoice = input.nextInt();
                    input.nextLine();
                    switch (borrowChoice) {
                        case 1: // borrow
                            System.out.println("\n=========Borrow a Book=========");
                            System.out.print("Enter book name: ");
                            String borrowTitle = input.nextLine();
                            found = false;
                            for (Book book : bookList) {
                                if (book.title.equalsIgnoreCase(borrowTitle)) {
                                    borrowList.add(book);
                                    bookList.remove(book);
                                    System.out.println("Book borrowed successfully!");
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Book not found.");
                            }
                            break;
                        case 2: // return
                            System.out.println("\n=========Return a Book=========");
                            System.out.print("Enter book name: ");
                            String returnTitle = input.nextLine();
                            found = false;
                            for(Book book: borrowList){
                                if(book.title.equalsIgnoreCase(returnTitle)){
                                    bookList.add(book);
                                    borrowList.remove(book);
                                    System.out.println("Book return successfully!");
                                    found = true;
                                    break;
                                }
                            }
                            if(!found){
                                System.out.println("Book not found in borrowed list");
                        }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 5: // display all
                    System.out.println("\n=========Display All Books=========");
                    if (bookList.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (int i = 0; i < bookList.size(); i++) {
                            System.out.println((i + 1) + ". " + bookList.get(i));
                        }
                    }
                    break;
                case 6: // display borrow
                    System.out.println("\n=========Display Borrowed Books=========");
                    if (borrowList.isEmpty()) {
                        System.out.println("No books borrowed.");
                    } else {
                        for (int i = 0; i < borrowList.size(); i++) {
                            System.out.println((i + 1) + ". " + borrowList.get(i));
                        }
                    }
                    break;
                case 7: // sort by genra
                    System.out.println("\n=========Sort Books By Genre=========");
                    bookList.sort(Comparator.comparing(book -> book.genre));
                    if (bookList.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (int i = 0; i < bookList.size(); i++) {
                            System.out.println((i + 1) + ". " + bookList.get(i));
                        }
                    }
                    break;
                case 8: // exit
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
        input.close();
    }
}
