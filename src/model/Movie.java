package model;

import java.time.LocalDate;
//Need to import for LocalDate type
import java.time.format.DateTimeFormatter;

public class Movie {

    private int id;
    private String title;
    private String genre;
    private LocalDate dateRelease;

    public Movie(String title, String genre, String dateRelease) {
        this.title = title;
        this.genre = genre;
        this.dateRelease = LocalDate.parse(dateRelease, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public Movie(int id, String title, String genre, String dateRelease) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.dateRelease = LocalDate.parse(dateRelease, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(LocalDate dateRelease) {
        this.dateRelease = dateRelease;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", dateRelease=" + dateRelease + "]";
    }

}
