package service;

import model.Film;
import model.Year;
import db.ManagerDB;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Service {
    private final ManagerDB managerDB;

    public Service() throws SQLException {
        managerDB = ManagerDB.getInstance();
        managerDB.start();
    }

    public Map<String, Long> getYearsMapFromDB() throws SQLException {
         return managerDB.getYearRepository().getAllRows();
    }

    public void addYearToDB(Year year) throws SQLException {
        managerDB.getYearRepository().insertRow(year);
    }

    public long getYearIdFromDB(String year)  throws SQLException {
        return managerDB.getYearRepository().getId(year);
    }

    public void addFilmToDB(Film film) throws SQLException {
        managerDB.getFilmRepository().insertRow(film);
    }

    public void addFilmsToDB(List<Film> films) throws SQLException {
        managerDB.getFilmRepository().insertRows(films);
    }
}
