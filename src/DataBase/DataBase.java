package DataBase;

import java.util.HashMap;

public class DataBase {
    static private final HashMap<String, Controller> dataBase = new HashMap<String, Controller>();
    static private DataBase singleTone;
    public static int accountCounter = 0;
    static int communityCounter = 0;

    public void addToDataBase(String str, Controller controller) {
        dataBase.put(str, controller);
    }

    public Controller getControllert(String str) {
        return dataBase.get(str);
    }

    public static DataBase getSingleTone() {
        if (singleTone == null) {
            singleTone = new DataBase();
        }
        return singleTone;
    }
}
