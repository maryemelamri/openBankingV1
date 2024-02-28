package elamri.effyis.transaction.service;

import elamri.effyis.transaction.domain.DemandeProducer;
import elamri.effyis.transaction.exception.DemandeAlreadyExistsException;
import elamri.effyis.transaction.exception.DemandeNotFoundException;
import elamri.effyis.transaction.repository.DemandeProducerRepository;
import elamri.effyis.transaction.rmq.entity.MQConfig;
import lombok.extern.slf4j.Slf4j;

import lombok.extern.flogger.*;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DemandeService {

//    @RabbitListener(queues = "${demande.queue}")
//    public void listener(DemandeProducer demande) {
//       //emandeRepository.save(demande);
//        System.out.println(demande);
//
//    }

    @Autowired
    DemandeProducerRepository demandeRepository;
//normalent khas listner i declocha aperes req

    @RabbitListener(queues = "${demande.queue}")
    public void receivedMessage(DemandeProducer demande) {
        DemandeProducer save = demandeRepository.save(demande);

        log.info("persisted " + save);
        log.info("Demande recieved: " + demande);

    }



    public DemandeProducer save(DemandeProducer demandeProducer){
        var existingStudent = demandeRepository.findById(demandeProducer.getId_demande()).orElse(null);
        if(existingStudent != null){
            throw new DemandeAlreadyExistsException("Demande already exists with the given ID.");
        }
        if(demandeProducer.getMontant()< 0.0) {
            demandeProducer.setMontant(0.0);
        }
        if(demandeProducer.getReason() == null){
            demandeProducer.setReason("Reason not specific ");
        }
        return  demandeProducer;

    }

    public List<DemandeProducer> findAll() {
        return demandeRepository.findAll();
    }

    public DemandeProducer findById(Long id) {

        Optional<DemandeProducer> optionalDemande = demandeRepository.findById(id);
        return optionalDemande.orElseThrow(() -> new DemandeNotFoundException("Demande not found with the given ID."));


    }

    public void deleteById(Long id) {
        demandeRepository.deleteById(id);
    }

    public  List<DemandeProducer> findTopTrasaction() {
        return demandeRepository.findTop10ByOrderByMontantDesc();
    }

    public List<DemandeProducer> findByCompteId(Long id) {
        return demandeRepository.findByCompteId(id);
    }



}
