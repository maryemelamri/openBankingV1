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




}
