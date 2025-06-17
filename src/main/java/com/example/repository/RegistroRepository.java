package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.models.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    // Buscar por id del registro
    Registro findByIdRegistro(Integer idRegistro);
    // Buscar por id del pabellón
    List<Registro> findByPabellon_IdPabellon(Integer idPabellon);


}

