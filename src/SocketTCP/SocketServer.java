package SocketTCP;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8088);
            //create client socket
            Socket socket = new Socket();

            //listen client's connection
            while (true){
                //accept里面本身就包含了监听
                socket = serverSocket.accept();
                ServerThread thread = new ServerThread(socket);
                thread.start();

                InetAddress address = socket.getInetAddress();
                System.out.println("now client's ip:"+address.getHostAddress());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
