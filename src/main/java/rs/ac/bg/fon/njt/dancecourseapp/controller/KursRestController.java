package rs.ac.bg.fon.njt.dancecourseapp.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KursDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.service.impl.KursServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/kurs")
public class KursRestController {

    private final KursServiceImpl kursService;

    public KursRestController(KursServiceImpl kursService) {
        this.kursService = kursService;
    }


    //metode

    //vracanje svih kurseva iz baze
    @GetMapping("/all")
    public ResponseEntity<List<KursDto>> vratiSveKurseve(){
        List<KursDto> kursevi = kursService.nadjiSveKurseve();
        return new ResponseEntity<>(kursevi, HttpStatus.OK);
    }

    //metoda za ubacivanje novog kursa u bazu
    @PostMapping("/add")
    public ResponseEntity<Object> dodajKurs(@Valid @RequestBody KursDto kursDto){
        try{
            KursDto kurs = kursService.dodajKurs(kursDto);
            return new ResponseEntity<>(kurs, HttpStatus.CREATED);
        }catch (InvalidEntityException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    //metoda za update-ovanje podataka o kursu
    @PutMapping("/update")
    public ResponseEntity<Object> izmeniKurs(@RequestBody KursDto kursDto){
        try{
            KursDto kurs = kursService.izmeniKurs(kursDto);
            return new ResponseEntity<>(kurs,HttpStatus.OK);
        }catch (InvalidEntityException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

        }
    }


    //metoda za brisanje plesa
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> obrisiKurs(@PathVariable("id") int id){
        try{
            kursService.obrisiKurs(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (InvalidEntityException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
