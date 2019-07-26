package pl.coderslab.controller.solution;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solutions/details")
public class Solutions_details extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int solutionId = Integer.parseInt(request.getParameter("id"));

        SolutionDao solutionDao = new SolutionDao();
        Solution solution = solutionDao.read(solutionId);
        Exercise exercise = solution.getExercise();
        User user = solution.getUser();
        String description = solution.getDescription();

        request.setAttribute("exercise", exercise);
        request.setAttribute("user", user);
        request.setAttribute("description", description);
        getServletContext().getRequestDispatcher("/solutionDetails.jsp").forward(request, response);

    }
}
