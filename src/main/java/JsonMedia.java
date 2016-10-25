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

    JsonMedia(String head) {
        this(Json.createObjectBuilder().add("head", head));
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

    public JsonObject json() {
        return this.builder.build();
    }
}
