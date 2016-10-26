/**
 * A {@link Space} could represent i. e. a library branch where i. e. a {@link Book} would be located
 * Created by dkahlenberg on 26.10.2016.
 */
public class Space {

    private String key;

    private Space() { this(null); }

    private Space(String key) {
        this.key = key;
    }

    public Media print(Media media) {
        return media.with("key", this.key);
    }

    public static Space create() {
        return new Space();
    }

    /**
     * Let's pretend the key stands for the room no. in which an item is located
     * @param value
     * @return
     */
    public Space withKey(String value) {
        return new Space(value);
    }
}
