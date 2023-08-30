package rs.ac.bg.fon.njt.dancecourseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.bg.fon.njt.dancecourseapp.model.PrijavaEntity;
import rs.ac.bg.fon.njt.dancecourseapp.model.PrijavaId;

public interface PrijavaRepository extends JpaRepository<PrijavaEntity, PrijavaId> {
}
