package rs.ac.bg.fon.njt.dancecourseapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.dancecourseapp.converter.PrijavaConverter;
import rs.ac.bg.fon.njt.dancecourseapp.dao.PrijavaRepository;
import rs.ac.bg.fon.njt.dancecourseapp.dto.PrijavaDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.PrijavaEntity;
import rs.ac.bg.fon.njt.dancecourseapp.model.PrijavaId;
import rs.ac.bg.fon.njt.dancecourseapp.service.PrijavaService;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrijavaServiceImpl implements PrijavaService {

    private final PrijavaRepository prijavaRepository;
    private final PrijavaConverter prijavaConverter;

    @Autowired
    public PrijavaServiceImpl(PrijavaRepository prijavaRepository, PrijavaConverter prijavaConverter) {
        this.prijavaRepository = prijavaRepository;
        this.prijavaConverter = prijavaConverter;
    }


    //CRUD
    @Override
    public PrijavaDto dodajPrijavu(PrijavaDto prijavaDto) {
        PrijavaEntity prijava = prijavaConverter.toEntity(prijavaDto);
        return prijavaConverter.toDto(prijavaRepository.save(prijava));
    }

    @Override
    public List<PrijavaDto> nadjiSvePrijave() {
        List<PrijavaEntity> prijave = prijavaRepository.findAll();
        return prijave.stream().map(prijavaConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public PrijavaDto izmeniPrijavu(PrijavaDto prijavaDto) {
        PrijavaEntity prijava = prijavaConverter.toEntity(prijavaDto);
        return prijavaConverter.toDto(prijavaRepository.save(prijava));
    }

    @Override
    public void obrisiPrijavu(PrijavaId id) {

        Optional<PrijavaEntity> prijava = prijavaRepository.findById(id);
        if(!prijava.isPresent()){
            throw new InvalidEntityException("Ne postoji prijava sa ovim id-jem u bazi");

        }
        prijavaRepository.deleteById(id);

    }

    @Override
    public Optional<PrijavaDto> findById(PrijavaId id) {
        Optional<PrijavaEntity> prijava = prijavaRepository.findById(id);
        if(prijava.isPresent()){
            return Optional.of(prijavaConverter.toDto(prijava.get()));
        }
        return Optional.empty();
    }

}
