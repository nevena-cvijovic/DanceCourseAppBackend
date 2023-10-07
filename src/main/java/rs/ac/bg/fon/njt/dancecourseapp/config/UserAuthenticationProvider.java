package rs.ac.bg.fon.njt.dancecourseapp.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KorisnikDto;
import rs.ac.bg.fon.njt.dancecourseapp.service.KorisnikService;
import org.springframework.security.core.Authentication;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@Component
public class UserAuthenticationProvider {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    private final KorisnikService korisnikService;

    public UserAuthenticationProvider(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(KorisnikDto korisnikDto){
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000);//jedan sat

        Algorithm algorithm = Algorithm.HMAC256(secretKey);


        return JWT.create()
                .withSubject(korisnikDto.getKorisnickoIme())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withClaim("ime", korisnikDto.getIme())
                .withClaim("prezime", korisnikDto.getPrezime())
                .withClaim("kontaktTelefon",korisnikDto.getKontaktTelefon())
                .withClaim("datumRodjenja",korisnikDto.getDatumRodjenja())
                .withClaim("mejl",korisnikDto.getMejl())
                .sign(algorithm);
    }

    //metoda da validira dekodirani token
    public Authentication validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        DecodedJWT decoded = verifier.verify(token);

        KorisnikDto korisnik = new KorisnikDto();
        korisnik.setKorisnickoIme(decoded.getSubject());
        korisnik.setIme(decoded.getClaim("ime").asString());
        korisnik.setPrezime(decoded.getClaim("prezime").asString());
        korisnik.setKontaktTelefon(decoded.getClaim("kontaktTelefon").asString());

        korisnik.setMejl(decoded.getClaim("mejl").asString());
        return new UsernamePasswordAuthenticationToken(korisnik, null, Collections.emptyList());
    }

    public Authentication validateTokenStrongly(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        DecodedJWT decoded = verifier.verify(token);

        KorisnikDto user = korisnikService.findByKorisnickoIme(decoded.getSubject());

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

}
