package rs.ac.bg.fon.njt.dancecourseapp.service;

import rs.ac.bg.fon.njt.dancecourseapp.dto.PrijavaDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.PrijavaId;

import java.util.List;
import java.util.Optional;

public interface PrijavaService {
    public PrijavaDto dodajPrijavu(PrijavaDto prijavaDto);

    public List<PrijavaDto> nadjiSvePrijave();

    public PrijavaDto izmeniPrijavu(PrijavaDto prijavaDto);

    public void obrisiPrijavu(PrijavaId id);

    Optional<PrijavaDto> findById(PrijavaId id);
}
