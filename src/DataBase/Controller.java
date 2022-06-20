package DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

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

    String readFile() {
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

    void writeFile(String text, boolean... reset) {
        try {
            if (reset.length != 0) {
                fw = new FileWriter(file);
            }
            fw.write(text);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    void removeId(String id) {
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
