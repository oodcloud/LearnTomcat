package oodcloud.tomcat.exception;

/**
 * @author wangyujie
 * @ClassName ServletException
 * @Description
 * @date 2019/7/16 0016
 */
public class ServletException extends Exception {
    public ServletException() {
    }

    public ServletException(String message) {
        super(message);
    }

    public ServletException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public ServletException(Throwable rootCause) {
        super(rootCause);
    }

    public Throwable getRootCause() {
        return this.getCause();
    }
}
