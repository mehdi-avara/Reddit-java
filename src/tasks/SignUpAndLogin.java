package tasks;

import DataBase.Controller;
import DataBase.DataBase;
import DataBase.datasController;
import models.User;

public class SignUpAndLogin{
    public static String signUp(String email,String userName, String password){
        Controller controller = DataBase.getControllert("PeopleAccounts");
        String str = controller.readFile();
        System.out.println(str);
        if (str.contains(email)) {
            return "Email already exists";
        }
        else if(str.contains(userName)){
            return "UserName already exists";
        }
        int id = User.getNewId();
        controller.writeFile(id+" "+email+" "+userName+" ");
        datasController controller2 = DataBase.getControllert2("PeopleAccounts");
        controller2.createFile(id + "");
        controller2.write(id+"",userName+" "+ email+ " " +password+ " {} {} {} {} {} {}");
        return "success";
    }
}