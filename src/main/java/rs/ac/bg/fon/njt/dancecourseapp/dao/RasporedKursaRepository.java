package rs.ac.bg.fon.njt.dancecourseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.bg.fon.njt.dancecourseapp.model.RasporedKursaEntity;
import rs.ac.bg.fon.njt.dancecourseapp.model.RasporedKursaId;

public interface RasporedKursaRepository extends JpaRepository<RasporedKursaEntity, RasporedKursaId> {
}
