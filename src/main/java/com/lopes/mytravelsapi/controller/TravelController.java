package com.lopes.mytravelsapi.controller;

import com.lopes.mytravelsapi.repository.TravelRepository;
import com.lopes.mytravelsapi.repository.model.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param pageable the pageable
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<Page<Travel>> listAllTravels(@PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<Page<Travel>>(travelRepository.findAll(pageable), HttpStatus.OK);
    }

    /**
     * Add travel response entity.
     *
     * @param travel the travel
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<Travel> addTravel(@RequestBody Travel travel) {
        return new ResponseEntity(travelRepository.save(travel), HttpStatus.CREATED);
    }
}
