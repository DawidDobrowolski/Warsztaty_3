package pl.coderslab.controller.exercise;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/exercises/delete")
public class Admin_exercisesDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("id"));

        ExerciseDao exerciseDao = new ExerciseDao();
        exerciseDao.delete(exerciseId);

        response.sendRedirect("/admin/exercises");
    }
}
