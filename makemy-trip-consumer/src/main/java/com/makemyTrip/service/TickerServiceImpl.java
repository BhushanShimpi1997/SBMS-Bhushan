package com.makemyTrip.service;

import com.makemyTrip.request.Passenger;
import com.makemyTrip.response.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TickerServiceImpl implements TickerService{

    @Override
    public Ticket bookTicket(Passenger passenger) {

        RestTemplate template = new RestTemplate();

        String URL="http://13.235.99.170:8080/ticket";

        final ResponseEntity<Ticket> ticketResponseEntity = template.postForEntity(URL, passenger, Ticket.class);

        final Ticket ticketBody = ticketResponseEntity.getBody();

        return ticketBody;
    }

    @Override
    public List<Ticket> getTickets() {

        RestTemplate rt = new RestTemplate();

        String URL="http://13.235.99.170:8080/tickets";

        final ResponseEntity<Ticket[]> tickets = rt.getForEntity(URL, Ticket[].class);

        final Ticket[] resBody = tickets.getBody();

        final List<Ticket> listOfTickets = Arrays.asList(resBody);

        return listOfTickets;
    }

    @Override
    public Ticket getTicket(Integer ticketNum) {

        RestTemplate rt = new RestTemplate();

        String URL= "http://13.235.99.170:8080/ticket/{ticketNum}";

        final ResponseEntity<Ticket> response = rt.getForEntity(URL, Ticket.class, ticketNum);

        final Ticket ticket = response.getBody();

        return ticket;
    }
}
