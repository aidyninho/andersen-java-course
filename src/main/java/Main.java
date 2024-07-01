import com.fasterxml.jackson.core.JsonProcessingException;
import repository.HashSetImpl;
import util.ConnectionManager;
import util.PropertiesUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        try (Connection connection = ConnectionManager.open()) {
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
