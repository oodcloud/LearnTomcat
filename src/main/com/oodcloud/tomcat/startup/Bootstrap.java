package oodcloud.tomcat.startup;

import oodcloud.tomcat.connector.HttpConnector;

/**
 * @author wangyujie
 * @ClassName Bootstrap
 * @Description
 * @date 2019/7/16 0016
 */
public class Bootstrap {
    public static void main(String[] args) {
        HttpConnector httpConnector = new HttpConnector();
        httpConnector.start();
    }
}
