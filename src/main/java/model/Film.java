package model;

import java.sql.SQLException;

public class Film extends BaseModel {
    private String name;
    private String reiting;
    private int position;
    private Year year;

    public Film(String name, String reiting, int position) {
        this.name = name;
        this.reiting = reiting;
        this.position = position;
    }

    public Film() {}

    public String getName() {
        return name;
    }

    public String getReiting() {
        return reiting;
    }

    public int getPosition() {
        return position;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReiting(String reiting) {
        this.reiting = reiting;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
