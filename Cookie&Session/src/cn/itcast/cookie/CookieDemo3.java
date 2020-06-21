package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieDemo")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("lastTime1")) {
                    flag = true;
                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
                    String lastTime = format.format(date);
                    String encode = URLEncoder.encode(lastTime, "utf-8");
                    cookie.setValue(encode);
                    cookie.setMaxAge(60 * 60 * 60 * 24 * 30);
                    response.addCookie(cookie);

                    String value = cookie.getValue();
                    String decode = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("欢迎回来，您上次访问的时间为：" + decode);
                    break;
                }
            }
        }
        if (cookies == null || cookies.length <= 0 || !flag) {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            String lastTime = format.format(date);
            String encode = URLEncoder.encode(lastTime, "utf-8");
            Cookie cookie = new Cookie("lastTime1", encode);
            cookie.setMaxAge(60 * 60 * 60 * 24 * 30);
            response.addCookie(cookie);
            response.getWriter().write("欢迎你首次访问");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
