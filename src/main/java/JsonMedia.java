import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
/**
 * Created by dkahlenberg on 25.10.2016.
 */
class JsonMedia implements Media {
    private final JsonObjectBuilder builder;

    JsonMedia() {
        this("book");
    }

    JsonMedia(String level) {
        // TBH IDK in which use cases that "level" is really needed or when the .add("level", level)) and then as well the this
        // (String) call in the default constructor can be left off - semantically
        this(Json.createObjectBuilder().add("level", level));
    }

    JsonMedia(JsonObjectBuilder bdr) {
        this.builder = bdr;
    }

    @Override
    public Media with(String name, String value) {
        return new JsonMedia(
                this.builder.add(name, value)
        );
    }

    @Override
    public Media with(String name, Space value) {
        JsonMedia spaceJson = new JsonMedia("space");
        value.print(spaceJson);
        return new JsonMedia(
                this.builder.add(name, spaceJson.json())
        );
    }

    public JsonObject json() {
        return this.builder.build();
    }
}
