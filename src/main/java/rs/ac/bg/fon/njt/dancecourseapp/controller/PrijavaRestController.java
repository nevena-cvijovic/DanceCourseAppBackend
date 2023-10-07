package rs.ac.bg.fon.njt.dancecourseapp.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.dancecourseapp.dto.PrijavaDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.model.PrijavaId;
import rs.ac.bg.fon.njt.dancecourseapp.service.impl.PrijavaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/prijava")
public class PrijavaRestController {

    private final PrijavaServiceImpl prijavaService;

    public PrijavaRestController(PrijavaServiceImpl prijavaService) {
        this.prijavaService = prijavaService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<PrijavaDto>> vratiSvePrijave(){
        List<PrijavaDto> prijave = prijavaService.nadjiSvePrijave();
        return new ResponseEntity<>(prijave, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> dodajPrijavu(@Valid @RequestBody PrijavaDto prijavaDto){

        try{
            PrijavaDto prijava = prijavaService.dodajPrijavu(prijavaDto);
            return new ResponseEntity<>(prijava, HttpStatus.CREATED);
        }catch (InvalidEntityException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


    @PutMapping("/update")
    public ResponseEntity<Object> izmeniPrijavu(@RequestBody PrijavaDto prijavaDto){
        PrijavaDto prijava = prijavaService.izmeniPrijavu(prijavaDto);
        return new ResponseEntity<>(prijava,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> obrisiPrijavu(@PathVariable("id") PrijavaId id){
        try{
            prijavaService.obrisiPrijavu(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (InvalidEntityException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
