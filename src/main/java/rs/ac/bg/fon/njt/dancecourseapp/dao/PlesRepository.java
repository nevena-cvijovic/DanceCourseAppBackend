package rs.ac.bg.fon.njt.dancecourseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.ac.bg.fon.njt.dancecourseapp.model.PlesEntity;

import java.util.List;

public interface PlesRepository extends JpaRepository<PlesEntity, Integer> {
    @Query("SELECT p FROM PlesEntity p WHERE p.nazivPlesa = ?1")
    List<PlesEntity> findByName(String name);
}
