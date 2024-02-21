package elamri.effyis.openbanking.service;

import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CompteService {
    @Autowired
    CompteRepository compteRepository;

    public Compte create(Compte compte) {
        if (Objects.isNull(compte)) return null;
        return compteRepository.save(compte);
    }
    public Compte findCompteById(int id) {
        return compteRepository.findById(id);
    }


}
