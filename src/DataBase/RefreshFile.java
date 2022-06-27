package DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class RefreshFile {
    public static void main(String[] args) throws IOException {
        File[] file = new File[13];
        String[] texts = new String[13];
        FileWriter[] fileWriters = new FileWriter[13];

        file[0] = new File("D:\\ApProjectDataBase\\DataBase\\Accounts");
        file[1] = new File("D:\\ApProjectDataBase\\DataBase\\Accounts\\datas");
        file[2] = new File("D:\\ApProjectDataBase\\DataBase\\Accounts");
        file[3] = new File("D:\\ApProjectDataBase\\DataBase\\Accounts");

        file[4] = new File("D:\\ApProjectDataBase\\DataBase\\Communities");
        file[5] = new File("D:\\ApProjectDataBase\\DataBase\\Communities\\datas");
        file[6] = new File("D:\\ApProjectDataBase\\DataBase\\Communities");
        file[7] = new File("D:\\ApProjectDataBase\\DataBase\\Communities");

        file[8] = new File("D:\\ApProjectDataBase\\DataBase\\Posts");
        file[9] = new File("D:\\ApProjectDataBase\\DataBase\\Posts\\datas");

        file[10] = new File("D:\\ApProjectDataBase\\DataBase\\Comments\\datas");

        file[11] = new File("D:\\ApProjectDataBase\\DataBase\\ChatRooms");
        file[12] = new File("D:\\ApProjectDataBase\\DataBase\\ChatRooms\\datas");


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
                File f = new File(file[i].getAbsolutePath()+"\\"+texts[i]+".txt");
                if (i==1||i==5||i==9||i==10||i==12) {
                    continue;   
                }
                f.createNewFile();
                fileWriters[i] = new FileWriter(f);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        fileWriters[0].write("0 email@gmail.com userName ");
        // regex (?<UserId>[^ ]*) (?<email>[^ ]*) (?<userName>[^ ]*) 
        fileWriters[0].flush();
        fileWriters[4].write("0 ownerId ");
        // regex (?<communityId>[^ ]*) (?<ownerId>[^ ]*) 
        fileWriters[4].flush();
        fileWriters[8].write("0 0 0 ");
        // regex (?<postId>[^ ]*) (?<ownerId>[^ ]*) (?<communityId>[^ ]*) 
        fileWriters[8].flush();
        
        fileWriters[11].write("0 0 0 ");
        // regex (?<chatRoomId>[^ ]*) (?<ownerId>[^ ]*) (?<otherUserId[^ ]*)
        fileWriters[11].flush();

        File firstuser = new File("D:\\ApProjectDataBase\\DataBase\\Accounts\\Datas\\0.txt");
        firstuser.createNewFile();
        FileWriter firstuserWriter = new FileWriter(firstuser);
        firstuserWriter.write("userName email@gmail.com password {0,} {0,} {0,} {} {} {}");
        // regex (?<userName>[^ ]*) (?<email>[^ ]*) (?<pass>[^ ]*) [{]{1}(?<ownsCom>[^}]*)[}]{1} [{]{1}(?<com>[^}]*)[}]{1} [{]{1}(?<adminCom>[^}]*)[}]{1} [{]{1}(?<postId[^}]*)[}]{1} [{]{1}(?<commentId[^}]*)[}]{1} [{]{1}(?<savedPost[^}]*)[}]{1}
        firstuserWriter.flush();
        File firstCommunity = new File("D:\\ApProjectDataBase\\DataBase\\Communities\\datas\\0.txt");
        firstCommunity.createNewFile();
        FileWriter firstCommunityWriter = new FileWriter(firstCommunity);
        firstCommunityWriter.write("communityName ownerId {0,} {0,} ");
        // regex (?<communityName>[^ ]*) (?<ownerId>[^ ]*) [{]{1}(?<adminId>[^}]*)[}]{1} [{]{1}(?<postId>[^}]*)[}]{1} 
        firstCommunityWriter.flush();
        File firstPost = new File("D:\\ApProjectDataBase\\DataBase\\Posts\\datas\\0.txt");
        firstPost.createNewFile();
        FileWriter firstPostWriter = new FileWriter(firstPost);
        firstPostWriter.write("ownerId communityId {0,} postTitle\ndiscription");
        // regex (?<ownerId>[^ ]*) (?<communityId>[^ ]*) [{]{1}(?<commentId>[^}]*)[}]{1} (?<postTitle>[^ ]*)[\n](?<discription>.*)
        firstPostWriter.flush();
        File firstComment = new File("D:\\ApProjectDataBase\\DataBase\\Comments\\datas\\0.txt");
        firstComment.createNewFile();
        FileWriter firstCommentWriter = new FileWriter(firstComment);
        firstCommentWriter.write("0 0 {0,} commentTitle\ndiscription");
        // regex (?<ownerId>[^ ]*) (?<postId>[^ ]*) [{]{1}(?<commentId>[^}]*)[}]{1} (?<commentTitle>[^ ]*)[\n](?<discription>.*)
        firstCommentWriter.flush();


    }
}
