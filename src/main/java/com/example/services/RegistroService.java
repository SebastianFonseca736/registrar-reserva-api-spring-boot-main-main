package com.example.services;

import com.example.models.Registro;
import com.example.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    // Obtener todos los registros
    public List<Registro> getAll() {
        return registroRepository.findAll();
    }

    // Agregar un nuevo registro
    public Registro add(Registro registro) {
        return registroRepository.save(registro);
    }

    // Eliminar un registro por ID
    public boolean deleteById(Integer id) {
        if (registroRepository.existsById(id)) {
            registroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Obtener registros por ID de pabellón
    public List<Registro> getByPabellonId(Integer idPabellon) {
        return registroRepository.findByPabellon_IdPabellon(idPabellon);
    }

    // Obtener un registro por ID
    public Optional<Registro> getById(Integer id) {
        return registroRepository.findById(id);
    }
}
