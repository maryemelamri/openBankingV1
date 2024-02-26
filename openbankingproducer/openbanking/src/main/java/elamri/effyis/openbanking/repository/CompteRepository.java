package elamri.effyis.openbanking.repository;

import elamri.effyis.openbanking.entity.Agence;
import elamri.effyis.openbanking.entity.Client;
import elamri.effyis.openbanking.entity.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CompteRepository {
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public CompteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean exists(long id) {
        String sqlQuery = "select count(*) from compte where id = ?";

        int result = jdbcTemplate.queryForObject(sqlQuery, Integer.class, id);

        return result == 1;
    }

    public Compte findById(int id) {
        String sqlQuery = "* " +
                "from compte where id = ?";

        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToCompte, id);
    }

    public Compte save(Compte compte) {
        String sqlQuery = "insert into compte(numeroCompte, solde, agence_id, client_id) " +
                "values (?, ?, ?,?)";
        jdbcTemplate.update(sqlQuery,
                compte.getNumeroCompte(),
                compte.getSolde(),
                compte.getAgence().getAdresse(),
                compte.getClient().getId());
        return compte;
    }


    public List<Compte> findAll() {
        String sqlQuery = "select * from compte";
        return jdbcTemplate.query(sqlQuery, this::mapRowToCompte);
    }
    private Compte mapRowToCompte(ResultSet resultSet, int rowNum) throws SQLException {

        return Compte.builder()
                .id(resultSet.getInt(1))
                .numeroCompte(resultSet.getString(2))
                .solde(resultSet.getDouble(3))
                .agence(new Agence(resultSet.getInt(1), resultSet.getString(2)))
                .client(new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)))
                .build();
    }

}
