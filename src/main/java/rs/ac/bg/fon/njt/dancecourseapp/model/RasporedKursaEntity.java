package rs.ac.bg.fon.njt.dancecourseapp.model;


import jakarta.persistence.*;

@Entity
@IdClass(RasporedKursaId.class)
@Table(name = "rasporedKursa")
public class RasporedKursaEntity implements ApplicationEntity{

    @Id
    @ManyToOne
    @JoinColumn(name = "idGrupe")
    private GrupaEntity grupa;

    @Id
    private String danUNedelji;
    private int brojCasova;
    private String opisKursa;
    private int brojSale;
    private String vreme;

    public RasporedKursaEntity() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase RasporedKursaEntity.");
        System.out.println("====================================================");
    }

    public RasporedKursaEntity(GrupaEntity grupa, String danUNedelji, int brojCasova, String opisKursa, int brojSale, String vreme) {
        this.grupa = grupa;
        this.danUNedelji = danUNedelji;
        this.brojCasova = brojCasova;
        this.opisKursa = opisKursa;
        this.brojSale = brojSale;
        this.vreme = vreme;
    }

    public GrupaEntity getGrupa() {
        return grupa;
    }

    public void setGrupa(GrupaEntity grupa) {
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
