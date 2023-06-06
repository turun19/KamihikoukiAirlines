package org.binar.kamihikoukiairlines.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate departureDate;

    private LocalDate arrivalDate;

    private LocalTime departureTime;

    private LocalTime arrivalTime;

    private Integer netPrice;

    public enum FlightClass {
        ECONOMY,
        BUSINESS
    }

    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;

    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;

    @JsonIgnore
    @OneToMany (mappedBy = "schedule",cascade = CascadeType.ALL)
    private List<Booking> bookingList = new ArrayList<>();

}
