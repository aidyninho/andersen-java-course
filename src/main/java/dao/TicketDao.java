package dao;

import model.BusTicket;
import model.Client;
import model.Type;
import util.ConnectionManager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao {

    private static final TicketDao INSTANCE = new TicketDao();
    private static final String SAVE_SQL = """
            INSERT INTO tickets (user_id, ticket_type, created_at) 
            VALUES (?, ?::ticket_type, ?);
            """;
    private static final String DELETE_SQL = """
            DELETE FROM tickets
            WHERE id = ?;
            """;
    private static final String UPDATE_SQL = """
            UPDATE tickets 
            SET ticket_type = ?::ticket_type
            WHERE id = ?
            """;
    private static final String SELECT_SQL = """
            SELECT *
            FROM tickets
            WHERE id = ?
            """;
    private static final String SELECT_BY_USER_SQL = """
            SELECT *
            FROM tickets
            WHERE user_id = ?
            """;

    private TicketDao() {
    }

    public BusTicket save(BusTicket ticket) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setLong(1, ticket.getUser().getId());
            preparedStatement.setString(2, ticket.getTicketType().name());
            preparedStatement.setDate(3, Date.valueOf(ticket.getStartDate()));

            preparedStatement.executeUpdate();

            return ticket;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<BusTicket> findById(Long id) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SELECT_SQL)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            BusTicket ticket = null;
            if (resultSet.next()) {
                ticket = new BusTicket();
                ticket.setId(resultSet.getLong(1));
                ticket.setTicketType(Type.valueOf(resultSet.getString(3)));
                ticket.setStartDate(String.valueOf(resultSet.getDate(4)));
            }
            return Optional.ofNullable(ticket);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BusTicket> findAllByUserId(Long userId) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SELECT_SQL)) {
            preparedStatement.setLong(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<BusTicket> tickets = new ArrayList<>();
            BusTicket ticket = null;
            while (resultSet.next()) {
                ticket = new BusTicket();
                ticket.setId(resultSet.getLong(1));
                ticket.setTicketType(Type.valueOf(resultSet.getString(2)));
                ticket.setStartDate(String.valueOf(resultSet.getDate(3)));
                tickets.add(ticket);
            }

            preparedStatement.executeUpdate();

            return tickets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(BusTicket ticket) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, ticket.getTicketType().name());
            preparedStatement.setLong(2, ticket.getId());

            preparedStatement.executeUpdate();
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

    public static TicketDao getInstance() {
        return INSTANCE;
    }
}
