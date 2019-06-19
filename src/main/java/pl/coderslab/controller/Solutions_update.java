package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
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

@WebServlet("/solutions/update")
public class Solutions_update extends HttpServlet {

    User[] users;
    Exercise[] exercises;
    int solutionId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("exercise"));
        User user = new User();
        Exercise exercise = new Exercise();

        for (Exercise ex : exercises) {
            if (ex.getId() == exerciseId) {
                exercise = ex;
            }
        }
        int userId = Integer.parseInt(request.getParameter("user"));
        for (User us : users) {
            if (us.getId() == userId) {
                user = us;
            }
        }
        String description = request.getParameter("description");


        Solution solution = new Solution(exercise, user, description);
        solution.setId(solutionId);

        SolutionDao solutionDao = new SolutionDao();
        solutionDao.update(solution);

        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        solutionId = Integer.parseInt(request.getParameter("id"));

        UserDao userDao = new UserDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        users = userDao.findAll();
        exercises = exerciseDao.findAll();

        SolutionDao solutionDao = new SolutionDao();
        Solution solution = solutionDao.read(solutionId);
        Exercise exercise = solution.getExercise();
        User user = solution.getUser();
        String description = solution.getDescription();

        request.setAttribute("users", users);
        request.setAttribute("exercises", exercises);
        request.setAttribute("exercise", exercise);
        request.setAttribute("user", user);
        request.setAttribute("description", description);
        getServletContext().getRequestDispatcher("/solutionUpdate.jsp").forward(request, response);


    }
}
