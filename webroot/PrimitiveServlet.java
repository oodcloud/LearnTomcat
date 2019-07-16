import oodcloud.tomcat.*;
import oodcloud.tomcat.connector.ServletRequest;
import oodcloud.tomcat.connector.ServletResponse;
import oodcloud.tomcat.exception.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangyujie
 * @ClassName PrimitiveServlet
 * @Description
 * @date 2019/7/16 0016
 */
public class PrimitiveServlet implements Servlet {
    @Override
    public void init(ServletConfig var1) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Hello world");
        printWriter.println("world is blue");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

