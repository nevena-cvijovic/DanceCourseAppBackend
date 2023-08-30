package rs.ac.bg.fon.njt.dancecourseapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class PlesDto implements ApplicationDto{


    @JsonProperty("idPlesa")
    private int idPlesa;

    @JsonProperty("nazivPlesa")
    @NotNull(message = "Naziv plesa obavezno polje")
    private String nazivPlesa;

    public PlesDto() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase PlesDto.");
        System.out.println("====================================================");
    }

    public PlesDto(int idPlesa, String nazivPlesa) {

        this.idPlesa = idPlesa;
        this.nazivPlesa = nazivPlesa;
    }

    public int getIdPlesa() {
        return idPlesa;
    }

    public void setIdPlesa(int idPlesa) {
        this.idPlesa = idPlesa;
    }



    public String getNazivPlesa() {
        return nazivPlesa;
    }

    public void setNazivPlesa(String nazivPlesa) {
        this.nazivPlesa = nazivPlesa;
    }
}