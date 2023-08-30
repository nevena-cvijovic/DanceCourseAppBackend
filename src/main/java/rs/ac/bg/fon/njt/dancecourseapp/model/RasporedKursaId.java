package rs.ac.bg.fon.njt.dancecourseapp.model;

import java.io.Serializable;
import java.util.Objects;

public class RasporedKursaId implements Serializable {
    private GrupaEntity grupa;
    private String danUNedelji;

    public RasporedKursaId() {
    }

    public RasporedKursaId(GrupaEntity grupa, String danUNedelji) {
        this.grupa = grupa;
        this.danUNedelji = danUNedelji;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RasporedKursaId that = (RasporedKursaId) o;
        return Objects.equals(grupa, that.grupa) && Objects.equals(danUNedelji, that.danUNedelji);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupa, danUNedelji);
    }
}
