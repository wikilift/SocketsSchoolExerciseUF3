package Data;

import Domain.OperationRepo;
import Domain.OperationRepoImpl;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() {
        OperationRepo brain = new OperationRepoImpl();
        try {


            ServerSocket serverListener = new ServerSocket(9999);

            while (true) {

                Socket miSocket = serverListener.accept();

                DataInputStream inputStream = new DataInputStream(miSocket.getInputStream());
                String inputText = inputStream.readUTF();
                if(!inputText.isBlank()){
                    Operation op = new Operation(inputText);
                    System.out.println(brain.doOperation(op));
                    miSocket.close();

                }




            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("no recibo datos");
        }

    }



}

