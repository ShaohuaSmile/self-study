package shaohua.study.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/10/27
 */
public class CommonFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----------filter init-----------");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---------doFilter--begin------");
//        if(!"shaohua".equals(servletRequest.getParameter("userName"))){
//            PrintWriter printWriter = servletResponse.getWriter();
//            printWriter.write("userName error!");
//            printWriter.flush();
//            System.out.println("---------doFilter--KO------");
//            return;
//        }
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("---------doFilter--end------");
    }

    public void destroy() {
        System.out.println("----------filter destroy-----------");
    }
}
