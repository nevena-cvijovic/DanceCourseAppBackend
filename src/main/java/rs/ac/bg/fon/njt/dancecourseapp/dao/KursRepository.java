package rs.ac.bg.fon.njt.dancecourseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.ac.bg.fon.njt.dancecourseapp.model.KursEntity;

import java.util.List;

public interface KursRepository extends JpaRepository<KursEntity,Integer> {

    @Query("SELECT k FROM KursEntity  k WHERE k.nazivKursa = ?1")
    List<KursEntity> findByName(String name);
}
