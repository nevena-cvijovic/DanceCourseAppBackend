package rs.ac.bg.fon.njt.dancecourseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.ac.bg.fon.njt.dancecourseapp.model.KorisnikEntity;

import java.util.List;
import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<KorisnikEntity, Integer> {


    @Query("SELECT k FROM KorisnikEntity k WHERE k.korisnickoIme = ?1 AND k.mejl = ?2")
    List<KorisnikEntity> nadjiPoKorisnickomImenuIMejlu(String username, String email);


    Optional<KorisnikEntity> findByKorisnickoIme(String login);

}
