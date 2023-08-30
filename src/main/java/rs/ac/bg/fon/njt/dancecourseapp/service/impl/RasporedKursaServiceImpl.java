package rs.ac.bg.fon.njt.dancecourseapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.dancecourseapp.converter.RasporedKursaConverter;
import rs.ac.bg.fon.njt.dancecourseapp.dao.RasporedKursaRepository;
import rs.ac.bg.fon.njt.dancecourseapp.dto.RasporedKursaDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.model.RasporedKursaEntity;
import rs.ac.bg.fon.njt.dancecourseapp.model.RasporedKursaId;
import rs.ac.bg.fon.njt.dancecourseapp.service.RasporedKursaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RasporedKursaServiceImpl implements RasporedKursaService {

    private final RasporedKursaRepository rasporedKursaRepository;
    private final RasporedKursaConverter rasporedKursaConverter;


    @Autowired
    public RasporedKursaServiceImpl(RasporedKursaRepository rasporedKursaRepository, RasporedKursaConverter rasporedKursaConverter) {
        this.rasporedKursaRepository = rasporedKursaRepository;
        this.rasporedKursaConverter = rasporedKursaConverter;

    }

    @Override
    public RasporedKursaDto dodajRaspored(RasporedKursaDto rasporedKursaDto) {


        RasporedKursaEntity raspored = rasporedKursaConverter.toEntity(rasporedKursaDto);



        return rasporedKursaConverter.toDto(rasporedKursaRepository.save(raspored));


    }

    @Override
    public List<RasporedKursaDto> nadjiSveRasporede() {
        List<RasporedKursaEntity> rasporedi = rasporedKursaRepository.findAll();
        return rasporedi.stream().map(rasporedKursaConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public RasporedKursaDto izmeniRaspored(RasporedKursaDto rasporedKursaDto) {
        RasporedKursaEntity raspored = rasporedKursaConverter.toEntity(rasporedKursaDto);
        return rasporedKursaConverter.toDto(rasporedKursaRepository.save(raspored));
    }

    @Override
    public void obrisiRaspored(RasporedKursaId id) {
        Optional<RasporedKursaEntity> raspored = rasporedKursaRepository.findById(id);
        if(!raspored.isPresent()){
            throw new InvalidEntityException("Ne postoji raspored sa ovim id-jem u bazi");

        }
        rasporedKursaRepository.deleteById(id);

    }

    @Override
    public Optional<RasporedKursaDto> findById(RasporedKursaId id) {
        Optional<RasporedKursaEntity> raspored = rasporedKursaRepository.findById(id);
        if(raspored.isPresent()){
            return Optional.of(rasporedKursaConverter.toDto(raspored.get()));
        }

        return Optional.empty();
    }

}
