# Ebook Library CLI

A command-line-based Ebook Library application implemented in Java. This application allows users to add, view, update, and delete books from an e-library database, with basic CRUD operations supported.

## Features

- **Add Book**: Add new books to the library.
- **View Books**: View a list of all books in the library.
- **Update Book**: Update details of existing books.
- **Delete Book**: Remove books from the library.
- **Error Handling**: Error prompts for failed operations, such as loading a book.

## Getting Started

These instructions will guide you on how to set up, compile, and run the Ebook Library CLI application.

### Prerequisites

- Java Development Kit (JDK) 8 or later
- XAMPP (for database support in Version 2)

### Installation

1. Clone or download this repository to your local machine.
   ```bash
   git clone [EbookLibrary](https://github.com/ALmax-git/EbookLibrary.v3)
   ```

2. Navigate to the project directory:
   ```bash
   cd /opt/lampp/htdocs/EbookLibrary.v3
   ```

### Usage

1. **Compile the Application**:
   Ensure you are in the directory containing `Main.java`:
   ```bash
   javac Main.java
   ```

2. **Run the Application**:
   ```bash
   java Main
   ```

3. Follow the on-screen prompts to interact with the Ebook Library application. Options will include adding, viewing, updating, and deleting books.

### Database Setup (Version 2)

For the database-connected version:

1. Start XAMPP and make sure MySQL is running.
2. Create a database named `ebook_library`.
3. Inside the database, create a table `books` with the following structure:

   ```sql
   CREATE TABLE books (
       id INT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       author VARCHAR(255) NOT NULL,
       year INT,
       genre VARCHAR(100)
   );
   ```

4. Update the database connection information in `Main.java` if needed.

### Error Handling

If an operation fails (e.g., failing to load books), an error message will be displayed in the terminal.

## Example

Sample output on running the application:

```
Welcome to the Ebook Library CLI!

1. Add Book
2. View Books
3. Update Book
4. Delete Book
5. Exit

Enter your choice: 
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
