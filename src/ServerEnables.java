import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;

class Server {
    static boolean isServerUp = true;
    static int port = 8888;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (isServerUp) {
                Socket socket = serverSocket.accept();
                System.out.println("server is connected");
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("server cannot create and connect to client");
        }
    }
}

class RequestHandler extends Thread {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    public RequestHandler(Socket socket) {
        this.socket = socket;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("server cannot create input and output stream");
        }
    }

}