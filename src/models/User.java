package models;

public class User{
    private static int id = 1;
    private String email;
    private String password;
    private String userName;
    public static int getNewId() {
        return id++;
    }

}