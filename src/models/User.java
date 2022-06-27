package models;

import DataBase.DataBase;
import DataBase.datasController;

public class User{
    private static int id;
    private String email;
    private String password;
    private String userName;
    public static int getNewId() {
        return id++;
    }
    public static void setId(){
        datasController controller = DataBase.getControllert2("PeopleAccounts");
        id = controller.countFiles();
    }

}