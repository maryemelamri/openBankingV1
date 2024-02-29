package elamri.effyis.openbanking.service;


import elamri.effyis.openbanking.entity.Compte;

import elamri.effyis.openbanking.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class CompteService {
    @Autowired
    CompteRepository compteRepository;

    @Autowired
    JdbcTemplate temp;

    public Iterable<Compte> findAll() {
      return   compteRepository.findAll();
    }
    //transfer
    public void transfer(String fromAccountId, String toAccountId, double amount) {
        temp.update("update compte set mont=BALANCE-? where ID=?", amount, fromAccountId);
        temp.update("update ACCOUNT set BALANCE=BALANCE+? where ID=?", amount, toAccountId);
    }


    public Compte findCompteById(int id) {
        return compteRepository.findById(id);
    }


    public Compte findByNumeroCompte(String numeroCompte) {
        return compteRepository.findByNumeroCompte(numeroCompte);
    }
}
