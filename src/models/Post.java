package models;

import DataBase.DataBase;
import DataBase.datasController;

public class Post {
    private static int id = 1;
    private int personId;
    private int comId;
    private String title;
    private String description;

    public static int getNewId() {
        return id++;
    }
}
