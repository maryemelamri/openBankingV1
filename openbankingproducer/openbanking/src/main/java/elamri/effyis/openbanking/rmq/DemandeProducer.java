package elamri.effyis.openbanking.rmq;

import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor

@Getter
@Setter
@ToString
public class DemandeProducer implements Serializable {
    private int id_compteTo;
    private int id_compteFrom;
    private double montant;
    private String reason;


}
