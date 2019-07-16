package oodcloud.tomcat;

import java.util.Enumeration;

/**
 * @author wangyujie
 * @ClassName ServletConfig
 * @Description
 * @date 2019/7/16 0016
 */
public interface ServletConfig {
    String getServletName();


    String getInitParameter(String var1);

    Enumeration<String> getInitParameterNames();
}
