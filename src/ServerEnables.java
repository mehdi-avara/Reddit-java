import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;

import DataBase.DataBase;

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

    String reader() {
        StringBuilder read = new StringBuilder();
        StringBuilder byteCounter = new StringBuilder();
        char i;

        try {
            while ((i = (char) dis.readByte()) != '\n') {
                byteCounter.append(i);
            }
            int counter = Integer.parseInt(byteCounter.toString());
            for (int j = 0; j < counter; j++) {
                read.append((char) dis.readByte());
            }
        } catch (IOException e) {
            try {
                socket.close();
                dis.close();
                dos.close();
            } catch (IOException IO) {
                IO.printStackTrace();
            }
            e.printStackTrace();
        }
        return read.toString();
    }

    void writer(String text) {
        if (!text.isEmpty() && text != null) {
            try {
                dos.writeBytes(text);
                System.out.println("server sent: " + text);
            } catch (IOException e) {
                try {
                    socket.close();
                    dis.close();
                    dos.close();
                } catch (IOException IO) {
                    IO.printStackTrace();
                }
            }
            return;
        }
        System.out.println("server cannot send empty string,writing defeat");
    }

    @Override
    public void run() {
        String request = reader();
        String[] requestSplits = request.split(" ");

        String id = requestSplits[0];
        String command = requestSplits[1];
        String data = requestSplits[2];
        String response = "done";
        if (command.equals("read")) {
            response = DataBase.getDataBase().getControllert(id).readFile();
        } else if (command.equals("write")) {
            DataBase.getDataBase().getControllert(id).writeFile(data);
            response = data;
        } else if (command.equals("remove")) {
            DataBase.getDataBase().getControllert(id).removeId(data);
            response = data;
        } else if (command.equals("reset")) {
            DataBase.getDataBase().getControllert(id).writeFile("", true);
            response = data;
        } else if (command.equals("exit")) {
            response = "exit";
        } else {
            response = "invalid";
        }
        writer(response);
        try {
            socket.close();
            dis.close();
            dos.close();
        } catch (IOException IO) {
            IO.printStackTrace();
        }
    }
}