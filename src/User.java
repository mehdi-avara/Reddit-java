import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private transient String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
