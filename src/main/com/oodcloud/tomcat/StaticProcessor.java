package oodcloud.tomcat;

import java.io.IOException;

/**
 * @author wangyujie
 * 2019/7/15
 */
public class StaticProcessor {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
