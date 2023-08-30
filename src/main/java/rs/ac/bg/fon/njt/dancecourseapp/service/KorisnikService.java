package rs.ac.bg.fon.njt.dancecourseapp.service;

import rs.ac.bg.fon.njt.dancecourseapp.dto.KorisnikDto;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {

    public KorisnikDto dodajKorisnika(KorisnikDto korisnikDto);

    public List<KorisnikDto> nadjiSveKorisnike();

    public KorisnikDto izmeniKorisnika(KorisnikDto korisnikDto);

    public void obrisiKorisnika(int id);

    Optional<KorisnikDto> findById(int id);

    public Optional<KorisnikDto> uloguj(KorisnikDto korisnikDto);
}
