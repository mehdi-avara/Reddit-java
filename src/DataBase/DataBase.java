package DataBase;

import java.util.HashMap;

public class DataBase {
    static private final HashMap<String,Controller> dataBase =new HashMap<String, Controller>();
    static private DataBase singleTone;
    static public DataBase getDataBase(){
        if (singleTone == null) {
            singleTone = new DataBase();
        }
        return singleTone;
    }
    public void addToDataBase(String str,Controller controller){
        dataBase.put(str,controller);
    }
    Controller getControllert(String str){
        return dataBase.get(str);
    }
}
