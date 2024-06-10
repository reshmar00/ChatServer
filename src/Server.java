import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.exit;

public class Server {
    private static final int PORT = 8080;
    private static final String HTML_PATH = "/chat.html";
    private static ServerSocket serverSocket_;

    //Sec-WebSocket-Accept
    //Sec-WebSocket-Key

    @SuppressWarnings("InfiniteLoopStatement")
    public Server() throws IOException {
        try{
            serverSocket_ = new ServerSocket(8080);
            System.out.println("Server started and listening on port " + PORT);
            System.out.println("Access your HTML file at: http://" + InetAddress.getLocalHost().getHostAddress() + ":" + PORT + HTML_PATH);
            //System.out.println("Created server socket"); // used for debugging
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Server failed to connect to socket");
            System.exit(-1);
        }

        while (true){
            new ConnectionHandler().handleConnection();
            //System.out.println("Created client socket");  // used for debugging

        }
    }

    public static ServerSocket getServerSocket(){
        return serverSocket_;
    }
    public Server getServer(){
        return this;
    }


    public static void main (String[] args) throws IOException {
        new Server();
    }
}