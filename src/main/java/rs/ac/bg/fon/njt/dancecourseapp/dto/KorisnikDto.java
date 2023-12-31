package rs.ac.bg.fon.njt.dancecourseapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

public class KorisnikDto implements ApplicationDto{


    private int idKorisnika;


    private String ime;


    private String prezime;


    private Date datumRodjenja;


    private String kontaktTelefon;

    @Email

    private String mejl;


    private String korisnickoIme;



    private String token;

    public KorisnikDto() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase KorisnikDto.");
        System.out.println("====================================================");
    }

    public KorisnikDto(int idKorisnika, String ime, String prezime, Date datumRodjenja, String kontaktTelefon, String mejl, String korisnickoIme, String token) {
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.kontaktTelefon = kontaktTelefon;
        this.mejl = mejl;
        this.korisnickoIme = korisnickoIme;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
