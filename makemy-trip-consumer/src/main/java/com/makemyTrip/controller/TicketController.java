package com.makemyTrip.controller;

import com.makemyTrip.request.Passenger;
import com.makemyTrip.response.Ticket;
import com.makemyTrip.service.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TicketController {

    @Autowired
    private TickerService service;

    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("passenger", new Passenger());
        return "index.html";
    }

    @PostMapping("/ticket")
    public String bookTicket(Passenger passenger,Model model){

        final Ticket ticket = service.bookTicket(passenger);

        model.addAttribute("ticket",ticket);

        return "view-ticket";
    }

    @GetMapping("/tickets")
    public String getTicketList(Model model){

        final List<Ticket> tickets = service.getTickets();

        model.addAttribute("tickets", tickets);

        return "data";
    }

    @GetMapping("/search-ticket")
    public String getTicket(Model model){

        model.addAttribute("t", new Ticket());

        return "search";
    }

    @PostMapping("/search")
    public String searchTicket(@RequestParam Integer ticketNum, Model model){

        final Ticket ticket = service.getTicket(ticketNum);

        model.addAttribute("t", ticket);

        return "search";
    }
}
