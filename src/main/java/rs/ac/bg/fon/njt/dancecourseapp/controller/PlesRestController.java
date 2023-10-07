package rs.ac.bg.fon.njt.dancecourseapp.controller;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.dancecourseapp.dto.PlesDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.service.impl.PlesServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/ples")
public class PlesRestController {

    private final PlesServiceImpl plesService;

    public PlesRestController(PlesServiceImpl plesService) {
        this.plesService = plesService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<PlesDto>> vratiSvePlesove(){
        //pomocu servisa iz baze izvlacimo sve plesove i smestamo u listu plesova
        List<PlesDto> plesovi = plesService.nadjiSvePlesove();
        //posto vracamo ResponseEntity moramo da pravimo takav objekat i u njega smestamo listu i http status
        return new ResponseEntity<>(plesovi, HttpStatus.OK);
    }


    @PostMapping("/add")
    // objekat dat u json formatu i stavljamo posebnu anotaciju za ovaj parametar
    public ResponseEntity<Object> dodajPles(@Valid @RequestBody PlesDto plesDto){
        try {
            PlesDto ples = plesService.dodajPles(plesDto);
            return new ResponseEntity<>(ples, HttpStatus.CREATED);//saljemo ovaj status jer se kreirao novi ples
        }catch (InvalidEntityException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }


    @PutMapping("/update")
    public ResponseEntity<Object> izmeniPles(@RequestBody PlesDto plesDto){
        try {
            PlesDto ples = plesService.izmeniPles(plesDto);
            return new ResponseEntity<>(ples, HttpStatus.OK);
        }catch (InvalidEntityException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> obrisiPles(@PathVariable("id") int id){
        try{
            plesService.obrisiPles(id);
            return new ResponseEntity<>(HttpStatus.OK);//samo da se uspesno javi da je uspesno izbrisan zaposleni iz baze
        }catch (InvalidEntityException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
