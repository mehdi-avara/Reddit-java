import java.io.*;
import java.lang.*;
import java.net.ServerSocket;
import java.net.*;
import java.util.*;

class Server {
    ServerSocket serverSocket;
    Socket socket;
    InputStream inputStream;
    OutputStream outputStream;
    RandomAccessFile randomAccessFile;

    Server() {
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("Server is listening on port 8888");
            socket = new Socket("192.168.1.108", 8888);
            socket = serverSocket.accept();
            System.out.println("Client connected");
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            randomAccessFile = new RandomAccessFile("ServerEnables.txt", "rw");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}