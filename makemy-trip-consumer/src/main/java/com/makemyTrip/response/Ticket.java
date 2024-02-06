package com.makemyTrip.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class Ticket {

    private Integer ticketNum;

    private String name;

    private String phno;

    private String gender;

    private String from;

    private String to;

    private LocalDate doj;

    private Double price;

    private String ticketStatus;

    private Integer trainNum;

}
