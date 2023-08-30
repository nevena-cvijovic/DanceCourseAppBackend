package rs.ac.bg.fon.njt.dancecourseapp.controller;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.dancecourseapp.dto.RasporedKursaDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.model.RasporedKursaId;
import rs.ac.bg.fon.njt.dancecourseapp.service.impl.RasporedKursaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/rasporedKursa")
public class RasporedKursaRestController {

    private final RasporedKursaServiceImpl rasporedKursaService;

    public RasporedKursaRestController(RasporedKursaServiceImpl rasporedKursaService) {
        this.rasporedKursaService = rasporedKursaService;
    }

    //metode

    //READ
    @GetMapping("/all")
    public ResponseEntity<List<RasporedKursaDto>> vratiSveRasporede(){
        List<RasporedKursaDto> rasporedi = rasporedKursaService.nadjiSveRasporede();
        return new ResponseEntity<>(rasporedi, HttpStatus.OK);
    }

    //CREATE
    @PostMapping("/add")
    public ResponseEntity<Object> dodajRaspored(@Valid @RequestBody RasporedKursaDto rasporedKursaDto){
        try{
            RasporedKursaDto raspored = rasporedKursaService.dodajRaspored(rasporedKursaDto);
            return new ResponseEntity<>(raspored,HttpStatus.CREATED);
        }catch (InvalidEntityException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    //UPDATE
    @PutMapping("/update")
    public ResponseEntity<Object> izmeniRaspored(@RequestBody RasporedKursaDto rasporedKursaDto){
        RasporedKursaDto raspored = rasporedKursaService.izmeniRaspored(rasporedKursaDto);
        return new ResponseEntity<>(raspored,HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> obrisiRaspored(@PathVariable("id") RasporedKursaId id){
        try{
            rasporedKursaService.obrisiRaspored(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (InvalidEntityException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
