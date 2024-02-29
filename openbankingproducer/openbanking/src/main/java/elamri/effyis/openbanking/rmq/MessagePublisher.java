package elamri.effyis.openbanking.rmq;


import elamri.effyis.openbanking.service.CompteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
@Slf4j
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;


    @Autowired
    CompteService compteService;


    @Value("${demande.exchange}")
    private String EXCHANGE ;

    @Value("${demande.route_key}")
    private String ROUTING_KEY ;


    @PostMapping(value = "/depotByNumeroCompte")
    public ResponseEntity<String> depotByNumeroCompte(@RequestBody DemandeProducer demande) {
        log.info("depotByNumeroCompte: compteCourant={},montant={}", demande.getId_compte_to(),demande.getMontant());

        template.convertAndSend(EXCHANGE, ROUTING_KEY, demande);
        return ResponseEntity.ok("depotByNumeroCompte est " +demande.getId_compte_to());
    }
}