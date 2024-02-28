package elamri.effyis.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Slf4j
public class TransactionApplication {
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@Override
//	public void run(String... args) throws Exception {
//		log.info("Creating tables");
//
//		jdbcTemplate.execute("DROP TABLE IF EXISTS demande_producer");
//		jdbcTemplate.execute("CREATE TABLE demande_producer (\n" +
//				"    id_demande BIGINT PRIMARY KEY,\n" +
//				"    id_compte_to BIGINT NOT NULL,\n" +
//				"    id_compte_from INT NOT NULL,\n" +
//				"    montant DOUBLE NOT NULL,\n" +
//				"    reason VARCHAR(255)\n" +
//				");\n");
//
//	}
		public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}
