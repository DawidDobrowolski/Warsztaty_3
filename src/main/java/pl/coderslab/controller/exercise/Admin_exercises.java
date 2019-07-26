package pl.coderslab.controller.exercise;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/exercises")
public class Admin_exercises extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciseDao dao = new ExerciseDao();
        Exercise[] exercises = dao.findAll();

        request.setAttribute("exercises", exercises);
        getServletContext().getRequestDispatcher("/adminExercises.jsp")
                .forward(request,response);
    }
}
