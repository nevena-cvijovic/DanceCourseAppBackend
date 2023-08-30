package rs.ac.bg.fon.njt.dancecourseapp.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "grupa")
public class GrupaEntity implements ApplicationEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGrupe;
    private String nazivGrupe;
    private Date datumPocetkaKursa;

    @ManyToOne
    @JoinColumn(name = "idKursa")
    private KursEntity kurs;


    @OneToMany(mappedBy = "grupa", cascade = CascadeType.ALL)
    private List<RasporedKursaEntity> rasporediKurseva;
    public GrupaEntity() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase GrupaEntity.");
        System.out.println("====================================================");
    }

    public GrupaEntity(int idGrupe, String nazivGrupe, Date datumPocetkaKursa, KursEntity kurs, List<RasporedKursaEntity> rasporediKurseva) {
        this.idGrupe = idGrupe;
        this.nazivGrupe = nazivGrupe;
        this.datumPocetkaKursa = datumPocetkaKursa;
        this.kurs = kurs;
        this.rasporediKurseva = rasporediKurseva;
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

    public KursEntity getKurs() {
        return kurs;
    }

    public void setKurs(KursEntity kurs) {
        this.kurs = kurs;
    }

    public List<RasporedKursaEntity> getRasporediKurseva() {
        return rasporediKurseva;
    }

    public void setRasporediKurseva(List<RasporedKursaEntity> rasporediKurseva) {
        this.rasporediKurseva = rasporediKurseva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupaEntity that = (GrupaEntity) o;
        return idGrupe == that.idGrupe && Objects.equals(nazivGrupe, that.nazivGrupe) && Objects.equals(datumPocetkaKursa, that.datumPocetkaKursa) && Objects.equals(kurs, that.kurs) && Objects.equals(rasporediKurseva, that.rasporediKurseva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGrupe, nazivGrupe, datumPocetkaKursa, kurs, rasporediKurseva);
    }

    @Override
    public String toString() {
        return "GrupaEntity{" +
                "idGrupe=" + idGrupe +
                ", nazivGrupe='" + nazivGrupe + '\'' +
                ", kurs=" + kurs +
                '}';
    }

}
