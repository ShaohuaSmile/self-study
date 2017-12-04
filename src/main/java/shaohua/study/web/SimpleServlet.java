package shaohua.study.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/10/27
 */
public class SimpleServlet extends HttpServlet {
    /**
     *  This method is override from GenericServlet, it will be called by Servlet.init(ServletConfig)
     */
    @Override
    public void init(){
        System.out.println("----SimpleServlet init.....");
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(".....SimpleServlet service method has been called.....");
        String userName = request.getParameter("userName");
        OutputStream outputStream = response.getOutputStream();
        String content = String.format("Hi %s, Welcome to this website, happy a nice day!",userName==null?"dear":userName);
        outputStream.write(content.getBytes("utf-8"));
        outputStream.flush();
    }
    @Override
    public void destroy(){
        System.out.println("-----SimpleServlet destroy.....");
    }
}
