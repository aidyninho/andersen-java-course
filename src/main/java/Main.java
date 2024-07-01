import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.BusTicket;
import repository.ArrayListImpl;
import repository.BusTicketRepository;
import repository.HashSetImpl;
import service.BusTicketService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        HashSetImpl<Integer> set = new HashSetImpl<>();

        set.add(0);
        set.add(1);
        set.add(2);

        set.remove(0);

        set.contains(0);

        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
