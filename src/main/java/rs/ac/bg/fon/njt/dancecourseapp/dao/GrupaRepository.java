package rs.ac.bg.fon.njt.dancecourseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.ac.bg.fon.njt.dancecourseapp.model.GrupaEntity;

import java.util.List;

public interface GrupaRepository extends JpaRepository<GrupaEntity, Integer> {
    @Query("SELECT g FROM GrupaEntity g WHERE g.nazivGrupe = ?1")
    List<GrupaEntity> findByName(String name);

    @Query("SELECT coalesce(max(idGrupe),0) FROM GrupaEntity ")
    int vratiMaksIndeks();
}
