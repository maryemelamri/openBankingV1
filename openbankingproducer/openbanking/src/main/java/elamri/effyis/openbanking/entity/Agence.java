package elamri.effyis.openbanking.entity;

import lombok.*;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.annotation.Id;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agence {
    @Id
    private int id;
    private String adresse;

    @MappedCollection(idColumn = "agence_id", keyColumn = "agence_key")
    private List<Compte> comptes;

    public Agence(int id, String adresse) {
        this.id = id;
        this.adresse = adresse;
    }
}
