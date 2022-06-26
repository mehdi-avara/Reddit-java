import java.io.Serializable;

public class Community implements Serializable {
    private String name;
    private String description;

    Community(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
