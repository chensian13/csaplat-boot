package csa.stu.util.myutils.exception;

/**
 *
 */
public class CsaplatException extends Exception{

    public CsaplatException() {
    }

    public CsaplatException(String message) {
        super(message);
    }

    public CsaplatException(String message, Throwable cause) {
        super(message, cause);
    }

    public CsaplatException(Throwable cause) {
        super(cause);
    }

    public CsaplatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
