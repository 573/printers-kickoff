/**
 * Created by dkahlenberg on 25.10.2016.
 */
public class Book {
    private final String isbn =
            "0735619654";

    private final String title =
            "Object Thinking";

    public Media print(Media media) {
        return media
                .with("isbn", this.isbn)
                .with("title", this.title);
    }
}
