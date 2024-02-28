package elamri.effyis.transaction.repository;

import elamri.effyis.transaction.domain.DemandeProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DemandeProducerRepository extends JpaRepository<DemandeProducer,Long> {
     List<DemandeProducer> findTop10ByOrderByMontantDesc();
    @Query("from DemandeProducer p where p.id_compte_from= ?1")
    List<DemandeProducer> findByCompteId(Long id);
}