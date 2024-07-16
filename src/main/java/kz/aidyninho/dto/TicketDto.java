package kz.aidyninho.dto;

import kz.aidyninho.model.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private Long id;
    private Long userId;
    private Type type;
    private LocalDate createdAt;
}
