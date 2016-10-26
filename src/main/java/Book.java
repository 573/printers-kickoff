/**
 * Created by dkahlenberg on 26.10.2016.
 */
public class Book {
    private final String isbn;
    private final String title;
    private final Space space;

    private Book() {
        this(null, null, null);
    }

    private Book(Space space, String isbn, String title) {
        this.space = space;
        this.isbn = isbn;
        this.title = title;
    }

    public static Book create() {
        return new Book();
    }

    public Media print(Media media) {
        return media.with("isbn", this.isbn)
                .with("title", this.title)
                .with("space", this.space)
                // etc.
                ;
    }

    public Book withSpace(Space spaceValue) {
        return new Book(spaceValue, this.isbn, this.title);
    }

    public Book withIsbn(String isbnValue) {
        return new Book(this.space, isbnValue, this.title);
    }

    public Book withTitle(String titleValue) {
        return new Book(this.space, this.isbn, titleValue);
    }
}
