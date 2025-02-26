package org.springboot.restdemo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springboot.restdemo.model.Empleado;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    
}
