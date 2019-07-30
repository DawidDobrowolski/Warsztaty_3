package pl.coderslab.controller.user;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groups/users")
public class Users_home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));

        UserDao dao = new UserDao();
        User[] users = dao.findAllByGroupID(groupId);

        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/views/user/users.jsp")
                .forward(request,response);
    }
}
