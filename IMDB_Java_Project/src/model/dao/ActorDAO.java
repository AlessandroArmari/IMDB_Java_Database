package model.dao;

import java.util.List;

import model.Actor;

//this is an interface. This means that
//I will use theese empty methods in the class implementing this interface (ActorDAOImpl.java)

public interface ActorDAO {

    public Actor save(Actor actor);

    public Actor update(Actor newActor);

    public Actor updateByName(Actor newActor);

    public void deleteByID(int id);

    public void deleteAll();

    public List<Actor> getAll();

    public void truncateAllActors();
}
