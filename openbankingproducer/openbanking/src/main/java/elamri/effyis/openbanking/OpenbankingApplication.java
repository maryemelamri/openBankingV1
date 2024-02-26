package elamri.effyis.openbanking;
import elamri.effyis.openbanking.entity.Agence;
import elamri.effyis.openbanking.entity.Client;
import elamri.effyis.openbanking.entity.Compte;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class OpenbankingApplication {

    //private static final Logger log = LoggerFactory.getLogger(OpenbankingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OpenbankingApplication.class, args);
    }

//    @Autowired
//    JdbcTemplate jdbcTemplate;

//    @Override
//    public void run(String... args) throws Exception {
//        log.info("Creating tables");
//
//        jdbcTemplate.execute("DROP TABLE IF EXISTS client");
//        jdbcTemplate.execute("CREATE TABLE client(" +
//                "id SERIAL PRIMARY KEY, nom VARCHAR(255), prenom VARCHAR(255))");
//
//        // Split up the list of full names into first and last names
//        List<Object[]> splitUpNames = List.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
//                .stream()
//                .map(name -> name.split(" "))
//                .collect(Collectors.toList());
//
//        // Use a Java stream to log each tuple in the list
//        splitUpNames.forEach(name -> log.info(String.format("Inserting client record for %s %s", name[0], name[1])));
//
//        // Use JdbcTemplate's batchUpdate operation to insert data in bulk
//        jdbcTemplate.batchUpdate("INSERT INTO client(nom, prenom) VALUES (?, ?)", splitUpNames);
//        jdbcTemplate.batchUpdate("INSERT INTO client(nom, prenom) VALUES (?, ?)", splitUpNames);
//
//        log.info("Querying for customer records where nom = 'Josh':");
//        jdbcTemplate.query("SELECT id, nom, prenom FROM client WHERE nom = ?",(rs, rowNum) -> new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom")), "Josh")
//                .forEach(customer -> log.info(customer.toString()));
//
//        // Drop and create the "compte" table
//        jdbcTemplate.execute("DROP TABLE IF EXISTS compte");
//        jdbcTemplate.execute("CREATE TABLE compte(" +
//
//                "id SERIAL PRIMARY KEY, numero_compte VARCHAR(255), solde DOUBLE PRECISION)");
//
//        // Drop and create the "agence" table
//        jdbcTemplate.execute("DROP TABLE IF EXISTS agence");
//        jdbcTemplate.execute("CREATE TABLE agence(" +
//                "id SERIAL PRIMARY KEY, adresse VARCHAR(255))");
//
//// Insert data into the "compte" table
//        List<Object[]> compteData = List.of(
//                new Object[]{"12345", 1000.00},
//                new Object[]{"67890", 2000.00}
//        );
//        jdbcTemplate.batchUpdate("INSERT INTO compte(numero_compte, solde) VALUES (?, ?)", compteData);
//
//// Insert data into the "agence" table
//        List<Object[]> agenceData = List.of(
//                new Object[]{"Address 1"},
//                new Object[]{"Address 2"}
//        );
//        jdbcTemplate.batchUpdate("INSERT INTO agence(adresse) VALUES (?)", agenceData);
//
//// Query the "compte" table
//        log.info("Querying for compte records:");
//        jdbcTemplate.query("SELECT id, numero_compte, solde FROM compte", (rs, rowNum) ->
//                        new Compte(rs.getInt("id"), rs.getString("numero_compte"), rs.getDouble("solde")))
//                .forEach(compte -> log.info(compte.toString()));
//
//// Query the "agence" table
//        log.info("Querying for agence records:");
//        jdbcTemplate.query("SELECT id, adresse FROM agence", (rs, rowNum) ->
//                        new Agence(rs.getInt("id"), rs.getString("adresse")))
//                .forEach(agence -> log.info(agence.toString()));
//        //ajouter logFile
//
//    }
}
