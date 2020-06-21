package web;

import entity.User;
import service.impl.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setUserServlet")
public class SetUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        user.setAddress(address);
        user.setAddress(gender);
        user.setQq(qq);
        user.setEmail(email);
        UserService userService = new UserServiceImpl();
        userService.modifyUser(user);
        response.sendRedirect("/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
