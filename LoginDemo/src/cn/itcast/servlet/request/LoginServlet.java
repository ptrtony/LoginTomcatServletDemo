package cn.itcast.servlet.request;

import cn.itcast.servlet.entity.UserBean;
import cn.itcast.servlet.entity.UserDao;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        System.out.println("username=" + username + "====" + "password=" + password);
        UserDao userDao = new UserDao();
        UserBean login = userDao.login(userBean);
        if (login != null) {
            request.setAttribute("username", login.getUsername());
            request.getRequestDispatcher("/successServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/failedServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
