package oodcloud.tomcat.core;

import oodcloud.tomcat.Servlet;
import oodcloud.tomcat.connector.Constants;
import oodcloud.tomcat.connector.HttpRequest;
import oodcloud.tomcat.connector.HttpResponse;
import oodcloud.tomcat.exception.ServletException;
import oodcloud.tomcat.connector.facade.RequestFacade;
import oodcloud.tomcat.connector.facade.ResponseFacade;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @author wangyujie
 * 2019/7/15
 */
public class ServletProcessor {
    public void process(HttpRequest httpRequest, HttpResponse httpResponse) {
        String uri = httpRequest.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;
        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Constants.WEB_ROOT);
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Class myClass = null;
        try {
            myClass = loader.loadClass(servletName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        Servlet servlet = null;
        RequestFacade requestFacade = new RequestFacade(httpRequest);
        ResponseFacade responseFacade = new ResponseFacade(httpResponse);
        try {
            servlet = (Servlet) myClass.newInstance();
            servlet.service(requestFacade, responseFacade);
        } catch (IllegalAccessException | InstantiationException | ServletException | IOException e) {
            System.out.println(e.toString());
        }

    }
}
