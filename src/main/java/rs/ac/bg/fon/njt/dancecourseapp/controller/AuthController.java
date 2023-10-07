package rs.ac.bg.fon.njt.dancecourseapp.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.njt.dancecourseapp.config.UserAuthenticationProvider;
import rs.ac.bg.fon.njt.dancecourseapp.dto.CredentialsDto;
import rs.ac.bg.fon.njt.dancecourseapp.dto.KorisnikDto;
import rs.ac.bg.fon.njt.dancecourseapp.dto.SignUpDto;
import rs.ac.bg.fon.njt.dancecourseapp.service.KorisnikService;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final KorisnikService korisnikService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    public AuthController(KorisnikService korisnikService,  UserAuthenticationProvider userAuthenticationProvider) {
        this.korisnikService = korisnikService;
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<KorisnikDto> login(@RequestBody CredentialsDto credentialsDto){

        KorisnikDto korisnik = korisnikService.login(credentialsDto);
        korisnik.setToken(userAuthenticationProvider.createToken(korisnik));
        return ResponseEntity.ok(korisnik);
    }

    @PostMapping("/register")
    public ResponseEntity<KorisnikDto> register(@RequestBody @Valid SignUpDto user) {
        KorisnikDto createdUser = korisnikService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getIdKorisnika())).body(createdUser);
    }
}
