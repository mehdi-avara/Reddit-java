

import DataBase.DataBase;
import DataBase.Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static File[] file = new File[13];
    private static String[] texts = new String[13];
    Server(){
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
    }
    public static void main(String[] args) {
        System.out.println("Server is running...");
        while (true) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            // for (int i = 0; i < file.length; i++) {
            //     DataBase.getDataBase().addToDataBase(texts[i],new Controller(file[i].getAbsolutePath()+texts[i]));
            // }
            System.out.println("Server is running");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            DataOutputStream outputStream =new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            int count;
            while ((count = inputStream.readByte()) != 0) {
                System.out.println("Client request: " + (char)count);
            }
            System.out.println("request is done");
            Scanner scanner = new Scanner(System.in);
            outputStream.writeChars(scanner.next());
            outputStream.flush();
            socket.close();

        }catch (Exception ignored){}
    }
    }
}
