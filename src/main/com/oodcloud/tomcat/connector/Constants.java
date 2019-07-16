package oodcloud.tomcat.connector;

import java.io.File;

public class Constants {
  public static final String WEB_ROOT =
    System.getProperty("user.dir") + File.separator  + "webroot";

  public static byte[] responseHeader =("HTTP/1.1 200 Hello world\r\n" +
          "Content-Type: text/html\r\n"+ "\r\n").getBytes();
  public static String Package;
}