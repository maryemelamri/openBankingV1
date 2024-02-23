package elamri.effyis.openbanking.rmq;


import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.service.CompteService;
import elamri.effyis.openbanking.service.OperationService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    OperationService operationService;

    @Autowired
    CompteService compteService;
//
//    @PostMapping(value = "/publish/depotByNumeroCompte")
//    public ResponseEntity<String> depotByNumeroCompte(@RequestBody DemandeProducer demande) {
//        log.info("depotByNumeroCompte: compteCourant={},montant={}", demande.getId_compteTo(),demande.getMontant());
//
//        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, operationService.depotByNumeroCompte(compteService.findCompteById(demande.getId_compteTo()), demande.getMontant()));
//        return ResponseEntity.ok("depotByNumeroCompte est " +operationService.depotByNumeroCompte(compteService.findCompteById(demande.getId_compteTo()), demande.getMontant()));
//    }

    @PostMapping(value = "/publish/depotByNumeroCompte")
    public ResponseEntity<String> depotByNumeroCompte(@RequestBody DemandeProducer demande) {
        log.info("depotByNumeroCompte: compteCourant={},montant={}", demande.getId_compteTo(),demande.getMontant());

        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, demande);
        return ResponseEntity.ok("depotByNumeroCompte est " +demande.getId_compteTo());
    }
}