package rs.ac.bg.fon.njt.dancecourseapp.service;

import rs.ac.bg.fon.njt.dancecourseapp.dto.GrupaDto;

import java.util.List;
import java.util.Optional;

public interface GrupaService {

    public GrupaDto dodajGrupu(GrupaDto grupaDto);

    public List<GrupaDto> nadjiSveGrupe();

    public GrupaDto izmeniGrupu(GrupaDto grupaDto);

    public void obrisiGrupu(int id);

    Optional<GrupaDto> findById(int id);

    int vratiMaksId();
}
