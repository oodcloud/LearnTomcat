package oodcloud.tomcat.connector;

import oodcloud.tomcat.core.ServletProcessor;
import oodcloud.tomcat.core.StaticResourceProcessor;
import oodcloud.tomcat.exception.ServletException;

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
    private HttpRequestLine httpRequestLine = new HttpRequestLine();

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

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void parseHeaders(SocketInputStream inputStream) {

        HttpHeader httpHeader = new HttpHeader();
        inputStream.readHeader(httpHeader);
    }

    /**
     * 解析请求
     */
    private void parseRequest(SocketInputStream inputStream, OutputStream outputStream) throws ServletException {
        //行解析
        inputStream.readRequestLine(httpRequestLine);

        //请求行的方法，URI 和协议
        String method = new String(httpRequestLine.method, 0, httpRequestLine.methodEnd);
        String uri = null;
        String protocol = new String(httpRequestLine.protocol, 0, httpRequestLine.protocolEnd);

        if (method.length() < 1) {
            throw new ServletException("Miss Http request method");
        } else if (httpRequestLine.uriEnd < 1) {
            throw new ServletException("Miss Http request URI");
        }

        int question = httpRequestLine.indexOf("?");
        if (question >= 0) {
            httpRequest.setQueryString(new String(httpRequestLine.uri, question + 1, httpRequestLine.uriEnd - question - 1));
            uri = new String(httpRequestLine.uri, 0, question);
        } else {
            httpRequest.setQueryString(null);
            uri = new String(httpRequestLine.uri, 0, httpRequestLine.uriEnd);
        }

        if (!uri.startsWith("/")) {
            int pos = uri.indexOf("://");
            if (pos != -1) {
                pos = uri.indexOf("/", pos + 3);
                if (pos != -1) {
                    uri = "";
                } else {
                    uri = uri.substring(pos);
                }
            }
        }
        String math = ";jsessionid=";
        int semicolon = uri.indexOf(math);
        if (semicolon >= 0) {
            String rest = uri.substring(semicolon + math.length());
            int semicolon2 = uri.indexOf(";");
            if (semicolon2 >= 0) {
                httpRequest.setRequestedSessionId(rest.substring(0, semicolon2));
                rest = rest.substring(semicolon2);
            } else {
                httpRequest.setRequestedSessionId(rest);
                rest = "";
            }

            httpRequest.setRequestedSessionURL(true);
            uri = uri.substring(0, semicolon) + rest;
        } else {
            httpRequest.setRequestedSessionId(null);
            httpRequest.setRequestedSessionURL(false);
        }
        String normalizedUri = normalize(uri);

        httpRequest.setMethod(method);
        httpRequest.setProtocol(protocol);
        if (normalizedUri != null) {
            httpRequest.setRequestURI(normalizedUri);
        } else {
            httpRequest.setRequestURI(uri);
        }
        if (normalizedUri == null) {
            throw new ServletException("Invalid URI: " + uri + "'");
        }
    }

    private String normalize(String uri) {
        return null;
    }
}
