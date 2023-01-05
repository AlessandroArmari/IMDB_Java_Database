package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Movie;
import model.dao.MovieDAO;
import persistance.util.ConnectionManager;
import persistance.util.SqlQueryStorage;

public class MovieDAOImpl implements MovieDAO {

    @Override
    public Movie save(Movie movie) {
        Connection conn = ConnectionManager.getConnection();

        try {

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryStorage.insertMovie);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setDate(3, java.sql.Date.valueOf(movie.getDateRelease()));

            int rowInserted = preparedStatement.executeUpdate();

            System.out.println("LOG: Movie: " + rowInserted + " succesfully added");

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return movie;
    }

    @Override
    public Movie update(Movie newMovie) {
        Connection conn = ConnectionManager.getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryStorage.updateMovie);
            preparedStatement.setString(1, newMovie.getTitle());
            preparedStatement.setString(2, newMovie.getGenre());
            preparedStatement.setDate(3, java.sql.Date.valueOf(newMovie.getDateRelease()));

            // The fifth placeholder is the id required in the SQL query
            preparedStatement.setInt(4, newMovie.getId());

            int rowUpdate = preparedStatement.executeUpdate();

            System.out.println("LOG: movie:  " + rowUpdate + " successfully updated");

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return newMovie;
    }

    @Override
    public void deleteByID(int id) {
        Connection conn = ConnectionManager.getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryStorage.deleteMovieByID);
            preparedStatement.setInt(1, id);

            int rowDelete = preparedStatement.executeUpdate();

            System.out.println("LOG: Movie:  " + rowDelete + " deleted!");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        Connection conn = ConnectionManager.getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryStorage.deleAllMovies);
            int rowDeleted = preparedStatement.executeUpdate();

            System.out.println("LOG: All movies deleted!");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> tempMovie = new ArrayList<>();
        Connection conn = ConnectionManager.getConnection();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQueryStorage.getAllMovies);

            while (resultSet.next()) {

                int id = resultSet.getInt("id"); // nomi delle colonne nel database!
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                // LocalDate dateRelease = resultSet.getDate("dateRelease");

                tempMovie.add(new Movie(id, title, genre, null)); // convert DB item in a Java item
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return tempMovie;
    }

}