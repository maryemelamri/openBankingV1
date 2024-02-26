package elamri.effyis.openbanking.service;

import elamri.effyis.openbanking.entity.Agence;
import elamri.effyis.openbanking.entity.Client;
import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Service
public class CompteService {
    @Autowired
    CompteRepository compteRepository;

    @Autowired
    JdbcTemplate temp;

    public Iterable<Compte> findAll() {
        String sql = "select * from compte";
        RowMapper<Compte> mapper = new RowMapper<Compte>(){
            @Override
            public Compte mapRow(ResultSet rs, int rowNum) throws SQLException {
                Compte a = new Compte();
                a.setId(rs.getInt(1)); // Supposons que l'ID est dans la première colonne
                a.setSolde(rs.getDouble(2)); // Supposons que le nom est dans la deuxième colonne
                a.setMontant(rs.getDouble(3)); // Supposons que la technologie est dans la troisième colonne
                return a;
            }
        };
        List<Compte> cliens = temp.query(sql,mapper);
        return cliens;
    }
    //transfer
    public void transfer(String fromAccountId, String toAccountId, double amount) {
        temp.update("update compte set mont=BALANCE-? where ID=?", amount, fromAccountId);
        temp.update("update ACCOUNT set BALANCE=BALANCE+? where ID=?", amount, toAccountId);
    }

//    public Compte create(Compte compte) {
//        if (Objects.isNull(compte)) return null;
//        return compteRepository.save(compte);
//    }
    public Compte findCompteById(int id) {
        return compteRepository.findById(id);
    }


}
