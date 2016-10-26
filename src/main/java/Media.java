/**
 * Created by dkahlenberg on 25.10.2016.
 */
public interface Media {
    Media with(String name, String value);

    /**
     * Book can also be nested i. e. have a Space - object in itself - as a value
     * @param name
     * @param value
     * @return
     */
    Media with(String name, Space value);
}
