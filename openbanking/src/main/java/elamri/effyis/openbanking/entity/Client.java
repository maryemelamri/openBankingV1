package elamri.effyis.openbanking.entity;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
@Id
    private int id;
    private String nom, prenom;
    @MappedCollection(idColumn = "client_id", keyColumn = "client_key")
    private List<Compte> compte;


    public Client(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
    @Override
    public String toString() {
        return String.format("Client [id=%d, firstName='%s', lastName='%s']", id, nom, prenom);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Compte> getCompte() {
        return compte;
    }

    public void setCompte(List<Compte> compte) {
        this.compte = compte;
    }
}
