package com.lopes.mytravelsapi;

import com.lopes.mytravelsapi.repository.TravelRepository;
import com.lopes.mytravelsapi.repository.model.Travel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootApplication
public class MyTravelsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTravelsApiApplication.class, args);
    }


    @Bean
    CommandLineRunner init(TravelRepository travelRepository) {
        return args -> {
            Stream.of("Servile", "Lisbon", "Madrid", "Budapest", "Brussels").forEach(city -> {
                Travel travel = new Travel(city, LocalDate.now(), 5);
                travelRepository.save(travel);
            });
            travelRepository.findAll().forEach(System.out::println);
        };
    }

}
