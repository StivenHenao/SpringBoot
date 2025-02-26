package org.springboot.restdemo.init;

import java.util.logging.Logger;
import org.springboot.restdemo.model.Empleado;

import org.springboot.restdemo.repository.EmpleadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log  = Logger.getLogger(LoadDatabase.class.getName());
    
    @Bean
    CommandLineRunner initDatabase(EmpleadoRepository repository){
        return args -> {
            Empleado manuel = new Empleado("Manuel Arango", "CEO");
            Empleado alex = new Empleado("Alex Garcia", "Administrador");
            Empleado stiven = new Empleado("Stiven Henao", "Owner");

            log.info(String.format("Carga inicial: %s", repository.save(manuel)));
            log.info(String.format("Carga inicial: %s", repository.save(alex)));
            log.info(String.format("Carga inicial: %s", repository.save(stiven)));

        };
    }
}
