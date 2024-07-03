import com.fasterxml.jackson.core.JsonProcessingException;
import dao.TicketDao;
import model.BusTicket;
import model.Client;
import model.Role;
import model.Type;
import model.base.User;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        TicketDao ticketDao = TicketDao.getInstance();


        BusTicket busTicket = new BusTicket();
        User user = new Client();

//        user.setId(1);
//        user.setRole(Role.CLIENT);
//
//        busTicket.setTicketType(Type.MONTH);
//        busTicket.setUser(user);
//        busTicket.setStartDate("2024-01-01");
//        ticketDao.save(busTicket);

//        busTicket.setTicketType(Type.YEAR);
//        busTicket.setId(4);
//        ticketDao.update(busTicket);

//        Optional<BusTicket> byId = ticketDao.findById(4L);
//        System.out.println(byId.get());
//
//        ticketDao.delete(4L);

        System.out.println(ticketDao.findAllByUserId(1L));
    }
}
