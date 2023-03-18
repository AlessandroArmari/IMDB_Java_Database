package model;

//We create the basic-java-classes 

public class Actor {
    private int id;
    private String name;
    private boolean oscarWinner;

    // I created 2 constructors, one of them without id
    // Because in SQL database the id will be generated automatically

    public Actor(String name, boolean oscarWinner) {
        this.name = name;
        this.oscarWinner = oscarWinner;
    }

    public Actor(int id, String name, boolean oscarWinner) {
        this.id = id;
        this.name = name;
        this.oscarWinner = oscarWinner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOscarWinner() {
        return oscarWinner;
    }

    public void setOscarWinner(boolean oscarWinner) {
        this.oscarWinner = oscarWinner;
    }

    @Override
    public String toString() {
        return "Actor [id=" + id + ", name=" + name + ", oscarWinner=" + oscarWinner + "]";
    }

}
