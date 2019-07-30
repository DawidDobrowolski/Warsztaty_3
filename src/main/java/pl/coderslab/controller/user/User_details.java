package pl.coderslab.controller.user;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groups/users/user")
public class User_details extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));

        UserDao dao = new UserDao();
        User user = dao.read(userId);

        SolutionDao solutionDao = new SolutionDao();
        Solution[] solutions = solutionDao.findAllByUserID(user);

        request.setAttribute("user", user);
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/views/user/user.jsp")
                .forward(request,response);
    }
}
