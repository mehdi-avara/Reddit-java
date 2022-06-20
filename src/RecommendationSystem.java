import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecommendationSystem {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("E:\\morteza buy bastani\\src\\post_data.csv"));
        List<String> lines = new ArrayList<>();
        List<String> categorys = new ArrayList<>();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int i = 1;
        while (i < 6000) {
            if (!categorys.contains(lines.get(i).split(",")[1]) && lines.get(i).split(",")[1].length() <= 13) {
                categorys.add(lines.get(i).split(",")[1]);
            }
            i++;
        }

    }

}
