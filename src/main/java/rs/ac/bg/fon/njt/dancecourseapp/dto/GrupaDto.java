package rs.ac.bg.fon.njt.dancecourseapp.dto;

import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.util.List;

public class GrupaDto implements ApplicationDto{


    private int idGrupe;

    @NotNull(message = "Required field")
    private String nazivGrupe;

    @NotNull(message = "Required field")
    private Date datumPocetkaKursa;


    @NotNull(message = "Required field")
    private KursDto kurs;

    @NotNull(message = "Mora postojati bar jedan raspored za grupu")
    private List<RasporedKursaDto> rasporediKurseva;
    public GrupaDto() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase GrupaDto.");
        System.out.println("====================================================");

    }

    public GrupaDto(int idGrupe, String nazivGrupe, Date datumPocetkaKursa, KursDto kurs) {
        this.idGrupe = idGrupe;
        this.nazivGrupe = nazivGrupe;
        this.datumPocetkaKursa = datumPocetkaKursa;
        this.kurs = kurs;
    }

    public int getIdGrupe() {
        return idGrupe;
    }

    public void setIdGrupe(int idGrupe) {
        this.idGrupe = idGrupe;
    }

    public String getNazivGrupe() {
        return nazivGrupe;
    }

    public void setNazivGrupe(String nazivGrupe) {
        this.nazivGrupe = nazivGrupe;
    }

    public Date getDatumPocetkaKursa() {
        return datumPocetkaKursa;
    }

    public void setDatumPocetkaKursa(Date datumPocetkaKursa) {
        this.datumPocetkaKursa = datumPocetkaKursa;
    }

    public KursDto getKurs() {
        return kurs;
    }

    public void setKurs(KursDto kurs) {
        this.kurs = kurs;
    }

    public List<RasporedKursaDto> getRasporediKurseva() {
        return rasporediKurseva;
    }

    public void setRasporediKurseva(List<RasporedKursaDto> rasporediKurseva) {
        this.rasporediKurseva = rasporediKurseva;
    }
}
