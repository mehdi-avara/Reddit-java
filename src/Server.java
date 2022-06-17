

import DataBase.DataBase;

import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1111);
            DataBase dataBase = DataBase.getDataBase();
        }catch (Exception ignored){}
    }
}
