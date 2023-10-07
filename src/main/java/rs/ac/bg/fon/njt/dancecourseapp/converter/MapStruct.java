package rs.ac.bg.fon.njt.dancecourseapp.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KorisnikDto;
import rs.ac.bg.fon.njt.dancecourseapp.dto.PrijavaDto;
import rs.ac.bg.fon.njt.dancecourseapp.dto.SignUpDto;
import rs.ac.bg.fon.njt.dancecourseapp.model.KorisnikEntity;
import rs.ac.bg.fon.njt.dancecourseapp.model.PrijavaEntity;

@Mapper(componentModel = "spring")
public interface MapStruct {

    KorisnikDto toKorisnikDto(KorisnikEntity korisnikEntity);

KorisnikEntity korisnikDtoToKorisnikEntity(KorisnikDto korisnikDto);



    @Mapping(target = "lozinka", ignore = true)
    KorisnikEntity signUpToUser(SignUpDto signUpDto);
}
