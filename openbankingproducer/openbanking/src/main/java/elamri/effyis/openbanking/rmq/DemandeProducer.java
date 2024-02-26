package elamri.effyis.openbanking.rmq;

import java.io.Serializable;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeProducer implements Serializable {
    @Id
    private long id_demande;
    private long id_compte_to;
    private int id_compte_from;
    private double montant;
    private String reason;

}