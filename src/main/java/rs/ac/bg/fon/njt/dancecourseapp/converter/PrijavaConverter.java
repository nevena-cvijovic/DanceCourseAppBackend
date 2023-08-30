package rs.ac.bg.fon.njt.dancecourseapp.converter;


import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.dancecourseapp.dto.GrupaDto;
import rs.ac.bg.fon.njt.dancecourseapp.dto.PrijavaDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.PrijavaEntity;

@Component
public class PrijavaConverter implements Converter<PrijavaEntity, PrijavaDto> {

   KorisnikConverter korisnikConverter = new KorisnikConverter();
   KursConverter kursConverter = new KursConverter();
   GrupaConverter grupaConverter = new GrupaConverter();
    @Override
    public PrijavaEntity toEntity(PrijavaDto dto) {
        return new PrijavaEntity(korisnikConverter.toEntity(dto.getKorisnik()),kursConverter.toEntity(dto.getKurs()),dto.getDatumPrijave(),dto.getNapomena(),grupaConverter.toEntity(dto.getGrupa()));
    }

    @Override
    public PrijavaDto toDto(PrijavaEntity entity) {
        return new PrijavaDto(korisnikConverter.toDto(entity.getKorisnik()),kursConverter.toDto(entity.getKurs()), entity.getDatumPrijave(),entity.getNapomena(), grupaConverter.toDto(entity.getGrupa()));
    }
}
