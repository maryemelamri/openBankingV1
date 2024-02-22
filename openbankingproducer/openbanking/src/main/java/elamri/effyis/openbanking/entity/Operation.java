package elamri.effyis.openbanking.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    @Id
    private Integer id;
    private String code;

    private Compte compte;
    private double montant;

    @Builder
    public Operation(String code,  Compte compte, double montant) {
        this.code = code;
        this.compte = compte;
        this.montant = montant;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
