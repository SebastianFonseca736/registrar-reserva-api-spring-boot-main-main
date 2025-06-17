package com.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva") 
    private Integer idRegistro;


    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "id_pabellon", nullable = false)
    private Pabellon pabellon;

    @ManyToOne
    @JoinColumn(name = "id_personal", nullable = false)
    private Personal personal;

    @Column(name = "equipo_medico")
    private String equipoMedico;
}
