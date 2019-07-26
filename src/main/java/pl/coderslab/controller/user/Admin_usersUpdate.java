package pl.coderslab.controller.user;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Group;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/users/update")
public class Admin_usersUpdate extends HttpServlet {

    Group[] groups;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("group"));
        Group group = new Group();
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        for (Group gr : groups) {
            if (groupId == gr.getId()) {
                group = gr;
            }
        }

        User user = new User(group, userName, email, password, "0");
        UserDao userDao = new UserDao();
        userDao.update(user);
        response.sendRedirect("/admin/users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));

        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.read(userId);

        GroupDao groupDao = new GroupDao();
        groups = groupDao.findAll();


        request.setAttribute("user", user);
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/adminUsers_Update.jsp").forward(request, response);

    }
}
