package rs.ac.bg.fon.njt.dancecourseapp.service;

import rs.ac.bg.fon.njt.dancecourseapp.dto.PlesDto;

import java.util.List;
import java.util.Optional;

public interface PlesService {
    public PlesDto dodajPles(PlesDto plesDto);
    public List<PlesDto> nadjiSvePlesove();

    public PlesDto izmeniPles(PlesDto plesDto);

    public void obrisiPles(int id);

    Optional<PlesDto> findById(int id);
}
