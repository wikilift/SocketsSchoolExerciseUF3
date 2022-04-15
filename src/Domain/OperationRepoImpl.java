package Domain;

import Data.Client;
import Data.Operation;
import Data.Server;

import java.util.Arrays;

public class OperationRepoImpl implements OperationRepo {
    private final String[] operations = {"-", "+", "/", "*"};
    String[] operate;
    String answer;

    @Override
    public String doOperation(Operation data) {
        String operation = "";
        for (String s : operations) {
            if (data.getMessage().contains(s)) {
                operation = s;
            }
        }
        String regexOperation;
        if (operation.equals("+")) {
            regexOperation = "\\+";
        } else if (operation.equals("*")) {
            regexOperation = "\\*";
        } else {
            regexOperation = operation;
        }
        if (!operation.isBlank()) operate = data.getMessage().split(regexOperation);
        switch (operation) {
            case "+":
                answer = String.valueOf(Arrays.stream(operate).mapToInt(Integer::parseInt).sum());
                break;
            case "-":
                answer = String.valueOf(Arrays.stream(operate).mapToInt(Integer::parseInt).reduce((left, right) -> left - right).getAsInt());
                break;
            case "*":
                answer = String.valueOf(Arrays.stream(operate).mapToInt(Integer::parseInt).reduce(1, Math::multiplyExact));
                break;
            case "/":
                answer = String.valueOf(Arrays.stream(operate).mapToInt(Integer::parseInt).reduce((left, right) -> left / right).getAsInt());
                break;

        }


        return "Result: " + String.join(operation, operate) + "= " + answer;
    }

    @Override
    public void startServer() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Server server = new Server();
            }
        });
        t.start();
    }

    @Override
    public void startClient() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Client server = new Client();
            }
        });
        t.start();
    }
}
