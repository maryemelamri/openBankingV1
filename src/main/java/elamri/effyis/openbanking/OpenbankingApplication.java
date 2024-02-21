package elamri.effyis.openbanking;

import elamri.effyis.openbanking.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class OpenbankingApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(OpenbankingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OpenbankingApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE IF EXISTS client");
        jdbcTemplate.execute("CREATE TABLE client(" +
                "id SERIAL PRIMARY KEY, nom VARCHAR(255), prenom VARCHAR(255))");

        // Split up the list of full names into first and last names
        List<Object[]> splitUpNames = List.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                .stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // Use a Java stream to log each tuple in the list
        splitUpNames.forEach(name -> log.info(String.format("Inserting client record for %s %s", name[0], name[1])));

        // Use JdbcTemplate's batchUpdate operation to insert data in bulk
        jdbcTemplate.batchUpdate("INSERT INTO client(nom, prenom) VALUES (?, ?)", splitUpNames);

        log.info("Querying for customer records where nom = 'Josh':");
        jdbcTemplate.query("SELECT id, nom, prenom FROM client WHERE nom = ?",(rs, rowNum) -> new Client(rs.getLong("id"), rs.getString("nom"), rs.getString("prenom")), "Josh")
                .forEach(customer -> log.info(customer.toString()));
    }

//    @Configuration
//    @EnableWebSecurity
//    class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests(authorizeRequests ->
//                            authorizeRequests
//                                    .antMatchers("/", "/error", "/webjars/**").permitAll()
//                                    .anyRequest().authenticated()
//                    )
//                    .exceptionHandling(exceptionHandling ->
//                            exceptionHandling
//                                    .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                    )
//                    .oauth2Login();
//        }
//    }

//    @Configuration
//    class UserService {
//
//        public Map<String, Object> user(OAuth2User principal) {
//            return Collections.singletonMap("name", principal.getAttribute("name"));
//        }
//    }
}
