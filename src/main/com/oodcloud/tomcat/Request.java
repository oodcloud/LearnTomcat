package oodcloud.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * @author wangyujie
 * 2019/7/14
 */
public class Request implements ServletRequest{
    private String uri;
    private InputStream inputStream;

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() {
        StringBuffer req = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i =-1;
        }
        for (int j = 0; j < i; j++) {
            req.append((char) buffer[j]);
        }
        System.out.println("----"+req.toString());

        uri = parseUri(req.toString());

    }

    private String parseUri(String requestString) {
        int index1,index2;
        index1=requestString.indexOf(" ");
        if (index1 != -1) {
            index2= requestString.indexOf(" ",index1+1);
            if (index2 > index1) {
                return  requestString.substring(index1+1,index2);
            }
        }
        return null;
    }


    public String getUri() {
        return uri;
    }

    @Override
    public Object getAttribute(String var1) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public int getContentLength() {
        return 0;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public String getLocalAddr() {
        return null;
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public Enumeration<Locale> getLocales() {
        return null;
    }

    @Override
    public String getLocalName() {
        return null;
    }

    @Override
    public int getLocalPort() {
        return 0;
    }

    @Override
    public String getParameter(String var1) {
        return null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return null;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return null;
    }

    @Override
    public String[] getParameterValues(String var1) {
        return new String[0];
    }

    @Override
    public String getProtocol() {
        return null;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return null;
    }

    @Override
    public String getRealPath(String var1) {
        return null;
    }

    @Override
    public String getRemoteAddr() {
        return null;
    }

    @Override
    public String getRemoteHost() {
        return null;
    }

    @Override
    public int getRemotePort() {
        return 0;
    }

    @Override
    public String getScheme() {
        return null;
    }

    @Override
    public String getServerName() {
        return null;
    }

    @Override
    public int getServerPort() {
        return 0;
    }

    @Override
    public boolean isAsyncStarted() {
        return false;
    }

    @Override
    public boolean isAsyncSupported() {
        return false;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void removeAttribute(String var1) {

    }

    @Override
    public void setAttribute(String var1, Object var2) {

    }

    @Override
    public void setCharacterEncoding(String var1) throws UnsupportedEncodingException {

    }
}
