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
                this.builderDirectives.add(name).set(value).up());
    }

    /**
     * The ouput is still not correctly formatted - possibly to do with .add(head) - but you get the point
     * @param name
     * @param value
     * @return
     */
    @Deprecated
    @Override
    public Media with(String name, Space value) {
        XmlMedia spaceXml = new XmlMedia("space");
        value.print(spaceXml);
        try {
            return new XmlMedia(
                    this.builderDirectives.add(name).set(spaceXml.xml()).up());
        } catch (ImpossibleModificationException e) {
            throw new RuntimeException(e);
        }
    }

    public String xml() throws ImpossibleModificationException {
        return new Xembler(this.builderDirectives).xml();
    }
}
