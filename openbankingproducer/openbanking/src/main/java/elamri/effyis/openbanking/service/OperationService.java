package elamri.effyis.openbanking.service;


import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.entity.Operation;
import elamri.effyis.openbanking.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.Objects;

import static java.time.LocalTime.now;


@Service
public class OperationService {

    @Autowired CompteService compteService;
    @Autowired
    OperationRepository operationRepository;
    private OperationService operationService;
    @Autowired
    JdbcTemplate jdbcTemplate;
//Operation(String code,  Compte code, double montant)

    public Operation save(Operation operation) {

            String sqlQuery = "insert into operation(code, compte_id, montant) " +
                    "values (?, ?, ?)";
            jdbcTemplate.update(sqlQuery,
                    operation.getCode(),
                    operation.getCompte().getId(),
                    operation.getMontant());


        return operation;
    }

    public Iterable<Operation> findAll() {
        return operationRepository.findAll();
    }
//a compelter
    public boolean retraitByNumeroCompte(Compte compteCourant, double montant) {
        if (!Objects.isNull(compteCourant)) {
            Compte compte = this.compteService.findByNumeroCompte(compteCourant.getNumeroCompte());
            if (!Objects.isNull(compte)) {
                if (compte.getSolde() >= montant) {
                    compte.setSolde(compte.getSolde() - montant);
                    Operation createOption = new Operation(compteCourant.getNumeroCompte()+now(),compteCourant,montant);
                    operationRepository.save(createOption);
                    return true;
                }
            }
        }
        return false;
    }

}
