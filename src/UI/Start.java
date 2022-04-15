package UI;


import Domain.OperationRepo;
import Domain.OperationRepoImpl;


import java.util.Scanner;

public class Start {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        OperationRepo operator=new OperationRepoImpl() ;
        operator.startServer();
        System.out.println("Server is starting");
        Thread.sleep(2000);
        System.out.println("Server online");
        operator.startClient();
    }

}
