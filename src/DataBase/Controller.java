package DataBase;

import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    private FileWriter fileWriter;
    public Controller(String fileName){
        try {
            fileWriter = new FileWriter(fileName,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
