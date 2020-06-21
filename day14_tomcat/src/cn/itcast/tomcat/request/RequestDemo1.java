package cn.itcast.tomcat.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获取请求方式GET
         * 					*String getMethod()
         * 				2.获取虚拟目录：/day04
         * 					*String getContextPath()
         * 				3.获取servlet路径。/demo1
         * 					*String getServletPath()
         * 				4.获取get请求参数：username=zhangsan
         * 					*String getQueryString();
         * 				5.获取请求的url
         * 					*String getRequestURI();/day04/demo1
         * 					*StringBuffer getRequestURL();http://localhost/day04/demo1
         *
         * 					URL:统一资源定位符
         * 					URI：统一资源标识符
         *
         * 				6.获取协议及版本 HTTP/1.1
         * 					*String getProtocal();
         * 				7.获取客户机的ip地址
         * 					*String getRemoteAddr();
         */
        String method = request.getMethod();
        String contextPath = request.getContextPath();
        String queryString = request.getQueryString();
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        String protocol = request.getProtocol();
        String remoteAddr = request.getRemoteAddr();

    }
}
