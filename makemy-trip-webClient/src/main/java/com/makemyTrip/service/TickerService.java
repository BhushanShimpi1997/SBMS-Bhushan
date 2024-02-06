package com.makemyTrip.service;

import com.makemyTrip.request.Passenger;
import com.makemyTrip.response.Ticket;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TickerService {

    public Mono<Ticket> bookTicket(Passenger passenger);

    public Mono<Ticket[]> getTickets();

    public Mono<Ticket> getTicket(Integer ticketNum);
}
