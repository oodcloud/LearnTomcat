package oodcloud.tomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyujie
 * 2019/7/14
 */
public class Request {
    private String uri;
    private InputStream inputStream;

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() {
        StringBuffer req = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i =-1;
        }
        for (int j = 0; j < i; j++) {
            req.append((char) buffer[j]);
        }
        System.out.println("----"+req.toString());

        uri = parseUri(req.toString());

    }

    private String parseUri(String requestString) {
        int index1,index2;
        index1=requestString.indexOf(" ");
        if (index1 != -1) {
            index2= requestString.indexOf(" ",index1+1);
            if (index2 > index1) {
                return  requestString.substring(index1+1,index2);
            }
        }
        return null;
    }


    public String getUri() {
        return uri;
    }

}
