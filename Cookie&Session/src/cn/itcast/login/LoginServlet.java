package cn.itcast.login;

import com.alibaba.druid.support.json.JSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        UserBean userBean = new UserBean();
        String checkCode = "";
        for (String key : keys) {
            String[] values = parameterMap.get(key);
            if (values != null && values.length > 0) {
                for (String value : values) {
                    if (key.equals("username")) {
                        userBean.setUsername(value);
                    } else if (key.equals("password")) {
                        userBean.setPassword(value);
                    }else if (key.equals("checkCode")){
                        checkCode = value;
                    }

                }
            }
        }
        String checkCode1 = (String) request.getSession().getAttribute("checkCode");
        request.getSession().removeAttribute("checkCode");
        if (!checkCode.isEmpty() && checkCode.equalsIgnoreCase(checkCode1)){
            UserBean login = new UserDao().login(userBean);
            if (login!=null){
                request.getSession().setAttribute("user",login.getUsername());
                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else{
                request.getSession().setAttribute("error_username","用户名或密码错误");
                response.sendRedirect("/day16/login.jsp");
                request.getSession().removeAttribute("error_checkCode");
            }
        }else{
            request.getSession().setAttribute("error_checkCode","验证码错误");
            response.sendRedirect("/day16/login.jsp");
            request.getSession().removeAttribute("error_username");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
