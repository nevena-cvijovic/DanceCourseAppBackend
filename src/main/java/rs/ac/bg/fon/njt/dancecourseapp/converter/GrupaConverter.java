package rs.ac.bg.fon.njt.dancecourseapp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.dancecourseapp.dto.GrupaDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.GrupaEntity;

@Component
public class GrupaConverter implements Converter<GrupaEntity, GrupaDto> {

    KursConverter kursConverter = new KursConverter();
  //  RasporedKursaConverter rasporedKursaConverter = new RasporedKursaConverter();
    @Override
    public GrupaEntity toEntity(GrupaDto dto) {
        GrupaEntity grupa = new GrupaEntity();
       // return new GrupaEntity(dto.getIdGrupe(),dto.getNazivGrupe(),dto.getDatumPocetkaKursa(),kursConverter.toEntity(dto.getKurs()),rasporedKursaConverter.toEntities(dto.getRasporediKurseva()));

        grupa.setIdGrupe(dto.getIdGrupe());
        grupa.setNazivGrupe(dto.getNazivGrupe());
        grupa.setDatumPocetkaKursa(dto.getDatumPocetkaKursa());
        grupa.setKurs(kursConverter.toEntity(dto.getKurs()));
    return grupa;

    }

    @Override
    public GrupaDto toDto(GrupaEntity entity) {
       // return new GrupaDto(entity.getIdGrupe(),entity.getNazivGrupe(),entity.getDatumPocetkaKursa(),kursConverter.toDto(entity.getKurs()),rasporedKursaConverter.toDtos(entity.getRasporediKurseva()));

        GrupaDto grupa = new GrupaDto();
        grupa.setIdGrupe(entity.getIdGrupe());
        grupa.setNazivGrupe(entity.getNazivGrupe());
        grupa.setDatumPocetkaKursa(entity.getDatumPocetkaKursa());
        grupa.setKurs(kursConverter.toDto(entity.getKurs()));
        return grupa;
    }
}
