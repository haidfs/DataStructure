package SocketTCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws InterruptedException {
        try{
            //InetAddress localAddress = InetAddress.getLocalHost();
            Socket socket = new Socket("localhost",8088);

            //the message sending to server
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("Client send the message");
            pw.flush();
            //Disables the output stream for this socket.
            socket.shutdownOutput();

            // the message receiving from server
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine())!= null){
                System.out.println("I am the client,server return the message:"+ info);
            }

            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
