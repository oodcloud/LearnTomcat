package oodcloud.tomcat.connector;

import oodcloud.tomcat.core.ServletProcessor;
import oodcloud.tomcat.core.StaticResourceProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangyujie
 * @ClassName HttpConnector
 * @Description 连接器
 * 工作职责：
 * socket 建立，等待请求
 * @date 2019/7/16 0016
 */
public class HttpConnector implements Runnable {
    private boolean stopped;
    private String scheme = "http";

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port,1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!stopped) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            HttpProcessor httpProcessor = new HttpProcessor(this);
            httpProcessor.process(socket);
        }
    }

    public void start() {
        new Thread(this).start();
    }
}
