package rs.ac.bg.fon.njt.dancecourseapp.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "korisnik")
public class KorisnikEntity implements ApplicationEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKorisnika;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String kontaktTelefon;
    private String mejl;
    private String korisnickoIme;
    private String lozinka;

    public KorisnikEntity() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase KorisnikEntity.");
        System.out.println("====================================================");

    }
    public KorisnikEntity(int idKorisnika, String ime, String prezime, Date datumRodjenja, String kontaktTelefon, String mejl, String korisnickoIme, String lozinka) {
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.kontaktTelefon = kontaktTelefon;
        this.mejl = mejl;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getMejl() {
        return mejl;
    }

    public void setMejl(String mejl) {
        this.mejl = mejl;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KorisnikEntity that = (KorisnikEntity) o;
        return Objects.equals(idKorisnika, that.idKorisnika) && Objects.equals(ime, that.ime) && Objects.equals(prezime, that.prezime) && Objects.equals(datumRodjenja, that.datumRodjenja) && Objects.equals(kontaktTelefon, that.kontaktTelefon) && Objects.equals(mejl, that.mejl) && Objects.equals(korisnickoIme, that.korisnickoIme) && Objects.equals(lozinka, that.lozinka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnika, ime, prezime, datumRodjenja, kontaktTelefon, mejl, korisnickoIme, lozinka);
    }

    @Override
    public String toString() {
        return  ime + ' ' + prezime ;
    }
}
