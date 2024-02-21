package elamri.effyis.openbanking.repository;

import elamri.effyis.openbanking.entity.Agence;
import elamri.effyis.openbanking.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface AgenceRepository extends CrudRepository<Agence, Integer> {

    Agence findById(int id);
}
