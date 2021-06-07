package remote.exception;

public class ApiException extends RuntimeException {

    public final int httpCode;

    public ApiException(int httpCode) {
        super("server returned http code: " + httpCode);
        this.httpCode = httpCode;
    }
}
