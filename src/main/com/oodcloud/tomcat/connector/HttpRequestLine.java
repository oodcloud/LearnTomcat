package oodcloud.tomcat.connector;

/**
 * @author wangyujie
 * @ClassName HttpRequestLine
 * @Description
 * @date 2019/7/16 0016
 */
public class HttpRequestLine {
    public char[] method;
    public int methodEnd;
    public char[] protocol;
    public int protocolEnd;

    public int uriEnd;
    public char[] uri;

    public int indexOf(String s) {
        return 0;
    }
}
