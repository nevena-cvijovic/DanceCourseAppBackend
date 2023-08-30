package rs.ac.bg.fon.njt.dancecourseapp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.dancecourseapp.dto.RasporedKursaDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.RasporedKursaEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class RasporedKursaConverter implements Converter<RasporedKursaEntity, RasporedKursaDto> {

    GrupaConverter grupaConverter = new GrupaConverter();
    @Override
    public RasporedKursaEntity toEntity(RasporedKursaDto dto) {
        return new RasporedKursaEntity(grupaConverter.toEntity(dto.getGrupa()),dto.getDanUNedelji(),dto.getBrojCasova(),dto.getOpisKursa(),dto.getBrojSale(),dto.getVreme());
    }

    @Override
    public RasporedKursaDto toDto(RasporedKursaEntity entity) {
        return new RasporedKursaDto(grupaConverter.toDto(entity.getGrupa()),entity.getDanUNedelji(),entity.getBrojCasova(),entity.getOpisKursa(),entity.getBrojSale(), entity.getVreme());
    }

    public List<RasporedKursaEntity> toEntities(List<RasporedKursaDto> dtos){
        List<RasporedKursaEntity> entities = new ArrayList<>();
        for (RasporedKursaDto dto: dtos
             ) {
            entities.add(this.toEntity(dto));

        }
        return entities;
    }

    public List<RasporedKursaDto> toDtos(List<RasporedKursaEntity> entities){
        List<RasporedKursaDto> dtos = new ArrayList<>();
        for (RasporedKursaEntity entity: entities
             ) {
            dtos.add(this.toDto(entity));
        }

        return dtos;
    }
}
