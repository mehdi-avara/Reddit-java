package tasks;

import DataBase.Controller;
import DataBase.DataBase;

public class SignUpAndLogin{
    public static boolean signUp(String email, String password){
        Controller controller = DataBase.getControllert("PeopleAccounts");
        String str = controller.readFile();
        if (str.contains(email)) {
            return false;
        }
        
        return true;
    }
}