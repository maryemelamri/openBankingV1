package elamri.effyis.openbanking.repository;

import elamri.effyis.openbanking.entity.Compte;
import org.springframework.data.repository.CrudRepository;

public interface CompteRepository extends CrudRepository<Compte, Integer> {

    Compte findById(int id);
}
