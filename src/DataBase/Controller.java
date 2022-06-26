package DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Ref;

public class Controller {
    private final File file;
    private RandomAccessFile raf;
    private FileWriter fw;

    public Controller(String path) {
        file = new File(path);
        try {
            raf = new RandomAccessFile(file, "rw");
            String last = readFile();
            fw = new FileWriter(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String readFile() {
        StringBuilder recovery = new StringBuilder();
        String i;
        try {
            while ((i = raf.readLine()) != null) {
                recovery.append(i + "\n");
            }
            raf.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return recovery.toString();
    }

    public void writeFile(String text, boolean... reset) {
        try {
            if (reset.length != 0) {
                fw = new FileWriter(file);
            }
            fw.write(text);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    String getRowString(String id) {
        String[] splits = this.readFile().split("\n");
        for (String str : splits) {
            if (str.startsWith(id)) {
                return str;
            }
        }
        return "invalid";
    }

    public void removeId(String id) {
        String[] splits = this.readFile().split("\n");
        StringBuilder sb = new StringBuilder();
        for (String str : splits) {
            if (!str.startsWith(id)) {
                sb.append(str + "\n");
            }
        }
        this.writeFile(sb.toString());
    }
}
class datasController{
    private final String file;
    private RandomAccessFile raf;
    private FileWriter fw;

    public datasController(String path) {
        file = path;
    }
    public String readFile(String id){
        try {
            raf = new RandomAccessFile(new File(file+"\\"+id), "rw");
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        StringBuilder recovery = new StringBuilder();
        String i;
        try {
            while ((i = raf.readLine()) != null) {
                recovery.append(i + "\n");
            }
            raf.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recovery.toString();
    }

    public void write(String id,String text,boolean... reset){
        try {
            raf = new RandomAccessFile(new File(file+"\\"+id), "rw");
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            if (reset.length != 0) {
                fw = new FileWriter(file+"\\"+id);
            }
            fw.write(text);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
}
