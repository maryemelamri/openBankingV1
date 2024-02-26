package elamri.effyis.openbanking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import elamri.effyis.openbanking.service.ClientService;
import jdk.dynalink.Operation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Compte {

    @Id
    private int id;

    private String numeroCompte;

    private double solde;

    private Agence agence;
    private Client client;
    private Double montant;
    @Builder
    public Compte( String numeroCompte, double solde, Agence agence, Client client,Double montant) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.agence = agence;
        this.client = client;
        this.montant = montant;
    }

    public Compte(int id, String numeroCompte, double solde) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;

    }
//one to many
  //  protected List<Operation> operations;
}
