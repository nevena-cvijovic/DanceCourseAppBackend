package rs.ac.bg.fon.njt.dancecourseapp.dto;

import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class PrijavaDto implements ApplicationDto{

    @NotNull
    private KorisnikDto korisnik;
    @NotNull
    private KursDto kurs;
    private Date datumPrijave;
    private String napomena;

    private GrupaDto grupa;

    public PrijavaDto() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase PrijavaDto.");
        System.out.println("====================================================");
    }

    public PrijavaDto(KorisnikDto korisnik, KursDto kurs, Date datumPrijave, String napomena, GrupaDto grupa) {
        this.korisnik = korisnik;
        this.kurs = kurs;
        this.datumPrijave = datumPrijave;
        this.napomena = napomena;
        this.grupa = grupa;
    }

    public KorisnikDto getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(KorisnikDto korisnik) {
        this.korisnik = korisnik;
    }

    public KursDto getKurs() {
        return kurs;
    }

    public void setKurs(KursDto kurs) {
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

    public GrupaDto getGrupa() {
        return grupa;
    }

    public void setGrupa(GrupaDto grupa) {
        this.grupa = grupa;
    }

}
