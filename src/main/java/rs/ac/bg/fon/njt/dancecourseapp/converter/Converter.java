package rs.ac.bg.fon.njt.dancecourseapp.converter;

import rs.ac.bg.fon.njt.dancecourseapp.dto.ApplicationDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.ApplicationEntity;

public interface Converter<E extends ApplicationEntity, D extends ApplicationDto> {
    E toEntity(D dto);
    D toDto(E entity);
}
