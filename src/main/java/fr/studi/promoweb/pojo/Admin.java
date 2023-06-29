package fr.studi.promoweb.pojo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long admin_id;

    private String nom;

    public Admin(String nom) {
        this.nom = nom;
    }

    public Admin() {
    }
}
