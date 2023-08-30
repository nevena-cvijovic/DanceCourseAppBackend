package rs.ac.bg.fon.njt.dancecourseapp.service;

import rs.ac.bg.fon.njt.dancecourseapp.dto.RasporedKursaDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.RasporedKursaId;

import java.util.List;
import java.util.Optional;

public interface RasporedKursaService {
    public RasporedKursaDto dodajRaspored(RasporedKursaDto rasporedKursaDto);

    public List<RasporedKursaDto> nadjiSveRasporede();

    public RasporedKursaDto izmeniRaspored(RasporedKursaDto rasporedKursaDto);

    public void obrisiRaspored(RasporedKursaId id);

    Optional<RasporedKursaDto> findById(RasporedKursaId id);
}
