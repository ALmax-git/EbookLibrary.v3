import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class LibraryUI extends JFrame {
    private LibraryDAO libraryDAO;
    private DefaultListModel<String> bookListModel;

    public LibraryUI() {
        libraryDAO = new LibraryDAO();
        bookListModel = new DefaultListModel<>();

        initUI();
        loadBooks();
    }

    private void initUI() {
        setTitle("E-library System - Version 2");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Main Panel
        JPanel panel = new JPanel(new BorderLayout());

        // Book List
        JList<String> bookList = new JList<>(bookListModel);
        panel.add(new JScrollPane(bookList), BorderLayout.CENTER);

        // Buttons
        JButton addButton = new JButton("Add Book");
        JButton updateButton = new JButton("Update Book");
        JButton deleteButton = new JButton("Delete Book");

        addButton.addActionListener(e -> addBook());
        updateButton.addActionListener(e -> updateBook(bookList.getSelectedValue()));
        deleteButton.addActionListener(e -> deleteBook(bookList.getSelectedValue()));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);

        setLocationRelativeTo(null);
    }

    private void loadBooks() {
        bookListModel.clear();
        try {
            List<Book> books = libraryDAO.getAllBooks();
            for (Book book : books) {
                bookListModel.addElement(formatBook(book));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load books.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addBook() {
        Book book = getBookInput();
        if (book != null) {
            try {
                libraryDAO.addBook(book);
                loadBooks();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed to add book.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateBook(String selectedBook) {
        if (selectedBook != null) {
            int id = Integer.parseInt(selectedBook.split(":")[0].trim());
            Book book = getBookInput();
            if (book != null) {
                book.setId(id);
                try {
                    libraryDAO.updateBook(book);
                    loadBooks();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Failed to update book.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void deleteBook(String selectedBook) {
        if (selectedBook != null) {
            int id = Integer.parseInt(selectedBook.split(":")[0].trim());
            try {
                libraryDAO.deleteBook(id);
                loadBooks();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed to delete book.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Book getBookInput() {
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField categoryField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Enter Book Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new Book(0, titleField.getText(), authorField.getText(), categoryField.getText());
        } else {
            return null;
        }
    }

    private String formatBook(Book book) {
        return String.format("%d: %s by %s [%s]", book.getId(), book.getTitle(), book.getAuthor(), book.getCategory());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibraryUI ui = new LibraryUI();
            ui.setVisible(true);
        });
    }
}
