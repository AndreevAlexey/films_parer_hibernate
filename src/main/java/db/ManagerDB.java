package db;

import repository.FilmRepository;
import repository.YearRepository;

import java.sql.*;
import java.util.Properties;

public class ManagerDB {
    private final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String DB_Driver = "org.postgresql.Driver";
    private Connection connection;
    private static ManagerDB instance = null;

    private FilmRepository filmRepository;
    private YearRepository yearRepository;

    private ManagerDB() {
    }


    public void init() {
        filmRepository = new FilmRepository();
        yearRepository = new YearRepository();
    }

    public Connection getConnection() {
        return connection;
    }

    public static ManagerDB getInstance() {
        if(instance == null) instance = new ManagerDB();
        return instance;
    }

    public void connect() {
        try {
            //Проверяем наличие JDBC драйвера для работы с БД
            Class.forName(DB_Driver);
            //параметры подключения
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "postgres");
            //соединениесБД
            Connection connection = DriverManager.getConnection(DB_URL, props);
            this.connection = connection;
            System.out.println("Соединение с СУБД выполнено.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
    }

    // отключение от БД
    public void disconnect() throws SQLException {
        if(connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Отключение от СУБД выполнено.");
        }
    }

    // переподключение к БД
    public void reconnect() throws SQLException {
        if(connection == null || connection.isClosed())
            connect();
    }

    public void executeSql(String sql) throws SQLException {
        reconnect(); // переоткрываем (если оно неактивно) соединение с СУБД
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql); // Выполняем statement - sql команду
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public ResultSet executeSqlWithResult(String sql) throws SQLException {
        reconnect(); // переоткрываем (если оно неактивно) соединение с СУБД
        ResultSet resultSet = null;
        try (Statement statement = connection.createStatement()) {
            // Выполняем statement - sql команду
            resultSet = statement.executeQuery(sql);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return resultSet;
    }
    public void createTables() throws SQLException {
        filmRepository.createTable();
        yearRepository.createTable();
    }

    public FilmRepository getFilmRepository() {
        return filmRepository;
    }

    public YearRepository getYearRepository() {
        return yearRepository;
    }

    public void start() throws SQLException {
        init();
        connect();
        createTables();
    }

}
