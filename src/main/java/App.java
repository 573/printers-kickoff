import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xembly.ImpossibleModificationException;

/**
 * Created by dkahlenberg on 25.10.2016.
 */
public class App {
    public static void main(String[] args) throws ImpossibleModificationException {
        Logger log = LoggerFactory.getLogger(App.class);
        Book book = new Book();

        JsonMedia media = new JsonMedia("book");
        book.print(media);
        log.info(media.json().toString());

        XmlMedia media2 = new XmlMedia("book2");
        book.print(media2);
        log.info(media2.xml());
    }
}
