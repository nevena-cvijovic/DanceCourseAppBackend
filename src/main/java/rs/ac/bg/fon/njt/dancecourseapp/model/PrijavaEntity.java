package rs.ac.bg.fon.njt.dancecourseapp.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(PrijavaId.class)
@Table(name = "prijava")
public class PrijavaEntity implements ApplicationEntity{

    @Id
    @ManyToOne
    @JoinColumn(name = "idKorisnika")
    private KorisnikEntity korisnik;

    @Id
    @ManyToOne
    @JoinColumn(name = "idKursa")
    private KursEntity kurs;

    private Date datumPrijave;
    private String napomena;

    @ManyToOne
    @JoinColumn(name = "idGrupe")
    private GrupaEntity grupa;

    public PrijavaEntity() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase PrijavaEntity.");
        System.out.println("====================================================");
    }

    public PrijavaEntity(KorisnikEntity korisnik, KursEntity kurs, Date datumPrijave, String napomena, GrupaEntity grupa) {
        this.korisnik = korisnik;
        this.kurs = kurs;
        this.datumPrijave = datumPrijave;
        this.napomena = napomena;
        this.grupa = grupa;
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

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public GrupaEntity getGrupa() {
        return grupa;
    }

    public void setGrupa(GrupaEntity grupa) {
        this.grupa = grupa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrijavaEntity that = (PrijavaEntity) o;
        return Objects.equals(korisnik, that.korisnik) && Objects.equals(kurs, that.kurs) && Objects.equals(datumPrijave, that.datumPrijave) && Objects.equals(napomena, that.napomena) && Objects.equals(grupa, that.grupa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnik, kurs, datumPrijave, napomena, grupa);
    }

}
