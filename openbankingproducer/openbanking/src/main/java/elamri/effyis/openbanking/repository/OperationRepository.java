package elamri.effyis.openbanking.repository;

import elamri.effyis.openbanking.entity.Agence;
import elamri.effyis.openbanking.entity.Client;
import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OperationRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Operation save(Operation operation) {
        // var existingOperation = operationRepository.findByCode(operation.getCode());
        //  if(existingOperation == null){
        String sqlQuery = "insert into operation(code, compte_id, montant) " +
                "values (?, ?, ?)";
        jdbcTemplate.update(sqlQuery,
                operation.getCode(),
                operation.getCompte().getId(),
                operation.getMontant());
        //     }

        return operation;
    }
    public List<Operation> findAll() {
        String sqlQuery = "select * from operation";
        return jdbcTemplate.query(sqlQuery, this::mapRowToOperation);
    }

    public Operation findByCode(String code) {
        String sqlQuery = "SELECT * FROM operation WHERE code = ?";
        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToOperation, code);
    }


    private Operation mapRowToOperation(ResultSet resultSet, int rowNum) throws SQLException {

        return Operation.builder()
                .id(resultSet.getInt(1))
                .code(resultSet.getString(2))
                .compte(new Compte(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3)))
                .montant(resultSet.getDouble(3))
                .build();
    }
}
