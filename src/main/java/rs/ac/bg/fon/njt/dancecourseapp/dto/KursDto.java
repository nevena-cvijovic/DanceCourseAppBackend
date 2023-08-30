package rs.ac.bg.fon.njt.dancecourseapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class KursDto implements ApplicationDto{


    private int idKursa;

    @Size(min = 2, max = 50, message = "Name must contain 2-50 letters!")
    @NotNull(message = "Required field")
    private String nazivKursa;

    @NotNull(message = "Required field")
    private int trajanjeUNedeljama;


    private PlesDto ples;

    public KursDto(int idKursa, String nazivKursa, int trajanjeUNedeljama, PlesDto ples) {
        this.idKursa = idKursa;
        this.nazivKursa = nazivKursa;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.ples = ples;
    }

    public KursDto() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase KursDto.");
        System.out.println("====================================================");
    }

    public int getIdKursa() {
        return idKursa;
    }

    public void setIdKursa(int idKursa) {
        this.idKursa = idKursa;
    }

    public String getNazivKursa() {
        return nazivKursa;
    }

    public void setNazivKursa(String nazivKursa) {
        this.nazivKursa = nazivKursa;
    }

    public int getTrajanjeUNedeljama() {
        return trajanjeUNedeljama;
    }

    public void setTrajanjeUNedeljama(int trajanjeUNedeljama) {
        this.trajanjeUNedeljama = trajanjeUNedeljama;
    }

    public PlesDto getPles() {
        return ples;
    }

    public void setPles(PlesDto ples) {
        this.ples = ples;
    }
}
