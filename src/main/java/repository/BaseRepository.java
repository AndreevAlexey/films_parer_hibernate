package repository;

import db.ManagerDB;

import java.sql.*;

public class BaseRepository {
    protected ManagerDB managerDB = ManagerDB.getInstance();

    public void executeSql(String sql) throws SQLException {
        managerDB.reconnect(); // переоткрываем (если оно неактивно) соединение с СУБД
        try (Statement statement = managerDB.getConnection().createStatement()) {
            statement.execute(sql); // Выполняем statement - sql команду
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void executeUpdate(String sql) throws SQLException {
        managerDB.reconnect(); // переоткрываем (если оно неактивно) соединение с СУБД
        try (Statement statement = managerDB.getConnection().createStatement()) {
            System.out.println("sql = " + sql);
            statement.executeUpdate (sql); // Выполняем statement - sql команду
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public ResultSetMetaData executeSqlWithResult(String sql) throws SQLException {
        managerDB.reconnect(); // переоткрываем (если оно неактивно) соединение с СУБД
        try (Statement statement = managerDB.getConnection().createStatement()) {
            // Выполняем statement - sql команду
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            for(int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i) + " " + rsmd.getColumnClassName(i));
            }

            return resultSet.getMetaData();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return null;
    }
}
