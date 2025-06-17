package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.models.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Integer> {

    Personal findByRut(String rut);

}

