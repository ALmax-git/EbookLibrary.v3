public class Book {
    private int id;
    private String title;
    private String author;
    private String category;

    // Constructor with ID (for update or delete operations)
    public Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    // Constructor without ID (for adding a new book)
    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Override toString for easy representation of the book in UI
    @Override
    public String toString() {
        return String.format("%d: %s by %s [%s]", id, title, author, category);
    }
}
