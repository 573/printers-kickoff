import org.xembly.Directives;
import org.xembly.ImpossibleModificationException;
import org.xembly.Xembler;

/**
 * Created by dkahlenberg on 25.10.2016.
 */
public class XmlMedia implements Media {
    private final Directives builderDirectives;

    XmlMedia() {
        this("book");
    }

    XmlMedia(String head) {
        this(new Directives().add(head));
    }

    XmlMedia(Directives bdr) {
        this.builderDirectives = bdr;
    }

    @Override
    public Media with(String name, String value) {
        return new XmlMedia(
                this.builderDirectives.add(name).set(value).up()
        );
    }

    public String xml() throws ImpossibleModificationException {
        return new Xembler(this.builderDirectives).xml();
    }
}
