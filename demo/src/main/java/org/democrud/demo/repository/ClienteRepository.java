package org.democrud.demo.repository;

import org.democrud.demo.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findById(long id);
    Cliente findByApellido(String apellido);
}