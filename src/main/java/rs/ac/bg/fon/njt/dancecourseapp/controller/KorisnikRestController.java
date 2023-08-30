package rs.ac.bg.fon.njt.dancecourseapp.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KorisnikDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.service.impl.KorisnikServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/korisnik")
public class KorisnikRestController {


    private final KorisnikServiceImpl korisnikService;

    public KorisnikRestController(KorisnikServiceImpl korisnikService) {
        this.korisnikService = korisnikService;
    }

    //metode


    //vracanje svih korisnika
    @GetMapping("/all")
    public ResponseEntity<List<KorisnikDto>> vratiSveKorisnike(){
        List<KorisnikDto> korisnici = korisnikService.nadjiSveKorisnike();
        return new ResponseEntity<>(korisnici, HttpStatus.OK);
    }

    //za logovanje
    @GetMapping("/find")
    public ResponseEntity<?> uloguj(@RequestBody KorisnikDto korisnikDto){
        Optional<KorisnikDto> korisnik = korisnikService.uloguj(korisnikDto);
        if(korisnik.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ovaj korisnik ne postoji u sistemu. Proveriti kredencijale");
        }
        return new ResponseEntity<>(korisnik, HttpStatus.OK);
    }

    //ubacivanje - registracija korisnika
    @PostMapping("/add")
    public ResponseEntity<Object> dodajKorisnika(@Valid @RequestBody KorisnikDto korisnikDto){
        try{
            KorisnikDto korisnik = korisnikService.dodajKorisnika(korisnikDto);
            return new ResponseEntity<>(korisnik,HttpStatus.CREATED);
        }catch (InvalidEntityException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


    @PutMapping("/update")
    public ResponseEntity<Object> izmeniKorisnika(@RequestBody KorisnikDto korisnikDto){
        KorisnikDto korisnik = korisnikService.izmeniKorisnika(korisnikDto);
        return new ResponseEntity<>(korisnik,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> obrisiKorisnika(@PathVariable("id") int id){
        try{
            korisnikService.obrisiKorisnika(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (InvalidEntityException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
