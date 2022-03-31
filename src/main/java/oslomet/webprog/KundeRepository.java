package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//Angi at det er en repository klasse
@Repository
public class KundeRepository {

    @Autowired
    private JdbcTemplate db;

    //Implementere metoder, for å lagrem hente og slette alle kundene

    public void lagreKunde(Kunde kunde) { //Legger inn ? for verdiene
        String sql = "INSERT  INTO Kunde (Navn,adresse) VALUES(?,?)";

        db.update(sql, kunde.getNavn(), kunde.getAdresse());
    }


    //Metode for å hente ut alle kundene, alle radene i tabellen
    public List<Kunde> hentAlleKunder(){
        String sql = "SELECT * FROM Kunde";

        //Ikke db.update, vi skal ikke gjøre en utdate
        //Vi skal gjøre en spørring, derfor db.query
        List<Kunde> alleKunder = db.query(sql, new BeanPropertyRowMapper(Kunde.class));


        //JavaBean ... et konsept, men visse krav til hvordan en bean skal se ut
        //Lager tom kostruktør for at den skal funke

        //Vi bruker det for å  mappe mellom kolloner i  en database tabelll, og over til felter  i en pojo

        return alleKunder;
    }

    //Metode for å slette alle kundene i tabellen

    public void slettAlleKunder(){

        //Når men ikke velger noe/angir noe spessifikt, sletter du bare alle
        String sql = "DELETE FROM KUNDE";

        db.update(sql);


    }




}
