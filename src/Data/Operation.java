package Data;

public class Operation {


    private final String message;

    public Operation(String message) {
        this.message = message;
        System.out.println("The required operation is "+ message);
    }

    public String getMessage() {
        return message;
    }
}
