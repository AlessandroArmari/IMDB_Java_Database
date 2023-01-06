import java.util.List;

import model.Actor;
import model.Movie;
import model.dao.ActorDAO;
import model.dao.MovieDAO;
import model.dao.impl.ActorDAOImpl;
import model.dao.impl.MovieDAOImpl;
import persistance.DatabaseManager;

public class IMDB {

    // Business Logic
    private DatabaseManager databaseManager;
    private MovieDAO movieDAO;
    private ActorDAO actorDAO;

    public IMDB() {
        databaseManager = new DatabaseManager();
        databaseManager.initDB();

        movieDAO = new MovieDAOImpl();
        actorDAO = new ActorDAOImpl();
    }

    // MOVIE METHOD
    public Movie addMovie(Movie movie) {
        return movieDAO.save(movie);
    }

    public void addMovies(List<Movie> movies) {
        for (Movie m : movies)
            addMovie(m);
    }

    public Movie updateMovie(Movie movie) {
        return movieDAO.update(movie);
    }

    public void deleteMovieByID(int ID) {
        movieDAO.deleteByID(ID);
    }

    public List<Movie> getAllMovies() {
        return movieDAO.getAll();
    }

    public void printAllMovies() {
        for (Movie m : getAllMovies()) {
            System.out.println(m);
        }
    }

    public void truncateMovieTable() {
        movieDAO.truncateAllMovies();
    }

    // ACTOR METHODS
    public Actor addActor(Actor actor) {
        return actorDAO.save(actor);
    }

    public void addActors(List<Actor> actors) {
        for (Actor a : actors)
            addActor(a);
    }

    public Actor updateActor(Actor actor) {
        return actorDAO.update(actor);
    }

    public Actor updateActorByName(Actor actor) {
        return actorDAO.updateByName(actor);
    }

    public void deleteActorByID(int ID) {
        actorDAO.deleteByID(ID);
    }

    public List<Actor> getAllActors() {
        return actorDAO.getAll();
    }

    public void printAllActors() {
        for (Actor a : getAllActors()) {
            System.out.println(a);
        }
    }

    public void truncateActorTable() {
        actorDAO.truncateAllActors();
    }

}
