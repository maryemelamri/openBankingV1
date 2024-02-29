package elamri.effyis.openbanking.controller;

import elamri.effyis.openbanking.entity.Agence;
import elamri.effyis.openbanking.entity.Client;
import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.entity.Operation;
import elamri.effyis.openbanking.repository.CompteRepository;
import elamri.effyis.openbanking.repository.AgenceRepository;
import elamri.effyis.openbanking.service.ClientService;
import elamri.effyis.openbanking.service.CompteService;
import elamri.effyis.openbanking.service.OperationService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@RestController
@RequestMapping("/operation")
@Slf4j
public class OperationController {

    @Autowired
    CompteRepository compteRepository;

    @Autowired
    AgenceRepository agenceRepository;
    @Autowired
    CompteService compteService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private OperationService operationService;

    @PostMapping(value = "/createCompte")
    public Compte createCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @PostMapping(value = "/createOperation")
    public Operation createOperation(@RequestBody Operation compte) {
        return operationService.save(compte);
    }

    @PostMapping(value = "/viremantBetweenClientByNumeroCompte")
    public Compte viremantBetweenClientByNumeroCompte(@RequestBody Compte compte) {
         operationService.retraitByNumeroCompte(compte,compte.getSolde());
        return compte;
    }

    @GetMapping("/allClients")
    public Iterable<Client> findAllClients() {
      return clientService.findAllClients();
    }
 @GetMapping("/operations")
    public Iterable<Operation> findAllOperation() {
      return operationService.findAll();
    }


    @GetMapping("/allComptes")
    public Iterable<Compte> findAllComptes() {
        return compteRepository.findAll();

    }
    @GetMapping("/AgenceById")
    public Agence AgenceById(@PathParam(value = "id") int id) {
        return agenceRepository.findById(id) ;

    }

    @GetMapping("/AgenceByAdress")
    public List<Agence> AgenceByAdress(@PathParam(value = "adresse") String adresse) {
        return agenceRepository.getAgenceByadresse(adresse) ;

    }


//    //didnt work why??
//    @GetMapping("/ClientById")
//    public Client ClientById(@PathParam(value = "id") int id) {
//        return clientService.findClientById(id) ;
//    }

    @GetMapping("/allCompte")
    public Iterable<Compte> findAllAgence() {
         return compteService.findAll();

    }
}


