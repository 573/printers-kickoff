import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xembly.ImpossibleModificationException;

/**
 * Created by dkahlenberg on 25.10.2016.
 */
public class App {
    public static void main(String[] args) throws ImpossibleModificationException {
        Logger log = LoggerFactory.getLogger(App.class);

        Space space = Space.create().withKey("118");

        JsonMedia bookJson = new JsonMedia("book");
        Book.create()
                .withSpace(space)
                .withIsbn("0735619654")
                .withTitle("Object Thinking")
                .print(bookJson);
        log.info(bookJson.json().toString());

        XmlMedia bookXml = new XmlMedia("book");
        Book.create()
                .withSpace(space)
                .withIsbn("0735619654")
                .withTitle("Object Thinking")
                .print(bookXml);
        log.info(bookXml.xml());
    }
}
