package tasks;

import DataBase.Controller;
import DataBase.DataBase;
import DataBase.datasController;
import models.User;

public class SignUpAndLogin{
    public static String signUp(String request){
        //regex signUp email username password
        String[] requestSplit = request.split(" ");
        return signUp(requestSplit[1],requestSplit[2],requestSplit[3]);
    }
    private static String signUp(String email,String userName, String password){
        Controller controller = DataBase.getControllert("PeopleAccounts");
        String str = controller.readFile();
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
        controller2.write(id+" ",userName+" "+ email+ " " +password+ " {} {} {} {} {} {}");
        // regex (?<userName>[^ ]*) (?<email>[^ ]*) (?<pass>[^ ]*) [{]{1}(?<ownsCom>[^}]*)[}]{1} [{]{1}(?<com>[^}]*)[}]{1} [{]{1}(?<adminCom>[^}]*)[}]{1} [{]{1}(?<postId[^}]*)[}]{1} [{]{1}(?<commentId[^}]*)[}]{1} [{]{1}(?<savedPost[^}]*)[}]{1}
        return "success "+id;
    }
}