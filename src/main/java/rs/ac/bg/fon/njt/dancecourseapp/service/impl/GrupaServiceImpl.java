package rs.ac.bg.fon.njt.dancecourseapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.dancecourseapp.converter.GrupaConverter;
import rs.ac.bg.fon.njt.dancecourseapp.dao.GrupaRepository;
import rs.ac.bg.fon.njt.dancecourseapp.dto.GrupaDto;
import rs.ac.bg.fon.njt.dancecourseapp.dto.RasporedKursaDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.model.GrupaEntity;
import rs.ac.bg.fon.njt.dancecourseapp.model.RasporedKursaEntity;
import rs.ac.bg.fon.njt.dancecourseapp.service.GrupaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GrupaServiceImpl implements GrupaService {


    private final GrupaRepository grupaRepository;
    private final GrupaConverter grupaConverter;

    private final RasporedKursaServiceImpl rasporedKursaService;

    @Autowired
    public GrupaServiceImpl(GrupaRepository grupaRepository, GrupaConverter grupaConverter, RasporedKursaServiceImpl rasporedKursaService) {
        this.grupaRepository = grupaRepository;
        this.grupaConverter = grupaConverter;
        this.rasporedKursaService = rasporedKursaService;
    }

    @Override
    public GrupaDto dodajGrupu(GrupaDto grupaDto) {
        GrupaEntity grupa = grupaConverter.toEntity(grupaDto);
        List<GrupaEntity> entities = grupaRepository.findByName(grupa.getNazivGrupe());
        if(!entities.isEmpty()){
            throw new InvalidEntityException("ADD: Grupa sa ovim nazivom vec postoji u bazi");
        }
        GrupaDto entity = grupaConverter.toDto(grupaRepository.save(grupa));
        List<RasporedKursaEntity> rasporedi = grupa.getRasporediKurseva();
        if(rasporedi==null){
            System.out.println("rasporeda nema u grupi entity");
        }
        //ovde moras da dodas za dodavanje rasporeda kurseva njen service koji ce da dodaje rasporede u bazu

        for (RasporedKursaDto rs: grupaDto.getRasporediKurseva()
        ) {
            rs.setGrupa(entity);
            rasporedKursaService.dodajRaspored(rs);
        }
        return entity;
    }

    @Override
    public List<GrupaDto> nadjiSveGrupe() {
        List<GrupaEntity> grupe = grupaRepository.findAll();
        return grupe.stream().map(grupaConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public GrupaDto izmeniGrupu(GrupaDto grupaDto) {
        GrupaEntity grupa = grupaConverter.toEntity(grupaDto);
        return grupaConverter.toDto(grupaRepository.save(grupa));
    }

    @Override
    public void obrisiGrupu(int id) {

        Optional<GrupaEntity> grupa = grupaRepository.findById(id);
        if(grupa.isEmpty()){
            throw new InvalidEntityException("Ne postoji grupa sa ovim id-jem u bazi");
        }
        grupaRepository.deleteById(id);
    }

    @Override
    public Optional<GrupaDto> findById(int id) {
        Optional<GrupaEntity> grupa = grupaRepository.findById(id);
        if(grupa.isPresent()){
            return Optional.of(grupaConverter.toDto(grupa.get()));
        }

        return Optional.empty();
    }

    @Override
    public int vratiMaksId() {
        int max = 0;
        try{
            max = grupaRepository.vratiMaksIndeks();
        }catch (Exception e){

            e.printStackTrace();
        }
        return max+1;
    }
}
