package repository;

import java.sql.SQLException;
import java.util.List;

public interface TableOpersDml<T> {
    void insertRows(List<T> objects) throws SQLException;
    void insertRow(T obj) throws SQLException;
}
