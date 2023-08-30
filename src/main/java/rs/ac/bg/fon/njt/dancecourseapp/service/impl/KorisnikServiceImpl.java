package rs.ac.bg.fon.njt.dancecourseapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.dancecourseapp.converter.KorisnikConverter;
import rs.ac.bg.fon.njt.dancecourseapp.dao.KorisnikRepository;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KorisnikDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.model.KorisnikEntity;
import rs.ac.bg.fon.njt.dancecourseapp.service.KorisnikService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;
    private final KorisnikConverter korisnikConverter;

    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository, KorisnikConverter korisnikConverter) {
        this.korisnikRepository = korisnikRepository;
        this.korisnikConverter = korisnikConverter;
    }

    @Override
    public KorisnikDto dodajKorisnika(KorisnikDto korisnikDto) {

        KorisnikEntity korisnik = korisnikConverter.toEntity(korisnikDto);
        List<KorisnikEntity> korisnici = korisnikRepository.nadjiPoKorisnickomImenuIMejlu(korisnik.getKorisnickoIme(), korisnik.getMejl());
        if(!korisnici.isEmpty()){
            throw new InvalidEntityException("REGISTRACIJA: Ovaj korisnik vec postoji u sistemu");
        }

        return korisnikConverter.toDto(korisnikRepository.save(korisnik));
    }

    @Override
    public List<KorisnikDto> nadjiSveKorisnike() {
        List<KorisnikEntity> korisnici = korisnikRepository.findAll();
        return korisnici.stream().map(korisnikConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public KorisnikDto izmeniKorisnika(KorisnikDto korisnikDto) {
        KorisnikEntity korisnik = korisnikConverter.toEntity(korisnikDto);
        return korisnikConverter.toDto(korisnikRepository.save(korisnik));
    }

    @Override
    public void obrisiKorisnika(int id) {

        Optional<KorisnikEntity> korisnik = korisnikRepository.findById(id);
        if(!korisnik.isEmpty()){
            throw new InvalidEntityException("Ne postoji korisnik u bazi sa ovim id-jem");
        }
        korisnikRepository.deleteById(id);
    }

    @Override
    public Optional<KorisnikDto> findById(int id) {

        Optional<KorisnikEntity> korisnik = korisnikRepository.findById(id);
        if(korisnik.isPresent()){
            return Optional.of(korisnikConverter.toDto(korisnik.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<KorisnikDto> uloguj(KorisnikDto korisnikDto) {
        Optional<KorisnikEntity> korisnik = korisnikRepository.uloguj(korisnikDto.getKorisnickoIme(),korisnikDto.getLozinka());
        if(korisnik.isPresent()){

            return Optional.of(korisnikConverter.toDto(korisnik.get()));
        }
        return Optional.empty();
    }
}
