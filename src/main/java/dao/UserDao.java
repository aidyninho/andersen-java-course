package dao;

import model.Client;
import model.base.User;
import util.ConnectionManager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();
    private static final String SAVE_SQL = """
            INSERT INTO users (name, created_at) 
            VALUES (?, ?);
            """;
    private static final String DELETE_SQL = """
            DELETE FROM users
            WHERE id = ?;
            """;
    private static final String SELECT_SQL = """
            SELECT *
            FROM users
            WHERE id = ?
            """;

    private UserDao() {
    }

    public User save(User user) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setDate(2, Date.valueOf(user.getCreatedAt()));

            preparedStatement.executeUpdate();

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findById(Long id) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SELECT_SQL)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new Client();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setCreatedAt(String.valueOf(resultSet.getDate(3)));
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(Long id) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
