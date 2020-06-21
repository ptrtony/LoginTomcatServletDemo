package cn.itcast.tomcat.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BufferedReader br = request.getReader();
//        String line = null;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
//        response.setContentType("/json/application");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> names = parameterMap.keySet();
        for (String name:names){
            String[] values = parameterMap.get(name);
            System.out.print(name + "：");
            for (String value : values){
                System.out.println(value);
            }

            System.out.println("----------------------");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
