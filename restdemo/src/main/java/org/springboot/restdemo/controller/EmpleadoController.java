package org.springboot.restdemo.controller;

import java.net.URI;
import java.util.List;

import org.springboot.restdemo.model.Empleado;
import org.springboot.restdemo.repository.EmpleadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Optional;

@RestController
public class EmpleadoController {
    private final EmpleadoRepository repository;

    public EmpleadoController(EmpleadoRepository repository) {
        this.repository = repository;
    }

    /* Lista todos los empleados */
    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> listAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    /* Crea un empleado a partir de un objeto JSON presente en el request */
    @PostMapping("/empleados")
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado nuevoEmpleado,
                                                   UriComponentsBuilder ucb) {
        Empleado empleadoGuardado = repository.save(nuevoEmpleado);
        URI uriEmpleado = ucb
                .path("empleados/{id}")
                .buildAndExpand(empleadoGuardado.getId())
                .toUri();
        return ResponseEntity.created(uriEmpleado).build();
    }

    /* Obtiene un empleado por medio de su ID */
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> findById(@PathVariable Long id) {
        Optional<Empleado> empleado = repository.findById(id);
        if (empleado.isPresent()) {
            return ResponseEntity.ok(empleado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<?> updateEmpleado(@RequestBody Empleado empleadoActualizado, @PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id)
                .map(empleado -> {
                    empleado.setNombre(empleadoActualizado.getNombre());
                    empleado.setPuesto(empleadoActualizado.getPuesto());
                    repository.save(empleado);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> {
                    repository.save(empleadoActualizado);
                    return ResponseEntity.ok(empleadoActualizado);
                }));
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}