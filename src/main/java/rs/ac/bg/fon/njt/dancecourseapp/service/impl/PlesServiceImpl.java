package rs.ac.bg.fon.njt.dancecourseapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.dancecourseapp.converter.PlesConverter;
import rs.ac.bg.fon.njt.dancecourseapp.dao.PlesRepository;
import rs.ac.bg.fon.njt.dancecourseapp.dto.PlesDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.model.PlesEntity;
import rs.ac.bg.fon.njt.dancecourseapp.service.PlesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlesServiceImpl implements PlesService {

    private final PlesRepository plesRepository;
    private final PlesConverter plesConverter;

    @Autowired
    public PlesServiceImpl(PlesRepository plesRepository, PlesConverter plesConverter) {
        this.plesRepository = plesRepository;
        this.plesConverter = plesConverter;
    }
    @Override
    public PlesDto dodajPles(PlesDto plesDto) {
        //save-ujemo i vracamo taj ples
        PlesEntity ples = plesConverter.toEntity(plesDto);
        //ostaviti prostor za razmisljanje da se po nazivu pretrazi ili ne
        List<PlesEntity> entity = plesRepository.findByName(ples.getNazivPlesa());
        if (!entity.isEmpty()) {
            throw new InvalidEntityException("ADD: Ples sa ovim nazivom vec postoji u bazi");
        }

        return plesConverter.toDto(plesRepository.save(ples));

    }

    @Override
    public List<PlesDto> nadjiSvePlesove() {
        List<PlesEntity> plesovi = plesRepository.findAll();
        return plesovi.stream().map(plesConverter::toDto).collect(Collectors.toList());
      /* II nacin
      *  List<PlesEntity> plesovi = plesRepository.findAll();
        return plesovi.stream().map(entity -> {
            return mapStructMapper.plesEntityToPlesDto(entity);
        }).collect(Collectors.toList());*/
    }


    @Override
    public PlesDto izmeniPles(PlesDto plesDto) {
        PlesEntity ples = plesConverter.toEntity(plesDto);
        List<PlesEntity> entity = plesRepository.findByName(ples.getNazivPlesa());
        if (!entity.isEmpty()) {
            throw new InvalidEntityException("UPDATE: Ples sa ovim nazivom vec postoji u bazi");
        }
        return plesConverter.toDto(plesRepository.save(ples));

    }



    @Override
    public void obrisiPles(int id) {

        Optional<PlesEntity> ples = plesRepository.findById(id);
        if(ples.isEmpty()){
            throw new InvalidEntityException("Ne postoji ples sa ovim id-jem u bazi");
        }
        plesRepository.deleteById(id);
    }

    @Override
    public Optional<PlesDto> findById(int id){
        Optional<PlesEntity> ples = plesRepository.findById(id);
        if(ples.isPresent()){
            return Optional.of(plesConverter.toDto(ples.get()));
        }
        return Optional.empty();
    }


}
