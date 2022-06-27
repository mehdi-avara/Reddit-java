import java.io.Serializable;
import java.util.HashMap;

import DataBase.DataBase;

public class User {
    private final HashMap<String, String> data;

    public User(HashMap<String, String> data) {
        this.data = data;
    }

    String alreadyUsername() {
        String users = DataBase.getSingleTone().getControllert("PeopleAccounts").readFile();
        String[] split = users.split("-");
        for (String str : split) {
            if (str.startsWith(data.get("username"))) {
                return str;
            }
        }
        return "invalid";
    }

    String signUp() {
        if (signIn().equals("invalid")) {
            DataBase.getSingleTone().getControllert("PeopleAccounts")
                    .writeFile(data.get("username") + "-" + data.get("email") + "-" + data.get("password"));
            // DataBase.getSingleTone().getControllert("PeopleAccounts").writeFile(data.get("email"));
            // DataBase.getSingleTone().getControllert("PeopleAccounts").writeFile(data.get("password"));
            DataBase.accountCounter++;
        }
        return "SignUp-Success";

    }

    String signIn() {
        String alreadyUsername = alreadyUsername();
        if (alreadyUsername.equals("invalid")) {
            return "invalid";
        } else if (!alreadyUsername.split("-")[2].equals(data.get("password"))) {
            return "invalid-match";
        }
        return "SignIn-Success";
    }

    String getName() {
        return alreadyUsername().equals("invalid") ? "invalid" : alreadyUsername().split("-")[0];
    }

    String getEmail() {
        return alreadyUsername().equals("invalid") ? "invalid" : alreadyUsername().split("-")[1];
    }

    String getPassword() {
        return alreadyUsername().equals("invalid") ? "invalid" : alreadyUsername().split("-")[2];
    }

    String getAccounts() {
        return DataBase.getSingleTone().getControllert("PeopleAccounts").readFile();
    }

}