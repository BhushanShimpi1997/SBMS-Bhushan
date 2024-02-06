package com.makemyTrip.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Passenger {

    private String name;
    private String phno;
    private String gender;
    private String from;
    private String to;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate doj;
    private Integer trainNum;
}
