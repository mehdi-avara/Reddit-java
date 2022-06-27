package DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class datasController{
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
            raf = new RandomAccessFile(new File(file+"\\"+id+".txt"), "rw");
            fw = new FileWriter(file+"\\"+id+".txt",true);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            fw.write(text);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
    public void createFile(String id){
        File holder = new File(file+"\\"+id+".txt");
        if (!holder.exists()) {
            try {
                holder.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }
    public int countFiles(){
        File[] files = new File(file).listFiles();
        return files.length;
    }
}
