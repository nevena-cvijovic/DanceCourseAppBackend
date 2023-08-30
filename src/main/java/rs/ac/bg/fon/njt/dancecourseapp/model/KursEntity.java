package rs.ac.bg.fon.njt.dancecourseapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "kurs")
public class KursEntity implements ApplicationEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKursa;
    private String nazivKursa;
    private int trajanjeUNedeljama;


    @ManyToOne
    @JoinColumn(name = "idPlesa")
    private PlesEntity ples;

    public KursEntity() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase KursEntity.");
        System.out.println("====================================================");

    }

    public KursEntity(int idKursa, String nazivKursa, int trajanjeUNedeljama, PlesEntity ples) {
        this.idKursa = idKursa;
        this.nazivKursa = nazivKursa;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.ples = ples;
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

    public PlesEntity getPles() {
        return ples;
    }

    public void setPles(PlesEntity ples) {
        this.ples = ples;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KursEntity that = (KursEntity) o;
        return trajanjeUNedeljama == that.trajanjeUNedeljama && Objects.equals(idKursa, that.idKursa) && Objects.equals(nazivKursa, that.nazivKursa) && Objects.equals(ples, that.ples);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKursa, nazivKursa, trajanjeUNedeljama, ples);
    }

    @Override
    public String toString() {
        return  nazivKursa ;
    }
}
