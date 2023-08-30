package rs.ac.bg.fon.njt.dancecourseapp.dto;

import jakarta.validation.constraints.NotNull;

public class RasporedKursaDto implements ApplicationDto{
    @NotNull(message = "Mora postojati grupa za raspored")
    private GrupaDto grupa;
    @NotNull(message = "Dan u nedelji mora biti unet")
    private String danUNedelji;
    @NotNull(message = "Broj casova mora biti unet")
    private int brojCasova;
    private String opisKursa;
    @NotNull(message = "Required field")
    private int brojSale;
    @NotNull(message = "Required field")
    private String vreme;

    public RasporedKursaDto() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase RasporedKursaDto.");
        System.out.println("====================================================");
    }

    public RasporedKursaDto(GrupaDto grupa, String danUNedelji, int brojCasova, String opisKursa, int brojSale, String vreme) {
        this.grupa = grupa;
        this.danUNedelji = danUNedelji;
        this.brojCasova = brojCasova;
        this.opisKursa = opisKursa;
        this.brojSale = brojSale;
        this.vreme = vreme;
    }

    public GrupaDto getGrupa() {
        return grupa;
    }

    public void setGrupa(GrupaDto grupa) {
        this.grupa = grupa;
    }

    public String getDanUNedelji() {
        return danUNedelji;
    }

    public void setDanUNedelji(String danUNedelji) {
        this.danUNedelji = danUNedelji;
    }

    public int getBrojCasova() {
        return brojCasova;
    }

    public void setBrojCasova(int brojCasova) {
        this.brojCasova = brojCasova;
    }

    public String getOpisKursa() {
        return opisKursa;
    }

    public void setOpisKursa(String opisKursa) {
        this.opisKursa = opisKursa;
    }

    public int getBrojSale() {
        return brojSale;
    }

    public void setBrojSale(int brojSale) {
        this.brojSale = brojSale;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }
}
