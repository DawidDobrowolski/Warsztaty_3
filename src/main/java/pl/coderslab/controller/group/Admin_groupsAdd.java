package pl.coderslab.controller.group;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/groups/add")
public class Admin_groupsAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Group group = new Group(name);

        GroupDao groupDao = new GroupDao();
        groupDao.create(group);

        response.sendRedirect("/admin/groups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/views/group/adminGroups_Add.jsp");

    }
}
