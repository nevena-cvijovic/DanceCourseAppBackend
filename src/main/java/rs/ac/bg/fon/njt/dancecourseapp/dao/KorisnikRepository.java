package rs.ac.bg.fon.njt.dancecourseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.ac.bg.fon.njt.dancecourseapp.model.KorisnikEntity;

import java.util.List;
import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<KorisnikEntity, Integer> {

    //ovde nam treba da vrati po korisnickom imenu i mejlu
    //za registraciju
    @Query("SELECT k FROM KorisnikEntity k WHERE k.korisnickoIme = ?1 AND k.mejl = ?2")
    List<KorisnikEntity> nadjiPoKorisnickomImenuIMejlu(String username, String email);


    //za logovanje
    @Query("SELECT kor FROM KorisnikEntity kor WHERE kor.korisnickoIme= ?1 AND kor.lozinka=?2")
    Optional< KorisnikEntity> uloguj(String username, String password);

}
