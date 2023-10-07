package rs.ac.bg.fon.njt.dancecourseapp.service;

import rs.ac.bg.fon.njt.dancecourseapp.dto.CredentialsDto;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KorisnikDto;
import rs.ac.bg.fon.njt.dancecourseapp.dto.SignUpDto;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {

//    public KorisnikDto dodajKorisnika(KorisnikDto korisnikDto);
//
//    public List<KorisnikDto> nadjiSveKorisnike();
//
//    public KorisnikDto izmeniKorisnika(KorisnikDto korisnikDto);
//
//    public void obrisiKorisnika(int id);
//
//    Optional<KorisnikDto> findById(int id);
//


    KorisnikDto login(CredentialsDto credentialsDto);

    KorisnikDto register(SignUpDto user);

    KorisnikDto findByKorisnickoIme(String username);
}
