package rs.ac.bg.fon.njt.dancecourseapp.service;

import rs.ac.bg.fon.njt.dancecourseapp.dto.KursDto;

import java.util.List;
import java.util.Optional;

public interface KursService {

    public KursDto dodajKurs(KursDto kursDto);
    public List<KursDto> nadjiSveKurseve();

    public KursDto izmeniKurs(KursDto kursDto);

    public void obrisiKurs(int id);

    Optional<KursDto> findById(int id);
}
