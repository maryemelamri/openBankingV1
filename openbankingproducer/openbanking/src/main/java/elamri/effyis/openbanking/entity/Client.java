package elamri.effyis.openbanking.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
@Id
    private int id;
    private String nom, prenom;
    @MappedCollection(idColumn = "client_id", keyColumn = "client_key")
    private List<Compte> comptes;




    public Map<String, Object> toMap() {
        Map<String, Object> values = new HashMap<>();
        values.put("id", this.id);
        values.put("nom", this.nom);
        values.put("prenom", this.prenom);

        if (this.comptes != null) {
            List<Map<String, Object>> comptesList = new ArrayList<>();
            for (Compte compte : this.comptes) {
                Map<String, Object> compteMap = new HashMap<>();
                compteMap.put("numeroCompte", compte.getNumeroCompte());
                compteMap.put("solde", compte.getSolde());
                comptesList.add(compteMap);
            }
            values.put("comptes", comptesList);
        }
        return values;
    }

    public Client(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
    @Override
    public String toString() {
        return String.format("Client [id=%d, firstName='%s', lastName='%s']", id, nom, prenom);
    }
}
