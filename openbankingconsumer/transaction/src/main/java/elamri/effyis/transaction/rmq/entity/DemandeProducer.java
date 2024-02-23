package elamri.effyis.transaction.rmq.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@RequiredArgsConstructor

@Getter
@Setter
@ToString
public class DemandeProducer implements Serializable {
    private long id_compteTo;
    private int id_compteFrom;
    private double mantant;
    private String reason;

}
