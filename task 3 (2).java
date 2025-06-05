
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            // Thread for receiving messages
            new Thread(() -> {
                String response;
                try {
                    while ((response = input.readLine()) != null) {
                        System.out.println("Message: " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Sending messages
            String message;
            while ((message = console.readLine()) != null) {
                output.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
