package elamri.effyis.openbanking.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//implement UserDetails
    public class Personne  {

        @Id
        protected Integer id;

        protected String cin;

        protected String nom;

        protected String prenom;

        protected String adresse;

        protected String email;

        protected String telephone;

        protected Date dateNaissance;

        protected String motDePasse;
}
