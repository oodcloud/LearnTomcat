package oodcloud.tomcat.connector.facade;


import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * @author wangyujie
 * @ClassName ResponseFacade
 * @Description
 * @date 2019/7/16 0016
 */
public class ResponseFacade implements ServletResponse {
    private ServletResponse servletResponse;

    public ResponseFacade(ServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }

    @Override
    public void flushBuffer() throws IOException {
        servletResponse.flushBuffer();
    }

    @Override
    public int getBufferSize() {
        return servletResponse.getBufferSize();
    }

    @Override
    public String getCharacterEncoding() {
        return servletResponse.getCharacterEncoding();
    }

    @Override
    public String getContentType() {
        return servletResponse.getContentType();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return servletResponse.getOutputStream();
    }

    @Override
    public Locale getLocale() {
        return servletResponse.getLocale();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return servletResponse.getWriter();
    }

    @Override
    public boolean isCommitted() {
        return servletResponse.isCommitted();
    }

    @Override
    public void reset() {
        servletResponse.reset();
    }

    @Override
    public void resetBuffer() {
        servletResponse.resetBuffer();
    }

    @Override
    public void setBufferSize(int var1) {
        servletResponse.setBufferSize(var1);
    }

    @Override
    public void setCharacterEncoding(String var1) {
        servletResponse.setCharacterEncoding(var1);
    }

    @Override
    public void setContentLength(int var1) {
        servletResponse.setContentLength(var1);
    }

    @Override
    public void setContentLengthLong(long l) {
        servletResponse.setContentLengthLong(l);
    }

    @Override
    public void setContentType(String var1) {
        servletResponse.setContentType(var1);
    }

    @Override
    public void setLocale(Locale var1) {
        servletResponse.setLocale(var1);
    }
}
