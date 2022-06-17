package DataBase;

import java.io.File;
import java.io.FileWriter;


public class RefreshFile {
    public static void main(String[] args) {
        File[] file = new File[13];

        String[] texts = new String[13];
        FileWriter[] fileWriters = new FileWriter[13];
        file[0] = new File("D:\\ApProjectDataBase\\DataBase\\Accounts");
        file[1] = new File("D:\\ApProjectDataBase\\DataBase\\Accounts");
        file[2] = new File("D:\\ApProjectDataBase\\DataBase\\Accounts");
        file[3] = new File("D:\\ApProjectDataBase\\DataBase\\Accounts");

        file[4] = new File("D:\\ApProjectDataBase\\DataBase\\Communities");
        file[5] = new File("D:\\ApProjectDataBase\\DataBase\\Communities");
        file[6] = new File("D:\\ApProjectDataBase\\DataBase\\Communities");
        file[7] = new File("D:\\ApProjectDataBase\\DataBase\\Communities");

        file[8] = new File("D:\\ApProjectDataBase\\DataBase\\Posts");
        file[9] = new File("D:\\ApProjectDataBase\\DataBase\\Posts");

        file[10] = new File("D:\\ApProjectDataBase\\DataBase\\Posts");

        file[11] = new File("D:\\ApProjectDataBase\\DataBase\\ChatRooms");
        file[12] = new File("D:\\ApProjectDataBase\\DataBase\\ChatRooms");


        texts[0] = "PeopleAccounts";
        texts[1] = "PeopleCommunities";
        texts[2] = "PeoplePosts";
        texts[3] = "PeopleComments";

        texts[4] = "Communities";
        texts[5] = "CommunitiesPosts";
        texts[6] = "CommunitiesAdmins";
        texts[7] = "CommunitiesPosts";

        texts[8] = "Posts";
        texts[9] = "PostsComments";

        texts[10] = "Comments";

        texts[11] = "ChatRoomAccounts";
        texts[12] = "ChatRoomData";
        try{
            for (File item :
                    file) {
             if (!item.exists()){
                 item.mkdirs();
             }
            }
        }catch (Exception ignored){}
        try{
            for (int i = 0; i < file.length; i++) {
                File f = new File(file[i].getAbsoluteFile()+"\\"+texts[i]+".txt");
                f.createNewFile();
                fileWriters[i] = new FileWriter(f);
            }
        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
