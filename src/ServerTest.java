

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import DataBase.Controller;
import DataBase.DataBase;
import DataBase.datasController;
import tasks.SignUpAndLogin;

public class ServerTest {
    private static File[] file = new File[13];
    private static String[] texts = new String[13];
    ServerTest(){
    }
    public static void main(String[] args) {
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
        for (int i = 0; i < file.length; i++) {
            DataBase.getDataBase().addToDataBase(texts[i],new Controller(file[i].getAbsolutePath()+texts[i]+".txt"));
        }
        DataBase.getDataBase().addToDataBase("PeopleAccounts",new Controller("D:\\ApProjectDataBase\\DataBase\\Accounts\\PeopleAccounts.txt"));
        DataBase.getDataBase().addToDataBase2("PeopleAccounts",new datasController("D:\\ApProjectDataBase\\DataBase\\Accounts\\datas"));
        DataBase.getDataBase().addToDataBase2("Communities",new datasController("D:\\ApProjectDataBase\\DataBase\\Communities\\datas"));
        DataBase.getDataBase().addToDataBase2("Posts",new datasController("D:\\ApProjectDataBase\\DataBase\\Posts\\datas"));
        DataBase.getDataBase().addToDataBase2("Comments",new datasController("D:\\ApProjectDataBase\\DataBase\\Comments\\datas"));
        DataBase.getDataBase().addToDataBase2("ChatRoomAccounts",new datasController("D:\\ApProjectDataBase\\DataBase\\ChatRooms\\datas"));
        DataBase.getDataBase().addToDataBase2("ChatRoomData",new datasController("D:\\ApProjectDataBase\\DataBase\\ChatRooms\\datas"));
        System.out.println(SignUpAndLogin.signUp("email@gmail.com", "username", "password"));
        System.out.println(SignUpAndLogin.signUp("bye@hello.com", "username2", "password"));
        System.out.println(SignUpAndLogin.signUp("byee@hello.com", "username2", "password"));
        System.out.println(SignUpAndLogin.signUp("byee@hello.com", "username3", "password"));
        // System.out.println("Server is running...");
        // while (true) {
        // try {
            // ServerSocket serverSocket = new ServerSocket(8080);
            


        //     System.out.println("Server is running");
        //     Socket socket = serverSocket.accept();
        //     System.out.println("Client connected");
        //     DataOutputStream outputStream =new DataOutputStream(socket.getOutputStream());
        //     DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        //     int count;
        //     while ((count = inputStream.readByte()) != 0) {
        //         System.out.println("Client request: " + (char)count);
        //     }
        //     System.out.println("request is done");
        //     Scanner scanner = new Scanner(System.in);
        //     outputStream.writeChars(scanner.next());
        //     outputStream.flush();
        //     socket.close();

        // }catch (Exception ignored){}
    // }
    }
}
