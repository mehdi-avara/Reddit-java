package DataBase;

import java.util.HashMap;

public class DataBase {
    static private final HashMap<String, Controller> dataBase = new HashMap<String, Controller>();
    static private final HashMap<String, datasController> dataBase2 = new HashMap<String, datasController>();
    static private DataBase singleTone;

    static public DataBase getDataBase() {
        if (singleTone == null) {
            singleTone = new DataBase();
        }
        return singleTone;
    }

    public void addToDataBase(String str, Controller controller) {
        dataBase.put(str, controller);
    }

    public static Controller getControllert(String str) {
        return dataBase.get(str);
    }
    public static datasController getControllert2(String str) {
        return dataBase2.get(str);
    }
    public static void addToDataBase2(String str, datasController controller) {
        dataBase2.put(str, controller);
    }
}
