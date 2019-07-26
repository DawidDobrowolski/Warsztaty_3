package pl.coderslab.controller.exercise;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/exercises/update")
public class Admin_exercisesUpdate extends HttpServlet {

    Exercise exercise;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        exercise.setTitle(title);
        exercise.setDescription(description);

        ExerciseDao exerciseDao = new ExerciseDao();
        exerciseDao.update(exercise);

        response.sendRedirect("/admin/exercises");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("id"));

        ExerciseDao exerciseDao = new ExerciseDao();
        exercise = exerciseDao.read(exerciseId);

        request.setAttribute("exercise", exercise);
        getServletContext().getRequestDispatcher("/adminExercises_Update.jsp")
                .forward(request, response);

    }
}
