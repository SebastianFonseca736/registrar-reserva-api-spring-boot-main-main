package com.example.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pabellon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pabellon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pabellon")
    private Integer idPabellon;

    private String nombre;

    private String tipo;

    @Enumerated(EnumType.STRING)
    private EstadoPabellon estado;

    private String detalle;

    public enum EstadoPabellon {
        Disponible,
        Reservado,
        Mantencion
    }

    @JsonIgnore

    @OneToMany(mappedBy = "pabellon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Registro> registros;

}