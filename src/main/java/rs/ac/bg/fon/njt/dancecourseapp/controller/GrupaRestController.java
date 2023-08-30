package rs.ac.bg.fon.njt.dancecourseapp.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.dancecourseapp.dto.GrupaDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.service.impl.GrupaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/grupa")
public class GrupaRestController {


    private final GrupaServiceImpl grupaService;

    public GrupaRestController(GrupaServiceImpl grupaService) {
        this.grupaService = grupaService;
    }

    //metode

    //vrati sve

    @GetMapping("/all")
    public ResponseEntity<List<GrupaDto>> vratiSveGrupe(){
        List<GrupaDto> grupe = grupaService.nadjiSveGrupe();
        return new ResponseEntity<>(grupe, HttpStatus.OK);
    }

    //dodaj
    @PostMapping("/add")
    public ResponseEntity<Object> dodajGrupu(@Valid @RequestBody GrupaDto grupaDto){
        try{
            GrupaDto grupa = grupaService.dodajGrupu(grupaDto);
            return new ResponseEntity<>(grupa,HttpStatus.CREATED);
        }catch(InvalidEntityException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    //update-uj
    @PutMapping("/update")
    public ResponseEntity<Object> izmeniGrupu(@RequestBody GrupaDto grupaDto){
        GrupaDto grupa = grupaService.izmeniGrupu(grupaDto);
        return new ResponseEntity<>(grupa,HttpStatus.OK);
    }

    //brisanje
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> obrisiGrupu(@PathVariable("id") int id){
        try{
            grupaService.obrisiGrupu(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (InvalidEntityException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
