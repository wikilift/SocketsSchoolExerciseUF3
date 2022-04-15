package Data;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() {


        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the operation");
                String answer = sc.nextLine();
                Socket myAwesomeSocket = new Socket("localhost", 9999);


                DataOutputStream outputStream = new DataOutputStream(myAwesomeSocket.getOutputStream());
                outputStream.writeUTF(answer);
                Thread.sleep(200);
                System.out.println("wants to perform another operation? S/N");
                if(sc.next().equalsIgnoreCase("n")){
                    outputStream.close();
                    myAwesomeSocket.close();
                    sc.close();
                    System.out.println("\n\n See you soon thank you!");
                    System.exit(0);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
