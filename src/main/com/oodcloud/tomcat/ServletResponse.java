package oodcloud.tomcat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * @author wangyujie
 * 2019/7/15
 */
public interface ServletResponse {
    void flushBuffer() throws IOException;

    int getBufferSize();

    String getCharacterEncoding();

    String getContentType();

    Locale getLocale();


    PrintWriter getWriter() throws IOException;

    boolean isCommitted();

    void reset();

    void resetBuffer();

    void setBufferSize(int var1);

    void setCharacterEncoding(String var1);

    void setContentLength(int var1);

    void setContentType(String var1);

    void setLocale(Locale var1);
}
