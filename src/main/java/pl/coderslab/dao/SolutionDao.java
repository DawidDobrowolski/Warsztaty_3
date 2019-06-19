package pl.coderslab.dao;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import java.sql.*;
import java.util.Arrays;

public class SolutionDao {

    private static final String CREATE_SOLUTION_QUERY =
            "INSERT INTO solutions (exercise_id, user_id, created, updated, description) VALUES (?, ?, ?, ?, ?)";
    private static final String READ_SOLUTION_QUERY =
            "SELECT * FROM solutions where id = ?";
    private static final String UPDATE_SOLUTION_QUERY =
            "UPDATE solutions SET exercise_id = ?, user_id = ?, updated = ?, description = ? WHERE id = ?";
    private static final String DELETE_SOLUTION_QUERY =
            "DELETE FROM solutions WHERE id = ?";
    private static final String FIND_ALL_SOLUTION_QUERY =
            "SELECT * FROM solutions";
    private static final String FIND_ALL_BY_USER_ID_QUERY =
            "SELECT * FROM solutions WHERE user_id = ?";
    private static final String FIND_ALL_BY_EXCLUSION_USER_ID_QUERY =
            "SELECT * FROM solutions WHERE user_id <> ?";
    private static final String FIND_ALL_BY_EXERCISE_ID_QUERY =
            "SELECT * FROM solutions WHERE exercise_id = ?";
    private static final String FIND_NUMBER_OF_SOLUTION_QUERY =
            "SELECT * FROM solutions ORDER BY updated DESC LIMIT ?";

    public Solution create(Solution solution) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(CREATE_SOLUTION_QUERY, Statement.RETURN_GENERATED_KEYS);
            preStat.setInt(1, solution.getExercise().getId());
            preStat.setInt(2, solution.getUser().getId());
            preStat.setTimestamp(3, solution.getCreated());
            preStat.setTimestamp(4, solution.getUpdated());
            preStat.setString(5, solution.getDescription());
            preStat.executeUpdate();
            ResultSet resultSet = preStat.getGeneratedKeys();
            if (resultSet.next()) {
                solution.setId(resultSet.getInt(1));
            }
            return solution;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Solution read(int solutionID) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(READ_SOLUTION_QUERY);
            preStat.setInt(1, solutionID);
            ResultSet resultSet = preStat.executeQuery();
            if (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));

                ExerciseDao exerciseDao = new ExerciseDao();
                int exerciseId = resultSet.getInt("exercise_id");
                Exercise exercise = exerciseDao.read(exerciseId);
                solution.setExercise(exercise);


                UserDao userDao = new UserDao();
                int userId = resultSet.getInt("user_id");
                User user  = userDao.read(userId);
                solution.setUser(user);


                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Solution solution) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(UPDATE_SOLUTION_QUERY);
            preStat.setInt(1, solution.getExercise().getId());
            preStat.setInt(2, solution.getUser().getId());
            preStat.setTimestamp(3, solution.getUpdated());
            preStat.setString(4, solution.getDescription());
            preStat.setInt(5, solution.getId());
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int solutionID) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(DELETE_SOLUTION_QUERY);
            preStat.setInt(1, solutionID);
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Solution[] findAll() {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_SOLUTION_QUERY);
            Solution[] solutions = findAllgetInf(preStat);
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Solution[] findNumberOf(int limit) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_NUMBER_OF_SOLUTION_QUERY);
            preStat.setInt(1, limit);
            Solution[] solutions = findAllgetInf(preStat);
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Solution[] findAllByUserID(User user) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_BY_USER_ID_QUERY);
            preStat.setInt(1, user.getId());
            Solution[] solutions = findAllgetInf(preStat);
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Solution[] findAllByExclusionUserID(User user) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_BY_EXCLUSION_USER_ID_QUERY);
            preStat.setInt(1, user.getId());
            Solution[] solutions = findAllgetInf(preStat);
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Solution[] findAllByExerciseID(Exercise exercise) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_BY_EXERCISE_ID_QUERY);
            preStat.setInt(1, exercise.getId());
            Solution[] solutions = findAllgetInf(preStat);
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Solution[] findAllgetInf(PreparedStatement preStat){
        Solution[] solutions = new Solution[0];
        try (ResultSet resultSet = preStat.executeQuery()) {
            while (resultSet.next()){
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));

                ExerciseDao exerciseDao = new ExerciseDao();
                int exerciseId = resultSet.getInt("exercise_id");
                Exercise exercise = exerciseDao.read(exerciseId);
                solution.setExercise(exercise);

                UserDao userDao = new UserDao();
                int userId = resultSet.getInt("user_id");
                User user  = userDao.read(userId);
                solution.setUser(user);

                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                solutions = addToArray(solution, solutions);
            }
            return solutions;
        } catch (SQLException e) {
                e.printStackTrace();
                return null;
        }
    }

    private Solution[] addToArray(Solution solution, Solution[] solutions) {
        Solution[] tmpSolutions = Arrays.copyOf(solutions, solutions.length + 1);
        tmpSolutions[solutions.length] = solution;
        return tmpSolutions;
    }


}
