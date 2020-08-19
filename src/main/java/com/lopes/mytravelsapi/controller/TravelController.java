package com.lopes.mytravelsapi.controller;

import com.lopes.mytravelsapi.repository.TravelRepository;
import com.lopes.mytravelsapi.repository.model.Travel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Travel controller.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/travel")
public class TravelController {

    /**
     * The Travel service.
     */
    private final TravelRepository travelRepository;


    /**
     * Instantiates a new Travel controller.
     *
     * @param travelRepository the travel repository
     */
    public TravelController(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    /**
     * List all travels response entity.
     *
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<List<Travel>> listAllTravels() {
        List<Travel> travels = (List<Travel>) travelRepository.findAll();
        return new ResponseEntity<List<Travel>>(travels, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Travel> addTravel(@RequestBody Travel travel) {
        return new ResponseEntity(travelRepository.save(travel), HttpStatus.CREATED);
    }
}
