package elamri.effyis.openbanking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Agence {
        private int id;
    private String adresse;

    @MappedCollection(idColumn = "agence_id", keyColumn = "agence_key")
    private List<Compte> comptes;

    public Agence(int id, String adresse) {
        this.id = id;
        this.adresse = adresse;
    }
}
