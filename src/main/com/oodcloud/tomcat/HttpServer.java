package oodcloud.tomcat;

import oodcloud.tomcat.connector.HttpRequest;
import oodcloud.tomcat.connector.HttpResponse;
import oodcloud.tomcat.core.ServletProcessor;
import oodcloud.tomcat.core.StaticResourceProcessor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangyujie
 * 2019/7/14
 */
public class HttpServer {
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    private static final String SHUTDOWN_CMD = "/SHUTDOWN";
    private boolean shutdown = false;

    public static void main(String[] args) {
        System.out.println(WEB_ROOT);
        HttpServer httpServer = new HttpServer();
        httpServer.await();
    }

    public void await() {
        /*ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!shutdown) {
            Socket socket = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                HttpRequest httpRequest = new HttpRequest(inputStream);
                httpRequest.parse();
                if ("".equals(httpRequest.getUri()) || httpRequest.getUri() == null) {
                    continue;
                }
                HttpResponse httpResponse = new HttpResponse(outputStream);
                httpResponse.setHttpRequest(httpRequest);
                if (httpRequest.getUri().startsWith("/servlet/")) {
                    ServletProcessor servletProcessor = new ServletProcessor();
                    servletProcessor.process(httpRequest, httpResponse);
                } else {
                    StaticResourceProcessor staticResourceProcessor = new StaticResourceProcessor();
                    staticResourceProcessor.process(httpRequest, httpResponse);
                }
                socket.close();
                shutdown = httpRequest.getUri().equals(SHUTDOWN_CMD);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }*/

    }
}
