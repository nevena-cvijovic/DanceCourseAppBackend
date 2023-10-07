package rs.ac.bg.fon.njt.dancecourseapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.dancecourseapp.converter.MapStruct;
import rs.ac.bg.fon.njt.dancecourseapp.dao.KorisnikRepository;
import rs.ac.bg.fon.njt.dancecourseapp.dto.CredentialsDto;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KorisnikDto;
import rs.ac.bg.fon.njt.dancecourseapp.dto.SignUpDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.AppException;
import rs.ac.bg.fon.njt.dancecourseapp.exception.InvalidEntityException;
import rs.ac.bg.fon.njt.dancecourseapp.model.KorisnikEntity;
import rs.ac.bg.fon.njt.dancecourseapp.service.KorisnikService;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;


    private final MapStruct mapper;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository, PasswordEncoder passwordEncoder, MapStruct mapper) {
        this.korisnikRepository = korisnikRepository;

        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

//    @Override
//    public KorisnikDto dodajKorisnika(KorisnikDto korisnikDto) {
//
//        KorisnikEntity korisnik = korisnikConverter.toEntity(korisnikDto);
//        List<KorisnikEntity> korisnici = korisnikRepository.nadjiPoKorisnickomImenuIMejlu(korisnik.getKorisnickoIme(), korisnik.getMejl());
//        if(!korisnici.isEmpty()){
//            throw new InvalidEntityException("REGISTRACIJA: Ovaj korisnik vec postoji u sistemu");
//        }
//
//        return korisnikConverter.toDto(korisnikRepository.save(korisnik));
//    }
//
//    @Override
//    public List<KorisnikDto> nadjiSveKorisnike() {
//        List<KorisnikEntity> korisnici = korisnikRepository.findAll();
//        return korisnici.stream().map(mapper::toKorisnikDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public KorisnikDto izmeniKorisnika(KorisnikDto korisnikDto) {
//        KorisnikEntity korisnik = korisnikConverter.toEntity(korisnikDto);
//        return korisnikConverter.toDto(korisnikRepository.save(korisnik));
//    }
//
//    @Override
//    public void obrisiKorisnika(int id) {
//
//        Optional<KorisnikEntity> korisnik = korisnikRepository.findById(id);
//        if(!korisnik.isEmpty()){
//            throw new InvalidEntityException("Ne postoji korisnik u bazi sa ovim id-jem");
//        }
//        korisnikRepository.deleteById(id);
//    }
//
//    @Override
//    public Optional<KorisnikDto> findById(int id) {
//
//        Optional<KorisnikEntity> korisnik = korisnikRepository.findById(id);
//        if(korisnik.isPresent()){
//            return Optional.of(korisnikConverter.toDto(korisnik.get()));
//        }
//        return Optional.empty();
//    }

    @Override
    public KorisnikDto login(CredentialsDto credentialsDto) {
      KorisnikEntity korisnik =   korisnikRepository.findByKorisnickoIme(credentialsDto.korisnickoIme())
                .orElseThrow(()-> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.lozinka()),korisnik.getLozinka())){
            return mapper.toKorisnikDto(korisnik);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    @Override
    public KorisnikDto register(SignUpDto user) {
        Optional<KorisnikEntity> korisnikEntity = korisnikRepository.findByKorisnickoIme(user.korisnickoIme());

        if(korisnikEntity.isPresent()){
            throw new AppException("Korisnik sa ovim korisnickimImenom vec postoji u bazi", HttpStatus.BAD_REQUEST);
        }



        KorisnikEntity korisnik = mapper.signUpToUser(user);
        korisnik.setLozinka(passwordEncoder.encode(CharBuffer.wrap(user.lozinka())));
        KorisnikEntity sacuvanKorisnik = korisnikRepository.save(korisnik);

        return mapper.toKorisnikDto(sacuvanKorisnik);
    }

    @Override
    public KorisnikDto findByKorisnickoIme(String username) {
        KorisnikEntity user = korisnikRepository.findByKorisnickoIme(username)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return mapper.toKorisnikDto(user);
    }


}
