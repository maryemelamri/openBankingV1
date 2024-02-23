package elamri.effyis.transaction.repository;

import elamri.effyis.transaction.domain.DemandeProducer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeProducerRepository extends CrudRepository<DemandeProducer, Long> {

}