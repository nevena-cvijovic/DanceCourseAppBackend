package rs.ac.bg.fon.njt.dancecourseapp.dto;

import java.sql.Date;

public record SignUpDto(String ime, String prezime, Date datumRodjenja,String kontaktTelefon,String mejl, String korisnickoIme, char[] lozinka) {
}
