package kz.aidyninho.service;

import kz.aidyninho.dto.TicketDto;
import kz.aidyninho.model.Ticket;
import kz.aidyninho.model.Type;
import kz.aidyninho.model.User;
import kz.aidyninho.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

    private static final Ticket TICKET = new Ticket(1L, new User(), Type.DAY, LocalDate.of(2024, 1, 1));
    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @Test
    public void findById() {
        doReturn(Optional.of(TICKET))
                .when(ticketRepository).findById(TICKET.getId());

        var actualResult = ticketService.findById(TICKET.getId());

        assertNotNull(actualResult.getId());

        var expectedResult = new TicketDto();

        ticketRepository.findById(TICKET.getId()).ifPresent(ticket -> {
            expectedResult.setId(ticket.getId());
            expectedResult.setUserId(ticket.getUser().getId());
            expectedResult.setType(ticket.getType());
            expectedResult.setCreatedAt(ticket.getCreatedAt());
        });

        assertEquals(expectedResult, actualResult);

        assertThrows(NoSuchElementException.class, () -> ticketService.findById(777L));
    }

    @Test
    public void save() {
        ticketService.save(TICKET);
        verify(ticketRepository, times(1)).save(TICKET);

        doThrow(IllegalArgumentException.class).when(ticketRepository).save(null);

        assertThrows(IllegalArgumentException.class, () -> ticketService.save(null));
    }

    @Test
    public void delete() {
        ticketService.delete(TICKET);
        verify(ticketRepository, times(1)).delete(TICKET);

        doThrow(IllegalArgumentException.class).when(ticketRepository).delete(null);

        assertThrows(IllegalArgumentException.class, () -> ticketService.delete(null));
    }

    @Test
    public void getTicketsFromFile() {
        ArrayList<Ticket> expectedResult = new ArrayList<>();
        User user = User.builder()
                .name("test")
                .build();


        for (long i = 0; i < 5; i++) {
            expectedResult.add(
                    Ticket.builder()
                            .id(i)
                            .user(user)
                            .build()
            );
        }

        List<Ticket> actualResult = ticketService.getTicketsFromFile(new File("src/test/resources/test.txt"));

        assertEquals(expectedResult, actualResult);

        actualResult = ticketService.getTicketsFromFile(new File("src/test/resources/testEmpty.txt"));

        assertNotEquals(expectedResult, actualResult);
    }
}
