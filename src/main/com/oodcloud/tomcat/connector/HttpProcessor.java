package oodcloud.tomcat.connector;

import oodcloud.tomcat.core.ServletProcessor;
import oodcloud.tomcat.core.StaticResourceProcessor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wangyujie
 * @ClassName HttpProcessor
 * @Description 解析器
 * 工作职责：
 * 处理请求数据
 * 处理返回数据
 * @date 2019/7/16 0016
 */
public class HttpProcessor {
    private HttpConnector httpConnector;
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

    public HttpProcessor(HttpConnector httpConnector) {
        this.httpConnector = httpConnector;
    }

    public void process(Socket socket) {
        SocketInputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new SocketInputStream(socket.getInputStream(), 2048);
            outputStream = socket.getOutputStream();
            httpRequest = new HttpRequest(inputStream);
            httpResponse = new HttpResponse(outputStream);
            httpResponse.setHttpRequest(httpRequest);
            httpResponse.setHeader("Server", "Pyrmont Servlet Container");
            parseRequest(inputStream, outputStream);
            parseHeaders(inputStream);

            if (httpRequest.getUri().startsWith("/servlet/")) {
                ServletProcessor servletProcessor = new ServletProcessor();
                servletProcessor.process(httpRequest, httpResponse);
            } else {
                StaticResourceProcessor staticResourceProcessor = new StaticResourceProcessor();
                staticResourceProcessor.process(httpRequest, httpResponse);
            }
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseHeaders(SocketInputStream inputStream) {

    }

    private void parseRequest(SocketInputStream inputStream, OutputStream outputStream) {

    }
}
