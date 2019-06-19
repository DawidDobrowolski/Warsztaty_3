package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/groups/update")
public class Admin_groupsUpdate extends HttpServlet {

    Group group;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        group.setName(name);

        GroupDao groupDao = new GroupDao();
        groupDao.update(group);

        response.sendRedirect("/admin/groups");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));

        GroupDao groupDao = new GroupDao();
        group = groupDao.read(groupId);

        request.setAttribute("group", group);
        getServletContext().getRequestDispatcher("/adminGroups_Update.jsp")
                .forward(request, response);

    }
}
