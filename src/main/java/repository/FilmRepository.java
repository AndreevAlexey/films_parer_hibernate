package repository;

import exceptions.ErrorInputData;
import model.Film;
import model.Year;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FilmRepository extends BaseRepository implements TableOpersDdl, TableOpersDml<Film>{

    @Override
    public void createTable() throws SQLException {
        executeUpdate("CREATE TABLE IF NOT EXISTS films (\n" +
                                           "                                    id serial PRIMARY KEY,\n" +
                                           "                                    name VARCHAR NOT NULL,\n" +
                                           "                                    reiting VARCHAR NOT NULL,\n" +
                                           "                                    position VARCHAR NOT NULL,\n" +
                                           "                                    year INTEGER NOT NULL,\n" +
                                           "                                    FOREIGN KEY (year) REFERENCES year (id))");
    }

    @Override
    public void insertRow(Film film) throws SQLException {
        if(film == null)
            throw new ErrorInputData("Wrong data!");
        String values = "'" + film.getName() + "'," +
                        "'" + film.getReiting() + "'," +
                        "'" + film.getPosition() + "'," +
                        film.getYear().getId();
        executeUpdate("INSERT INTO films (name, reiting, position, year) values ('" + values + "')");
    }

    @Override
    public void insertRows(List<Film> films) throws SQLException {
        StringBuilder values = new StringBuilder();
        films.forEach(film -> {
            if(film != null) {
                if(values.length() != 0) values.append(",");
                values.append("(");
                values.append("'").append(film.getName()).append("',");
                values.append("'").append(film.getReiting()).append("',");
                values.append("'").append(film.getPosition()).append("',");
                values.append(film.getYear().getId());
                values.append(")");
            }
        });

        System.out.println("FilmRepository.java.insertRows.values = " + values);
        executeUpdate("INSERT INTO films (name, reiting, position, year) values " + values);
    }

}
