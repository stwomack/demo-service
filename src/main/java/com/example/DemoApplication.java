package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Random;
import java.util.stream.Stream;

@RepositoryRestResource
interface AuthorizationRepository extends PagingAndSortingRepository<AuthRequest, Long> {
}

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Autowired
    AuthorizationRepository reservationRepository;
    @Bean
    CommandLineRunner startupClr(AuthorizationRepository reservationRepository) {
        return args -> {
            Stream.of("Credit", "Debit", "EBT")
                    .forEach(name -> reservationRepository.save(new AuthRequest(name, new Random().nextBoolean())));
            reservationRepository.findAll().forEach(System.out::println);
        };

    }

}