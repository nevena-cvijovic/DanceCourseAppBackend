package rs.ac.bg.fon.njt.dancecourseapp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KorisnikDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.KorisnikEntity;

@Component
public class KorisnikConverter implements Converter<KorisnikEntity, KorisnikDto> {
    @Override
    public KorisnikEntity toEntity(KorisnikDto dto) {
        return new KorisnikEntity(dto.getIdKorisnika(),dto.getIme(),dto.getPrezime(),dto.getDatumRodjenja(),dto.getKontaktTelefon(),dto.getMejl(),dto.getKorisnickoIme(),dto.getLozinka());
    }

    @Override
    public KorisnikDto toDto(KorisnikEntity entity) {
        return new KorisnikDto(entity.getIdKorisnika(),entity.getIme(),entity.getPrezime(),entity.getDatumRodjenja(), entity.getKontaktTelefon(),entity.getMejl(),entity.getKorisnickoIme(),entity.getLozinka());
    }
}
