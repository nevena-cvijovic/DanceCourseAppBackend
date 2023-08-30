package rs.ac.bg.fon.njt.dancecourseapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ples")
public class PlesEntity implements ApplicationEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlesa;
    private String nazivPlesa;

    public PlesEntity() {
        System.out.println("====================================================");
        System.out.println("Kreiran je objekat klase PlesEntity.");
        System.out.println("====================================================");
    }

    public PlesEntity(int idPlesa, String nazivPlesa) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlesEntity that = (PlesEntity) o;
        return Objects.equals(idPlesa, that.idPlesa) && Objects.equals(nazivPlesa, that.nazivPlesa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlesa, nazivPlesa);
    }

    @Override
    public String toString() {
        return  nazivPlesa;
    }
}
