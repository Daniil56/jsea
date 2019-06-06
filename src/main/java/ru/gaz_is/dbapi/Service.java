package ru.gaz_is.dbapi;

import java.sql.SQLException;

/**
 * Интрефейс определяющий методы тз.
 * @param <T> тип пользователя
 * @param <V> тип представленных данных для обработки
 */
public interface Service<T, V> {
    T getFor(V name) throws SQLException;

    void updateFor(T user) throws SQLException;
}
