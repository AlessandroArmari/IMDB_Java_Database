package model.dao;

import java.util.List;

import model.Movie;

//this is an interface. Thi means that

//I will use theese empty methods in the classe implementing this interface! (it's in the "impl" folder)

public interface MovieDAO {

    public Movie save(Movie movie);

    public Movie update(Movie newMovie);

    public void deleteByID(int id);

    public void deleteAll();

    public List<Movie> getAll();

}
