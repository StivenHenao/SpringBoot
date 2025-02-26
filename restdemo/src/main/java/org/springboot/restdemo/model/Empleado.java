package org.springboot.restdemo.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Empleado {

    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private String puesto;

    public Empleado() {
    }

    public Empleado(String nombre, String puesto){
        this.nombre = nombre;
        this.puesto = puesto;
    }
    
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleado empleado = (Empleado) o;

        if (id != null ? !id.equals(empleado.id) : empleado.id != null) return false;
        if (nombre != null ? !nombre.equals(empleado.nombre) : empleado.nombre != null) return false;
        return puesto != null ? puesto.equals(empleado.puesto) : empleado.puesto == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, puesto);
    }

    
}