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
public class OpenbankingApplication implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(OpenbankingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("DROP TABLE IF EXISTS Operation;");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Compte;");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Client;");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Agence;");

        jdbcTemplate.execute("CREATE TABLE Agence (id INT AUTO_INCREMENT PRIMARY KEY, adresse VARCHAR(255) NOT NULL);");
        jdbcTemplate.execute("CREATE TABLE Client (id INT AUTO_INCREMENT PRIMARY KEY, nom VARCHAR(255) NOT NULL, prenom VARCHAR(255) NOT NULL);");
        jdbcTemplate.execute("CREATE TABLE Compte (id INT AUTO_INCREMENT PRIMARY KEY, numeroCompte VARCHAR(255) NOT NULL, solde DOUBLE NOT NULL, agence_id INT, client_id INT, FOREIGN KEY (agence_id) REFERENCES Agence(id), FOREIGN KEY (client_id) REFERENCES Client(id));");
        jdbcTemplate.execute("CREATE TABLE Operation (id INT AUTO_INCREMENT PRIMARY KEY, code VARCHAR(255), compte_id INT, montant DOUBLE NOT NULL, FOREIGN KEY (compte_id) REFERENCES Compte(id));");

        jdbcTemplate.execute("INSERT INTO Agence (adresse) VALUES ('Address 1'), ('Address 2'), ('Address 3');");
        jdbcTemplate.execute("INSERT INTO Client (nom, prenom) VALUES ('John', 'Doe'), ('Alice', 'Smith'), ('Bob', 'Johnson');");
        jdbcTemplate.execute("INSERT INTO Compte (numeroCompte, solde, agence_id, client_id) VALUES ('123456789', 1000.00, 1, 1), ('987654321', 500.00, 2, 2), ('456789123', 1500.00, 3, 3);");
        jdbcTemplate.execute("INSERT INTO Operation (code, compte_id, montant) VALUES ('ABC123', 1, 100.00), ('DEF456', 2, 50.00), ('GHI789', 3, 200.00);");

        System.out.println("SQL commands executed successfully."); System.out.println("SQL commands executed successfully.");
    }

}