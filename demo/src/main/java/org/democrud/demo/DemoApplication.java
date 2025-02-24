package org.democrud.demo;

import org.democrud.demo.repository.ClienteRepository;
import org.slf4j.LoggerFactory;
import org.democrud.demo.model.Cliente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.classic.Logger;


@SpringBootApplication
public class DemoApplication {


	private static final Logger log = (Logger) LoggerFactory.getLogger(SpringBootApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(ClienteRepository clienteRepository) {
		return (args) -> {
			clienteRepository.save(new Cliente("Juan", "Arango"));
			clienteRepository.save(new Cliente("Sebastian", "Gomez"));
			clienteRepository.save(new Cliente("Alex", "Garcia"));
			clienteRepository.save(new Cliente("Stiven", "Henao"));

			log.info("Clientes encontrados con findAll():");
			clienteRepository.findAll().forEach(cliente -> {
				log.info(cliente.toString());
			});

			log.info("");

			log.info("Cliente encontrado con findById(1L):");
			Cliente cliente = clienteRepository.findById(1L);
			log.info(cliente.toString());

			log.info("Consulta de clientes por apellido Henao");
			Cliente henao = clienteRepository.findByApellido("Henao");
			if (henao != null) {
				log.info(henao.toString());
			}
		};
	}

}
