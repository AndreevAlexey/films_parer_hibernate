package repository;

import exceptions.ErrorInputData;
import model.Year;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YearRepository extends BaseRepository implements TableOpersDdl, TableOpersDml<Year>{

    @Override
    public void createTable() throws SQLException {
        executeUpdate("CREATE TABLE IF NOT EXISTS year (\n" +
                            "    id serial PRIMARY KEY,\n" +
                            "    val VARCHAR NOT NULL\n" +
                            ")");
    }


    @Override
    public void insertRow(Year year) throws SQLException {
        executeUpdate("INSERT INTO year (val) values ('"+year.getVal()+"')");
    }

    @Override
    public void insertRows(List<Year> years) throws SQLException {
        StringBuilder values = new StringBuilder();
        years.forEach(year -> {
                                    if(values.length() != 0) values.append(",");
                                    values.append("('").append(year.getVal()).append("')");
                                });
        executeUpdate("INSERT INTO year (val) values " + values);
    }


    public long getId(String year) throws SQLException {
        if(year == null || year.isEmpty())
            throw new ErrorInputData("Wrong data!");
        managerDB.reconnect();
        PreparedStatement preparedStatement = managerDB.getConnection().prepareStatement("SELECT ID from year where val = ?");
        preparedStatement.setString(1,year);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return resultSet.getLong(1);
        return 0;
    }

    public Map<String, Long> getAllRows() throws SQLException {
        ResultSetMetaData queryResult =  executeSqlWithResult("SELECT id,val from year");
        //System.out.println("queryResult = " + queryResult.);
        Map<String, Long> years = new HashMap<>();
        /*
        managerDB.reconnect();
        Statement statement = managerDB.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id,val from year");
        while (resultSet.next())
            years.put(resultSet.getString("val"), resultSet.getLong("id"));

         */
        return years;
    }
    // TODO при закрытии Statement закрывается Resultset
}
