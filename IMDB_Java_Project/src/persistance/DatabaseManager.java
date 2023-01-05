package persistance;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.dao.ActorDAO;
import model.dao.MovieDAO;
import model.dao.impl.ActorDAOImpl;
import model.dao.impl.MovieDAOImpl;
import persistance.util.ConnectionManager;
import persistance.util.SqlQueryStorage;

//HERE WE CREATE THE SQL DDL TO CREATE THE TABLES actors and movies
public class DatabaseManager {

    public void initDB() {
        Connection conn = ConnectionManager.getConnection();

        // IMPORTANT: import the correct library for Statement
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(SqlQueryStorage.createMovieTable);
            st.executeUpdate(SqlQueryStorage.createActorTable);

            System.out.println("LOG: tables 'movies' and 'actors' created");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // With this command we clear all of the tables everytime we start up App.java
        // NOW I COMMENTED IT IN ORDER NOT TO ERASE EVERYTHING ALL THE TIME
        // cleanAllTables();

    }

    public static void closeConnection() {
        ConnectionManager.closeConnection();
    }

    public void cleanAllTables() {

        MovieDAO movieDAO = new MovieDAOImpl();
        ActorDAO actorDAO = new ActorDAOImpl();

        movieDAO.deleteAll();
        actorDAO.deleteAll();

    }

}
