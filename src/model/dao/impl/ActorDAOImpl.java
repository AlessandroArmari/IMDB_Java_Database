package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.dao.ActorDAO;
import persistance.util.ConnectionManager;
import persistance.util.SqlQueryStorage;

//We are implementing the interface ActorDAO

public class ActorDAOImpl implements ActorDAO {

    // now we create a link between Java methods and SQL querys

    @Override
    public Actor save(Actor actor) {
        Connection conn = ConnectionManager.getConnection();

        try {

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryStorage.insertActor);

            // WE are saying to the query "insertActor": swap the first "?" with .getName(),
            // and the second "?" witch .isOscarWinner()
            preparedStatement.setString(1, actor.getName());
            preparedStatement.setBoolean(2, actor.isOscarWinner());

            int rowInserted = preparedStatement.executeUpdate();

            System.out.println("LOG: You have inserted: " + rowInserted + " correctly!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actor;

    }

    @Override
    public Actor update(Actor newActor) {
        Connection conn = ConnectionManager.getConnection();

        try {
            // PreparedStatament starts from "1", not "0";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryStorage.updateActor);

            preparedStatement.setString(1, newActor.getName());
            preparedStatement.setBoolean(2, newActor.isOscarWinner());
            preparedStatement.setInt(3, newActor.getId());

            int rowUpdated = preparedStatement.executeUpdate();

            System.out.println("LOG: You have updated: " + rowUpdated + " correctly!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newActor;
    }

    @Override
    public Actor updateByName(Actor newActor) {
        Connection conn = ConnectionManager.getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryStorage.updateActorByName);
            preparedStatement.setString(1, newActor.getName());
            preparedStatement.setBoolean(2, newActor.isOscarWinner());

            // This down here is the "name" the SQL query needs to use the update by name!!!
            preparedStatement.setString(3, newActor.getName());

            int rowUpdated = preparedStatement.executeUpdate();

            System.out.println("LOG: You have updated: " + rowUpdated + " using 'by_name method' correctly!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newActor;

    }

    @Override
    public void deleteByID(int id) {
        Connection conn = ConnectionManager.getConnection();

        try {

            // Here I ma preparing a SQL query wich use the id we chose
            // to find the same Actor with the same Id in the Database
            // and delete it

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryStorage.deleteActorByID);
            preparedStatement.setInt(1, id);

            int rowDelete = preparedStatement.executeUpdate();

            System.out.println("LOG: deleting of: " + rowDelete + " properly executed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteAll() {

        Connection conn = ConnectionManager.getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryStorage.deleAllActors);

            int rowDeleted = preparedStatement.executeUpdate();

            System.out.println("LOG: All " + rowDeleted + " actors deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Actor> getAll() {

        List<Actor> tempActors = new ArrayList<>();
        Connection conn = ConnectionManager.getConnection();

        try {

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQueryStorage.getAllActors);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Boolean oscarWinner = resultSet.getBoolean("oscarWinner");

                tempActors.add(new Actor(id, name, oscarWinner));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tempActors;

    }

    @Override
    public void truncateAllActors() {

        Connection conn = ConnectionManager.getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryStorage.truncateAllActors);

            preparedStatement.executeUpdate();

            System.out.println("LOG: Table actor truncated");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
