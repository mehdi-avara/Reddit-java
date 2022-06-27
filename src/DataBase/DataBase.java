package DataBase;

import java.util.HashMap;

public class DataBase {
    private static final HashMap<String, Controller> dataBase = new HashMap();
    private static final HashMap<String, datasController> dataBase2 = new HashMap();
    private static DataBase singleTone;

    public DataBase() {
    }

    public static DataBase getDataBase() {
        if (singleTone == null) {
            singleTone = new DataBase();
        }

        return singleTone;
    }

    public void addToDataBase(String var1, Controller var2) {
        dataBase.put(var1, var2);
    }

    public static Controller getControllert(String var0) {
        return (Controller)dataBase.get(var0);
    }

    public static datasController getControllert2(String var0) {
        return (datasController)dataBase2.get(var0);
    }

    public static void addToDataBase2(String var0, datasController var1) {
        dataBase2.put(var0, var1);
    }
}