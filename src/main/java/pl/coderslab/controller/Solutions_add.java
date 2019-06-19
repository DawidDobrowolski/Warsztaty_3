package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/solutions/add")
public class Solutions_add extends HttpServlet {

    User[] users;
    Exercise[] exercises;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int exerciseId = Integer.parseInt(request.getParameter("exercise"));
        for (Exercise ex : exercises) {
            if (ex.getId() == exerciseId) {
                Exercise exercise = ex;
            }
        }
        int userId = Integer.parseInt(request.getParameter("user"));
        for (User us : users) {
            if (us.getId() == userId) {
                User user = us;
            }
        }
        String description = request.getParameter("description");


        Solution solution = new Solution(exercise, user, description);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("/");

        UserDao userDao = new UserDao();
        ExerciseDao exerciseDao = new ExerciseDao();

        users = userDao.findAll();
        exercises = exerciseDao.findAll();

        request.setAttribute("users", users);
        request.setAttribute("exercises", exercises);
        getServletContext().getRequestDispatcher("/solutionAdd.jsp").forward(request, response);


    }
}
