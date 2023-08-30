package rs.ac.bg.fon.njt.dancecourseapp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.dancecourseapp.dto.PlesDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.PlesEntity;

@Component
public class PlesConverter implements Converter<PlesEntity, PlesDto> {
    @Override
    public PlesEntity toEntity(PlesDto dto) {
        return new PlesEntity(dto.getIdPlesa(),dto.getNazivPlesa());
    }

    @Override
    public PlesDto toDto(PlesEntity entity) {
        return new PlesDto(entity.getIdPlesa(),entity.getNazivPlesa());
    }
}
