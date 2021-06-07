package remote.exception;

/**
 * Created by mihai.mecea on 03.May.2020
 */
public class ConnectivityException extends RuntimeException {

    public ConnectivityException(String message) {
        super("Server was not reached: " + message);
    }
}
