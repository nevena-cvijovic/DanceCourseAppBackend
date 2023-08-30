package rs.ac.bg.fon.njt.dancecourseapp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KursDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.KursEntity;

@Component
public class KursConverter implements Converter<KursEntity, KursDto> {

    PlesConverter plesConverter = new PlesConverter();
    @Override
    public KursEntity toEntity(KursDto dto) {
        return new KursEntity(dto.getIdKursa(),dto.getNazivKursa(),dto.getTrajanjeUNedeljama(),plesConverter.toEntity(dto.getPles()));
    }

    @Override
    public KursDto toDto(KursEntity entity) {
        return new KursDto(entity.getIdKursa(),entity.getNazivKursa(),entity.getTrajanjeUNedeljama(),plesConverter.toDto(entity.getPles()));
    }
}
