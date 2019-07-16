package oodcloud.tomcat.core;

import oodcloud.tomcat.connector.HttpRequest;
import oodcloud.tomcat.connector.HttpResponse;

import java.io.IOException;

/**
 * @author wangyujie
 * 2019/7/15
 */
public class StaticResourceProcessor {
    public void process(HttpRequest httpRequest, HttpResponse httpResponse) {
        try {
            httpResponse.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
