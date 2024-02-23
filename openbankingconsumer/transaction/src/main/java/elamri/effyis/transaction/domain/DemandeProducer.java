package elamri.effyis.transaction.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeProducer implements Serializable {
    @Id
    private long id_demande;
    private long id_compteTo;
    private int id_compteFrom;
    private double mantant;
    private String reason;

}
