import java.time.LocalDate;

import model.Actor;
import model.Movie;
import persistance.util.ConnectionManager;

public class App {
    public static void main(String[] args) throws Exception {

        ConnectionManager connectionManager = new ConnectionManager();

        // Creating istance og the class IMDB
        IMDB imdb = new IMDB();

        // Creating java movie objects
        Movie m1 = new Movie("Marnie", "Thriller", "2022-11-29");
        Movie m2 = new Movie("Bambi", "Animation", "2000-11-29");
        Movie m3 = new Movie("Spider", "Comedy", "1920-11-29");

        // Creating java actor objects
        Actor a1 = new Actor("Di Caprio", true);
        Actor a2 = new Actor("Pitt", false);
        Actor a3 = new Actor("Romin", true);

        // Adding using method to SQL

        imdb.addMovie(m1);
        imdb.addMovie(m2);
        imdb.addMovie(m3);

        imdb.addActor(a1);
        imdb.addActor(a2);
        imdb.addActor(a3);

        // Updateing a movie
        // First create a BrandNew (using costructo with ID)
        Movie m4 = new Movie(34, "Updated_Movie", "Horror", "1999-11-28");
        // THEN UPDATE
        imdb.updateMovie(m4);

        // Deleting a movie
        imdb.deleteMovieByID(37);

        // Print all movies
        // FIX IT
        // imdb.printAllMovies();

        imdb.printAllActors();

    }
}
