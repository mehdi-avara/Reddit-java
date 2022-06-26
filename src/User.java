import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String email;
    private transient String password;

    User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}

// SignUp
// Search
// Login
// AddPost
// FavoritePost
// follow
//