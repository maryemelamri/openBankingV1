package elamri.effyis.openbanking.service;

import elamri.effyis.openbanking.entity.Agence;
import elamri.effyis.openbanking.entity.Client;
import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.entity.Operation;
import elamri.effyis.openbanking.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Service
public class OperationService {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteService compteService;
    @Autowired
    ClientService clientService;

    public Operation create(Operation object) {
        if (Objects.isNull(object)) return null;
        return this.operationRepository.save(object);
    }

//    public Compte createCompte(Client client, Agence agence,double montant) {
//        Compte c;
//           c= create(Operation.builder().
//                code(client.getNom()+" "+ Time.valueOf(LocalTime.now()))
//                .montant(montant)
//                .compte(this.compteService.create(Compte.builder()
//                        .numeroCompte("")
//                        .solde(montant)
//                        .agence(agence)
//                        .client(this.clientService.create(client))
//                        .build()
//                ))
//                .build()
//        ).getCompte();
//         return c;
//    }

    public boolean depotByNumeroCompte(Compte compteCourant, double montant) {

        return true;
    }
}
