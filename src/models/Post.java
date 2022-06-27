package models;

public class Post {
    private static int id = 1;
    private String title;
    private String description;

    public static int getNewId() {
        return id++;
    }
}
