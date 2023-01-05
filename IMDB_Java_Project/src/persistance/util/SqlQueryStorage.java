package persistance.util;

//Here we create the query that will work in SQL
//They are string and the syntx is the same as SQL'S 

public class SqlQueryStorage {

    // +++DDL+++

    // +++rememeber to add the Schema+++

    public static final String createMovieTable = "CREATE TABLE IF NOT EXISTS imdb.movies (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, title VARCHAR(30), genre VARCHAR(30), dateRelease date);";

    public static final String createActorTable = "CREATE TABLE IF NOT EXISTS imdb.actors (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), oscarWinner boolean)";

    // +++DML+++

    // the schema imdb MUST BE CREATED manually in SQL before doing anything by JAVA

    // MOVIE QUERYS
    public static final String insertMovie = "INSERT INTO imdb.movies(title, genre, dateRelease) VALUES (?,?,?);";

    public static final String getAllMovies = "SELECT * FROM imdb.movies;";

    public static final String deleteMovieByID = "DELETE FROM imdb.movies WHERE id=?;";

    public static final String deleAllMovies = "DELETE FROM imdb.movies;";

    public static final String updateMovie = "UPDATE imdb.movies SET title=?, genre=?, dateRelease=? WHERE id=?;";

    // ACTOR QUERYS

    public static final String insertActor = "INSERT INTO imdb.actors(name, oscarWinner) VALUES (?,?)";

    public static final String getAllActors = "SELECT * FROM imdb.actors";

    public static final String deleteActorByID = "DELETE FROM imdb.actors WHERE id=?;";

    public static final String deleAllActors = "DELETE FROM imdb.actors;";

    public static final String updateActor = "UPDATE imdb.actors SET name=?, oscarWinner=? WHERE id=?;";

    public static final String updateActorByName = "UPDATE imdb.actors SET name=?, oscarWinner=? WHERE name=?;";
}
