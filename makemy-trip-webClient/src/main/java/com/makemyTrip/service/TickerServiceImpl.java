package com.makemyTrip.service;

import com.makemyTrip.request.Passenger;
import com.makemyTrip.response.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class TickerServiceImpl implements TickerService{

    @Override
    public Mono<Ticket> bookTicket(Passenger passenger) {

        WebClient client = WebClient.create();

        String URL="http://13.235.99.170:8080/ticket";

        final Mono<Ticket> ticketMono = client.post()
                .uri(URL)
                .body(BodyInserters.fromValue(passenger))
                .retrieve()
                .bodyToMono(Ticket.class);

        return ticketMono;
    }

    @Override
    public Mono<Ticket[]> getTickets() {

        RestTemplate rt = new RestTemplate();

        String URL="http://13.235.99.170:8080/tickets";

        WebClient client = WebClient.create();

        final Mono<Ticket[]> mono = client.get()
                .uri(URL)
                .retrieve()
                .bodyToMono(Ticket[].class);

        return mono;
    }

    @Override
    public Mono<Ticket> getTicket(Integer ticketNum) {

        RestTemplate rt = new RestTemplate();

        String URL= "http://13.235.99.170:8080/ticket/{ticketNum}";

        WebClient client = WebClient.create();

        final Mono<Ticket> ticketMono = client.get()
                .uri(URL, ticketNum)
                .retrieve()
                .bodyToMono(Ticket.class);

        System.out.println(ticketMono);

        return ticketMono;
    }
}
