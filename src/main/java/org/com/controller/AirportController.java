package org.com.controller;

import org.com.dao.AirportDao;
import org.com.error.RecordNotFoundException;
import org.com.model.airport;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    private AirportDao airportDao;

        @GetMapping("/all")
        public List<airport> viewAllAirport(){
            return airportDao.viewAirport();
        }

        @GetMapping("/{id}")
        @ExceptionHandler(RecordNotFoundException.class)
        public ResponseEntity<airport> findAirportById(@PathVariable("id") String airportId){
            Optional<airport> findById = airportDao.viewAirport(airportId);
            try {
                    if (findById.isPresent()) {
                        airport airport = findById.get();
                        return new ResponseEntity<airport>(airport, HttpStatus.FOUND);
                    }
                    else {
                        throw new RecordNotFoundException("No record found with the provided " + airportId + "Airport code.");
                     }
              }
            catch (RecordNotFoundException e) {
                return new ResponseEntity("Airport Code Not found./n"+e.getMessage(),HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping("/addAirport")
        public ResponseEntity<airport> addAirport(@Valid @RequestBody airport airport){
            airportDao.addAirport(airport);
            return new ResponseEntity("Airport is created successfully", HttpStatus.CREATED);
        }
}
