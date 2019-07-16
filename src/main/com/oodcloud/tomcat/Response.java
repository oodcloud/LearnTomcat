package oodcloud.tomcat;

import java.io.*;
import java.util.Locale;

/**
 * @author wangyujie
 * 2019/7/14
 */
public class Response implements  ServletResponse{
    private static final int BUFFER_SIZE = 1024;
    private Request request;
    private OutputStream outputStream;
    private PrintWriter printWriter;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch!=-1) {
                    outputStream.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            }
            else {
                // file not found
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                outputStream.write(errorMessage.getBytes());
            }
        }
        catch (Exception e) {
            // thrown if cannot instantiate a File object
            System.out.println(e.toString() );
        }
        finally {
            if (fis!=null)
                fis.close();
        }
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        printWriter = new PrintWriter(outputStream,true);
        return printWriter;
    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public void setBufferSize(int var1) {

    }

    @Override
    public void setCharacterEncoding(String var1) {

    }

    @Override
    public void setContentLength(int var1) {

    }

    @Override
    public void setContentType(String var1) {

    }

    @Override
    public void setLocale(Locale var1) {

    }
}
