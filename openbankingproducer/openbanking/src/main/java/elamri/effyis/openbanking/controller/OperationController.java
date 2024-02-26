package elamri.effyis.openbanking.controller;

import elamri.effyis.openbanking.entity.Agence;
import elamri.effyis.openbanking.entity.Client;
import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.repository.CompteRepository;
import elamri.effyis.openbanking.repositoryPrefered.repository.AgenceRepository;
import elamri.effyis.openbanking.service.ClientService;
import elamri.effyis.openbanking.service.CompteService;
import elamri.effyis.openbanking.service.OperationService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/operation")
@Slf4j
public class OperationController {

    @Autowired
    CompteRepository compteRepository;
    @Autowired
    private OperationService operationService;
    @Autowired
    AgenceRepository agenceRepository;
    @Autowired
    CompteService compteService;
    @Autowired
    private ClientService clientService;


    @PostMapping(value = "/createCompte")
    public Compte createCompte(@RequestBody Compte compte) {

        return compteRepository.save(compte);
    }

    @PostMapping(value = "/depotByNumeroCompte")
    public boolean depotByNumeroCompte(@RequestBody Compte compteCourant, @PathParam(value = "montant") double montant) {
        log.info("depotByNumeroCompte: compteCourant={},montant={}", compteCourant.getNumeroCompte(),montant);
        return operationService.depotByNumeroCompte(compteCourant, montant);
    }

    @GetMapping("/allClients")
    public Iterable<Client> findAllClients() {
      return clientService.findAllClients();

    }


    @GetMapping("/allComptes")
    public Iterable<Compte> findAllComptes() {
        return compteRepository.findAll();

    }
    @GetMapping("/AgenceById")
    public Agence AgenceById(@PathParam(value = "id") int id) {
        return agenceRepository.findById(id) ;

    }

    //didnt work why??
    @GetMapping("/ClientById")
    public Client ClientById(@PathParam(value = "id") int id) {
        return clientService.findClientById(id) ;
    }

    @GetMapping("/allCompte")
    public Iterable<Compte> findAllAgence() {
         return compteService.findAll();

    }
}


