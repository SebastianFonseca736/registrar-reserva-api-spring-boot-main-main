package com.example.controllers;

import com.example.models.Registro;
import com.example.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/registros")
public class RegistroController {
    @Autowired
    private RegistroService registroService;

    // GET: Obtener todos los registros
    // api/v1/registros
    @GetMapping
    public ResponseEntity<List<Registro>> getAllRegistros() {
        List<Registro> registros = registroService.getAll();
        if (registros.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(registros);
        }
        return ResponseEntity.ok(registros);
    }
    // POST: Crear un nuevo registro
    // api/v1/registros

    @PostMapping
    public ResponseEntity<Registro> createRegistro(@RequestBody Registro registro) {
        if (registro == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Registro nuevoRegistro = registroService.add(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRegistro);
    }

    // DELETE: Eliminar un registro por su ID
    // api/v1/registros/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegistro(@PathVariable Integer id) {
    boolean eliminado = registroService.deleteById(id);
    if (eliminado) {
        return ResponseEntity.ok("Registro eliminado correctamente.");} 
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro no encontrado.");
        }
    } 
    // GET: Obtener un registro por su ID
    // api/v1/registros/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Registro> getRegistroById(@PathVariable Integer id) {
        Optional<Registro> registro = registroService.getById(id);
        if (registro.isPresent()) {
            return ResponseEntity.ok(registro.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // GET: Obtener registros por ID de pabellón
    // api/v1/registros/pabellon/{id}
    @GetMapping("/pabellon/{idPabellon}")
    public ResponseEntity<List<Registro>> getRegistrosByPabellonId(@PathVariable Integer idPabellon) {
        List<Registro> registros = registroService.getByPabellonId(idPabellon);
        if (registros.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(registros);
        }
        return ResponseEntity.ok(registros);
    }
    

  
}

