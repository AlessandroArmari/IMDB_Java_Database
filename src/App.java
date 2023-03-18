
import model.Actor;
import model.Movie;
import persistance.util.ConnectionManager;

public class App {
    public static void main(String[] args) throws Exception {

        // we use it to enstablish a connection to SQL
        ConnectionManager connectionManager = new ConnectionManager(); // we need :"new ConnectionManager()"

        System.out.println("");
        System.out.println("I am printing the RAM location of this variable: " + connectionManager);
        System.out.println("");
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
        System.out.println("");
        System.out.println("+++ADDING MOVIE+++");
        System.out.println("");

        imdb.addMovie(m1);
        imdb.addMovie(m2);
        imdb.addMovie(m3);

        System.out.println("");
        System.out.println("+++ADDING ACTOR+++");
        System.out.println("");

        imdb.addActor(a1);
        imdb.addActor(a2);
        imdb.addActor(a3);

        // Updating a movie
        // First create a BrandNew (using costructor with ID)
        Movie m4 = new Movie(34, "Updated_Movie", "Horror", "1999-11-28");
        // THEN UPDATE

        System.out.println("");
        System.out.println("+++UPDATE A MOVIE+++");
        System.out.println("");

        imdb.updateMovie(m4);

        System.out.println("");
        System.out.println("+++UPDATE AN ACTOR+++");
        System.out.println("");

        // I chose the SQL id I want to update
        a2.setId(55);
        imdb.updateActor(a2);

        // Deleting a movie
        System.out.println("");
        System.out.println("+++DELETE A MOVIE+++");
        System.out.println("");

        imdb.deleteMovieByID(37);

        // Deleting an actor
        System.out.println("");
        System.out.println("+++DELETE AN ACTOR+++");
        System.out.println("");

        imdb.deleteActorByID(55);

        // issue about releaseDate
        // System.out.println("");
        // System.out.println("+++PRINT ALL MOVIES+++");
        // System.out.println("");
        // imdb.printAllMovies();

        System.out.println("");
        System.out.println("+++PRINT ALL ACTORS+++");
        System.out.println("");

        imdb.printAllActors();

        System.out.println("");
        System.out.println("+++TRUNCATE ACTOR TABLE+++");
        System.out.println("");

        // imdb.truncateActorTable();

        // We use the "TRUNCATE TABLE" SQL command because it allows to erase the whole
        // content of the table and "restore" the "id" to 0.
        // That means that from now on every new element added will have an id
        // starting from "0"

        System.out.println("");
        System.out.println("+++TRUNCATE MOVIE TABLE+++");
        System.out.println("");

        // imdb.truncateMovieTable();

    }
}
