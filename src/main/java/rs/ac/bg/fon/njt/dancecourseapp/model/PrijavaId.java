package rs.ac.bg.fon.njt.dancecourseapp.model;

import java.io.Serializable;
import java.util.Objects;

public class PrijavaId implements Serializable {

    private KorisnikEntity korisnik;
    private KursEntity kurs;

    public PrijavaId() {
    }

    public PrijavaId(KorisnikEntity korisnik, KursEntity kurs) {
        this.korisnik = korisnik;
        this.kurs = kurs;
    }

    public KorisnikEntity getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(KorisnikEntity korisnik) {
        this.korisnik = korisnik;
    }

    public KursEntity getKurs() {
        return kurs;
    }

    public void setKurs(KursEntity kurs) {
        this.kurs = kurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrijavaId prijavaId = (PrijavaId) o;
        return Objects.equals(korisnik, prijavaId.korisnik) && Objects.equals(kurs, prijavaId.kurs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnik, kurs);
    }
}

