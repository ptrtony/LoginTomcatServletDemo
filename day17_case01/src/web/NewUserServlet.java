package web;

import entity.User;
import org.springframework.beans.BeanUtils;
import service.impl.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/newUserServlet")
public class NewUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = new User();
        String username = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
        user.setId(0);
        user.setName(username);
        user.setAge(Integer.valueOf(age));
        user.setGender(gender);
        user.setAddress(address);
        user.setQq(qq);
        user.setEmail(email);
        UserService userService = new UserServiceImpl();
        userService.addUser(user);
        request.getRequestDispatcher("/userListServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
