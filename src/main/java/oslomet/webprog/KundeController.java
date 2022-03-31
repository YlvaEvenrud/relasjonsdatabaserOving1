package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KundeController {

    //Trenger for å kunne lagre data i server i en database
    @Autowired
    KundeRepository rep;


    //Kan fjerne denne nå
    //public final List<Kunde> alleKunder = new ArrayList<>();

    @GetMapping("/lagre")
    public void lagreKunde(Kunde innKunde){
        //alleKunder.add(innKunde);

        // Lagre endepunket: istedenfor å legge til å alleKunder arrayet
        // Så sender vi det til repoet vårt med lagreKunde

        rep.lagreKunde(innKunde); //Lagres i en database

    }


    @GetMapping("/hentAlle")
    public List<Kunde> hentAlle(){
        //return alleKunder;

        return rep.hentAlleKunder();
    }

    @GetMapping("/slettAlle")
    public void slettAlle(){
        //alleKunder.clear();

        rep.slettAlleKunder();
    }
}

