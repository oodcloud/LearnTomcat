package oodcloud.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * @author wangyujie
 * 2019/7/15
 */
public interface ServletRequest {

    Object getAttribute(String var1);

    Enumeration<String> getAttributeNames();

    String getCharacterEncoding();

    int getContentLength();

    String getContentType();


    String getLocalAddr();

    Locale getLocale();

    Enumeration<Locale> getLocales();

    String getLocalName();

    int getLocalPort();

    String getParameter(String var1);

    Map<String, String[]> getParameterMap();

    Enumeration<String> getParameterNames();

    String[] getParameterValues(String var1);

    String getProtocol();

    BufferedReader getReader() throws IOException;

    String getRealPath(String var1);

    String getRemoteAddr();

    String getRemoteHost();

    int getRemotePort();


    String getScheme();

    String getServerName();

    int getServerPort();


    boolean isAsyncStarted();

    boolean isAsyncSupported();

    boolean isSecure();

    void removeAttribute(String var1);

    void setAttribute(String var1, Object var2);

    void setCharacterEncoding(String var1) throws UnsupportedEncodingException;

}
