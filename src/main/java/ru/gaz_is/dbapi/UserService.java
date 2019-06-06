package ru.gaz_is.dbapi;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс реализующий апи сервиса, поиска и изменения бд для User и его полей String
 */
public class UserService implements Service<User, String> {
    private  Worker dbWorker;
    private  String query;
    private Statement statement;

    public UserService() throws SQLException {
        this.dbWorker = new Worker();
    }

    /**
     * Метод поиска пользователя по логину.
     * @param name  имя пользователя
     * @return User с заданным логином
     * @throws SQLException проброска исключения
     */
    public User getFor(String name) throws SQLException {
        this.statement = dbWorker.getConnection().createStatement();
        query = "select * from users where username like '%" + name + "%' ";
        final ResultSet resultSet = statement.executeQuery(query);
        User result = new User();
        while (resultSet.next()) {
            result.setId(resultSet.getInt("id"));
            result.setSurname(resultSet.getString("lastname"));
            result.setFirstname(resultSet.getString("surname"));
            result.setUsername(resultSet.getString("username"));
        }
        return result;

    }

    /**
     * Метод обновляет данные фамилии у заданного пользователя в бд.
     *
     * @param user заданный пользователь
     * @throws SQLException исключение бд
     */
    public void updateFor(User user) throws SQLException {
        if (user.getId() > 0) {
            query = "select * from users where username like '%" + user.getUsername() + "%' ";
            statement = dbWorker.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.first();
            resultSet.updateString("surname", user.getSurname());
            resultSet.updateRow();
        }
        }

    }
