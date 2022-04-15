package Domain;

import Data.Operation;

public interface OperationRepo {
    String doOperation(Operation data);
    void startServer();
    void startClient();


}
