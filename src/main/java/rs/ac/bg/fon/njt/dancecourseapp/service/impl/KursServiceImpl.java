package rs.ac.bg.fon.njt.dancecourseapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.dancecourseapp.converter.KursConverter;
import rs.ac.bg.fon.njt.dancecourseapp.dao.KursRepository;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KursDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.model.KursEntity;
import rs.ac.bg.fon.njt.dancecourseapp.service.KursService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KursServiceImpl implements KursService {

    //inject-ujemo sad Kurs Repozitorijum
    private final KursRepository kursRepository;
    private final KursConverter kursConverter;

    @Autowired
    public KursServiceImpl(KursRepository kursRepository, KursConverter kursConverter) {
        this.kursRepository = kursRepository;
        this.kursConverter = kursConverter;
    }

    //CRUD
    @Override
    public KursDto dodajKurs(KursDto kursDto) {
        KursEntity kurs = kursConverter.toEntity(kursDto);
        List<KursEntity> entities = kursRepository.findByName(kurs.getNazivKursa());
        if(!entities.isEmpty()){
            throw new InvalidEntityException("ADD: Kurs sa ovim nazivom vec postoji u bazi");
        }
        return kursConverter.toDto(kursRepository.save(kurs));
    }

    @Override
    public List<KursDto> nadjiSveKurseve() {
        List<KursEntity> kursevi = kursRepository.findAll();
        return kursevi.stream().map(kursConverter::toDto).collect(Collectors.toList());

    }

    @Override
    public KursDto izmeniKurs(KursDto kursDto) {
        KursEntity kurs = kursConverter.toEntity(kursDto);

        return kursConverter.toDto(kursRepository.save(kurs));
    }

    @Override
    public void obrisiKurs(int id) {

        Optional<KursEntity> kurs = kursRepository.findById(id);
        if(!kurs.isPresent()){
            throw new InvalidEntityException("Ne postoji kurs sa ovim id-jem u bazi");
        }
        kursRepository.deleteById(id);
    }

    @Override
    public Optional<KursDto> findById(int id){
        Optional<KursEntity> kurs = kursRepository.findById(id);
        if(kurs.isPresent()){
            return Optional.of(kursConverter.toDto(kurs.get()));
        }
        return Optional.empty();
    }




}
