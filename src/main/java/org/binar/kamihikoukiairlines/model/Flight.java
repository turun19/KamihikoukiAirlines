package org.binar.kamihikoukiairlines.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String nomor;

    // Relasi Many-to-One dengan Model Maskapai
    @ManyToOne
    @JoinColumn(name = "maskapai_id")
    private Maskapai maskapai;

    // Relasi Many-to-One dengan Model Bandara (sebagai bandaraAsal)
    @ManyToOne
    @JoinColumn(name = "bandara_asal_id")
    private Airport bandaraAsal;

    // Relasi Many-to-One dengan Model Bandara (sebagai bandaraTujuan)
    @ManyToOne
    @JoinColumn(name = "bandara_tujuan_id")
    private Airport bandaraTujuan;

    private LocalDateTime waktuKeberangkatan;
    private LocalDateTime waktuTiba;

}
