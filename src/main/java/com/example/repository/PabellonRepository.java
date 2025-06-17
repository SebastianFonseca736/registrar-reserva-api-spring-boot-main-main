package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.models.Pabellon;

public interface PabellonRepository extends JpaRepository<Pabellon, Integer> {

    // Buscar por id del pabellón
    Pabellon findByIdPabellon(Integer idPabellon);


}

