package elamri.effyis.openbanking.controller;

import elamri.effyis.openbanking.entity.Agence;
import elamri.effyis.openbanking.entity.Client;
import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.service.OperationService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OperationController {
    @Autowired
    private OperationService operationService;

    @PostMapping(value = "/createCompte")
    public Compte createCompte(Client client, Agence agence) {
        return operationService.createCompte(client, agence);
    }

    @PostMapping(value = "/depotByNumeroCompte")
    public boolean depotByNumeroCompte(@RequestBody Compte compteCourant, @PathParam(value = "montant") double montant) {
        return operationService.depotByNumeroCompte(compteCourant, montant);
    }
}


